package com.xiaoxiong.gsontest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xiaoxiong.bean.GsonBuilderBeanOne;
import com.xiaoxiong.bean.GsonBuilderBeanThree;
import com.xiaoxiong.bean.GsonBuilderBeanTwo;
import com.xiaoxiong.bean.ToJsonBeanOne;
import com.xiaoxiong.bean.ToJsonBeanThree;
import com.xiaoxiong.bean.ToJsonBeanThree.Book;
import com.xiaoxiong.bean.ToJsonBeanTwo;
import com.xiaoxiong.gsontext.R;

public class ToJsonTest extends Activity {

	private TextView show;
	private Button start;
	private Gson gson;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initData();
	}

	private void initData() {

		gson = new Gson();
		show = (TextView) findViewById(R.id.showtext);
		start = (Button) findViewById(R.id.send);
		start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showData();
			}
		});
	}

	private void showData() {

		String resultString = "";

//		resultString = one() + "\n\n";
//		resultString += two() + "\n\n";
//		resultString += three() + "\n\n";
//		resultString += four() + "\n\n";
//		resultString += five() + "\n\n";
//		resultString += six() + "\n\n";
//		resultString += seven() + "\n\n";
//		resultString += eight() + "\n\n";
//		resultString += nine() + "\n\n";
//		resultString += ten() + "\n\n";
//		resultString += eleven() + "\n\n";
		resultString += twelve() + "\n\n";

		show.setText(resultString);
	}

	/**
	 * 
	 * @Title: one
	 * @Description: 将对象序列化，普通json格式的对象
	 * @param @return
	 * @return String
	 * @throws
	 */
	private String one() {

		ToJsonBeanOne toJsonBeanOne = new ToJsonBeanOne(1, "小熊", 21);

		return gson.toJson(toJsonBeanOne);
	}

	/**
	 * 
	 * @Title: two
	 * @Description: 将list数据序列化
	 * @param @return
	 * @return String
	 * @throws
	 */
	private String two() {

		List<ToJsonBeanOne> toJsonBeanOnes = new ArrayList<ToJsonBeanOne>();
		for (int i = 1; i < 5; ++i) {
			ToJsonBeanOne toJsonBeanOne = new ToJsonBeanOne(i, "小熊" + i, 21);
			toJsonBeanOnes.add(toJsonBeanOne);
		}

		return gson.toJson(toJsonBeanOnes);
	}

	/**
	 * 
	 * @Title: three
	 * @Description: 序列化带对象的对象
	 * @param @return
	 * @return String
	 * @throws
	 */
	private String three() {

		ToJsonBeanTwo toJsonBeanTwo = new ToJsonBeanTwo("华软", "软工五班",
				new ToJsonBeanOne(1, "小熊", 21));

		return gson.toJson(toJsonBeanTwo);
	}

	/**
	 * 
	 * @Title: four
	 * @Description: 序列化list的带对象的对象
	 * @param @return
	 * @return String
	 * @throws
	 */
	private String four() {

		List<ToJsonBeanTwo> toJsonBeanTwos = new ArrayList<ToJsonBeanTwo>();

		for (int i = 1; i < 5; ++i) {
			ToJsonBeanTwo toJsonBeanTwo = new ToJsonBeanTwo("华软", "软工五班",
					new ToJsonBeanOne(i, "小熊" + i, 21));
			toJsonBeanTwos.add(toJsonBeanTwo);
		}

		return gson.toJson(toJsonBeanTwos);
	}

	/**
	 * 
	 * @Title: five
	 * @Description: 序列化带数组（list）的对象
	 * @param @return
	 * @return String
	 * @throws
	 */
	private String five() {

		ToJsonBeanTwo toJsonBeanTwo = new ToJsonBeanTwo("华软", "软工五班",
				new ToJsonBeanOne(1, "小熊", 21));
		List<Book> books = new ArrayList<Book>();
		for (int i = 1; i < 5; ++i) {
			books.add(new Book("第" + i + "本书", 25f * i));
		}
		ToJsonBeanThree toJsonBeanThree = new ToJsonBeanThree("1",
				toJsonBeanTwo, books);

		return gson.toJson(toJsonBeanThree);
	}

	/**
	 * 
	 * @Title: six
	 * @Description: 序列化list的带数组（list）的对象
	 * @param @return
	 * @return String
	 * @throws
	 */
	private String six() {

		List<ToJsonBeanThree> toJsonBeanThrees = new ArrayList<ToJsonBeanThree>();

		for (int i = 1; i < 5; ++i) {
			ToJsonBeanTwo toJsonBeanTwo = new ToJsonBeanTwo("华软", "软工五班",
					new ToJsonBeanOne(i, "小熊" + i, 21));
			List<Book> books = new ArrayList<Book>();
			for (int j = i * 1; j < i * 1 + 5; ++j) {
				books.add(new Book("第" + j + "本书", 25f * j));
			}
			ToJsonBeanThree toJsonBeanThree = new ToJsonBeanThree("1",
					toJsonBeanTwo, books);
			toJsonBeanThrees.add(toJsonBeanThree);
		}

		return gson.toJson(toJsonBeanThrees);
	}

	/**
	 * 
	 * @Title: seven
	 * @Description: 序列化Map<String, String>
	 * @param @return
	 * @return String
	 * @throws
	 */
	private String seven() {
		Gson gson2 = new GsonBuilder().enableComplexMapKeySerialization()
				.create();
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");

		return gson2.toJson(map);
	}

	/**
	 * 
	 * @Title: eight
	 * @Description: 序列化Map<Object, String>
	 * @param @return
	 * @return String
	 * @throws
	 */
	private String eight() {
		Gson gson2 = new GsonBuilder().enableComplexMapKeySerialization()
				.create();
		Map<ToJsonBeanOne, String> map = new LinkedHashMap<ToJsonBeanOne, String>();
		map.put(new ToJsonBeanOne(1, "小熊1", 21), "value1");
		map.put(new ToJsonBeanOne(2, "小熊2", 21), "value2");
		map.put(new ToJsonBeanOne(3, "小熊3", 21), "value3");

		return gson2.toJson(map);
	}

	/**
	 * 
	 * @Title: nine
	 * @Description: 序列化Map<String, Object>
	 * @param @return
	 * @return String
	 * @throws
	 */
	private String nine() {
		Gson gson2 = new GsonBuilder().enableComplexMapKeySerialization()
				.create();
		Map<String, ToJsonBeanOne> map = new LinkedHashMap<String, ToJsonBeanOne>();
		map.put("key1", new ToJsonBeanOne(1, "小熊1", 21));
		map.put("key2", new ToJsonBeanOne(2, "小熊2", 21));
		map.put("key3", new ToJsonBeanOne(3, "小熊3", 21));

		return gson2.toJson(map);
	}

	/**
	 * 
	 * @Title: ten
	 * @Description: 序列化带注解对象
	 * @param @return
	 * @return String
	 * @throws
	 */
	private String ten() {
		Gson gson2 = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();

		GsonBuilderBeanOne gsonBuilderBeanOne = new GsonBuilderBeanOne("144",
				"123", "华软", "软工五班", "男");

		return gson2.toJson(gsonBuilderBeanOne);
	}

	/**
	 * 
	 * @Title: eleven
	 * @Description: 序列化自定义字段名注解对象
	 * @param @return
	 * @return String
	 * @throws
	 */
	private String eleven() {

		GsonBuilderBeanTwo gsonBuilderBeanTwo = new GsonBuilderBeanTwo("144",
				"123");

		return gson.toJson(gsonBuilderBeanTwo);
	}

	/**
	 * 
	 * @Title: twelve
	 * @Description: 序列化带版本号注解的对象
	 * @param @return
	 * @return String
	 * @throws
	 */
	private String twelve() {

		Gson gson2 = new GsonBuilder().setVersion(1.1).create();
		GsonBuilderBeanThree gsonBuilderBeanThree = new GsonBuilderBeanThree(
				"144", "123");

		return gson2.toJson(gsonBuilderBeanThree);
	}
}
