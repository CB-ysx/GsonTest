package com.xiaoxiong.gsontest;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.xiaoxiong.bean.ResultBean;
import com.xiaoxiong.gsontext.R;
import com.xiaoxiong.utils.MD5Utils;

/**
 * 
 * @ClassName: MainActivity 
 * @Description: 百度翻译例子
 * @author smile
 * @date 2016年5月12日 下午1:09:27 
 *
 */
public class MainActivity extends Activity implements OnClickListener {

	/**
	 * 请求成功
	 */
	private final static int SUCCESS = 1;
	/**
	 * 请求失败
	 */
	private final static int FAILE = 0;
	/**
	 * 显示数据
	 */
	private TextView showText;
	/**
	 * 发送按钮
	 */
	private Button send;
	private Gson gson;
	/**
	 * 请求地址
	 */
	private final static String URL = "http://api.fanyi.baidu.com/api/trans/vip/translate";
	/**
	 * 百度翻译appid
	 */
	private final static String APPID = "你的appid";
	/**
	 * 百度翻译秘钥
	 */
	private final static String PASSWORD = "你的秘钥";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initData();
	}

	private void initData() {
		gson = new Gson();
		showText = (TextView) findViewById(R.id.showtext);
		send = (Button) findViewById(R.id.send);
		send.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.send:
			send();
			break;
		}
	}

	@SuppressLint("HandlerLeak")
	private Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			String response;
			switch (msg.what) {
			case SUCCESS:
				Log.d("status", "success");
				response = msg.obj.toString();

				/**
				 * 用gson解析
				 */
				ResultBean resultBean = gson.fromJson(response,
						ResultBean.class);
				String result = "from:" + resultBean.getFrom() + "\nto:"
						+ resultBean.getTo() + "\ntrans_result:\nsrc:"
						+ resultBean.getTransResult().get(0).getSrc()
						+ "\ndst:"
						+ resultBean.getTransResult().get(0).getDst();
				showText.setText(result);
				break;
			case FAILE:
				Log.d("status", "fail");
				response = msg.obj.toString();
				showText.setText(response);
				break;
			}
		};
	};

	private void send() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					HttpClient httpClient = new DefaultHttpClient();

					HttpPost httpPost = new HttpPost(URL);
					List<NameValuePair> params = new ArrayList<NameValuePair>();
					params.add(new BasicNameValuePair("q", "要翻译的文本"));
					params.add(new BasicNameValuePair("from", "zh"));
					params.add(new BasicNameValuePair("to", "en"));
					params.add(new BasicNameValuePair("appid", APPID));
					params.add(new BasicNameValuePair("salt", "1234567890"));

					/**
					 * 进行MD5加密
					 */
					params.add(new BasicNameValuePair("sign", MD5Utils
							.md5(APPID + "要翻译的文本" + "1234567890" + PASSWORD)));
					UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(
							params, "utf-8");
					httpPost.setEntity(urlEncodedFormEntity);

					HttpResponse httpResponse = httpClient.execute(httpPost);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						HttpEntity entity = httpResponse.getEntity();
						String response = EntityUtils.toString(entity, "utf-8");

						Message message = new Message();
						message.what = SUCCESS;
						message.obj = response;
						mHandler.sendMessage(message);
					} else {
						Message message = new Message();
						message.what = FAILE;
						message.obj = "请求失败";
						mHandler.sendMessage(message);
					}
				} catch (Exception e) {
					Message message = new Message();
					message.what = FAILE;
					message.obj = "请求失败";
					mHandler.sendMessage(message);
					e.printStackTrace();
				}
			}

		}).start();
	}

}
