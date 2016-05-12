package com.xiaoxiong.gsontest;

import java.lang.reflect.Type;
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
import com.google.gson.reflect.TypeToken;
import com.xiaoxiong.bean.GsonBuilderBeanOne;
import com.xiaoxiong.bean.GsonBuilderBeanThree;
import com.xiaoxiong.bean.GsonBuilderBeanTwo;
import com.xiaoxiong.bean.ToJsonBeanOne;
import com.xiaoxiong.bean.ToJsonBeanThree;
import com.xiaoxiong.bean.ToJsonBeanThree.Book;
import com.xiaoxiong.bean.ToJsonBeanTwo;
import com.xiaoxiong.gsontext.R;

/**
 * 
 * @ClassName: FromJsonTest
 * @Description: 把json数据转换为java对象
 * @author smile
 * @date 2016年5月12日 上午11:56:37
 * 
 */
public class FromJsonTest extends Activity {

	/**
	 * 显示数据的textview
	 */
	private TextView show;
	/**
	 * 按钮
	 */
	private Button start;
	/**
	 * gson
	 */
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

	/**
	 * 
	 * @Title: showData
	 * @Description: 显示数据
	 * @param
	 * @return void
	 * @throws
	 */
	private void showData() {
		String showString = "";

//		showString += one();
//		showString += two();
//		showString += three();
//		showString += four();
//		showString += five();
//		showString += six();
//		showString += seven();
//		showString += eight();
//		showString += nine();
//		showString += ten();
//		showString += eleven();
		showString += twelve();

		show.setText(showString);

	}

	/**
	 * 
	 * @Title: one
	 * @Description: 解析普通json数据
	 * @param @return
	 * @return String
	 * @throws
	 */
	private String one() {

		ToJsonBeanOne toJsonBeanOne = new ToJsonBeanOne(1, "小熊", 21);
		String jsonString = gson.toJson(toJsonBeanOne);
		ToJsonBeanOne beanOne = gson.fromJson(jsonString, ToJsonBeanOne.class);

		String showString = "";
		showString += "json:" + jsonString + "\n解析结果为：\n" + beanOne.toString();

		showString += "----------------------\n";
		return showString;
	}

	/**
	 * 
	 * @Title: two
	 * @Description: 解析数组的json数据
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
		String jsonString = gson.toJson(toJsonBeanOnes);

		Type type = new TypeToken<List<ToJsonBeanOne>>() {
		}.getType();
		List<ToJsonBeanOne> beanOnes = gson.fromJson(jsonString, type);

		String showString = "";
		showString += "json:" + jsonString + "\n解析后的数据：\n";
		for (ToJsonBeanOne one : beanOnes) {
			showString += one.toString() + "------\n";
		}

		showString += "----------------------\n";

		return showString;
	}

	/**
	 * 
	 * @Title: three
	 * @Description: 解析带对象的json数据
	 * @param @return
	 * @return String
	 * @throws
	 */
	private String three() {

		ToJsonBeanTwo toJsonBeanTwo = new ToJsonBeanTwo("华软", "软工五班",
				new ToJsonBeanOne(1, "小熊", 21));
		String jsonString = gson.toJson(toJsonBeanTwo);

		ToJsonBeanTwo beanTwo = gson.fromJson(jsonString, ToJsonBeanTwo.class);

		String showString = "";
		showString += "json:" + jsonString + "\n解析后的数据：\n" + beanTwo.toString();

		showString += "----------------------\n";

		return showString;
	}

	/**
	 * 
	 * @Title: four
	 * @Description: 解析数组的带对象的json数据
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

		String jsonString = gson.toJson(toJsonBeanTwos);

		Type type = new TypeToken<List<ToJsonBeanTwo>>() {
		}.getType();
		List<ToJsonBeanTwo> beanTwos = gson.fromJson(jsonString, type);
		String showString = "";
		showString += "json:" + jsonString + "\n解析后的数据：\n";
		for (ToJsonBeanTwo beanTwo : beanTwos) {
			showString += beanTwo.toString() + "------\n";
		}

		showString += "----------------------\n";
		return showString;
	}

	/**
	 * 
	 * @Title: five
	 * @Description: 解析带对象及带数组的json数据
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

		String jsonString = gson.toJson(toJsonBeanThree);

		ToJsonBeanThree beanThree = gson.fromJson(jsonString,
				ToJsonBeanThree.class);

		String showString = "";
		showString += "json:" + jsonString + "\n解析后的数据：\n"
				+ beanThree.toString();

		showString += "----------------------\n";
		return showString;
	}

	/**
	 * 
	 * @Title: six
	 * @Description: 解析数组的带对象及带数组的json数据
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

		String jsonString = gson.toJson(toJsonBeanThrees);

		Type type = new TypeToken<List<ToJsonBeanThree>>() {
		}.getType();
		List<ToJsonBeanThree> beanThrees = gson.fromJson(jsonString, type);

		String showString = "";
		showString += "json:" + jsonString + "\n解析后的数据：\n";

		for (ToJsonBeanThree beanThree : beanThrees) {
			showString += beanThree.toString() + "------\n";
		}

		showString += "----------------------\n";
		return showString;
	}

	/**
	 * 
	 * @Title: seven
	 * @Description: 解析json数据，Map<String, String>格式
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

		String jsonString = gson.toJson(map);
		Type type = new TypeToken<Map<String, String>>() {
		}.getType();
		Map<String, String> map2 = gson2.fromJson(jsonString, type);

		String showString = "";
		for (String keyString : map2.keySet()) {
			showString += keyString + ":" + map2.get(keyString) + "\n-----\n";
		}

		showString += "----------------------\n";
		return showString;
	}

	/**
	 * 
	 * @Title: eight
	 * @Description: 解析json数据，Map<Object, String>格式
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

		String jsonString = gson2.toJson(map);

		Type type = new TypeToken<Map<ToJsonBeanOne, String>>() {
		}.getType();
		Map<ToJsonBeanOne, String> map2 = gson.fromJson(jsonString, type);

		String showString = "";
		for (ToJsonBeanOne beanOne : map2.keySet()) {
			showString += "key:\n" + beanOne.toString() + "value:"
					+ map2.get(beanOne) + "\n-----\n";
		}

		showString += "----------------------\n";
		return showString;
	}

	/**
	 * 
	 * @Title: nine
	 * @Description: 解析json数据，Map<String, Object>格式
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
		String jsonString = gson2.toJson(map);

		Type type = new TypeToken<Map<String, ToJsonBeanOne>>() {
		}.getType();
		Map<String, ToJsonBeanOne> map2 = gson.fromJson(jsonString, type);

		String showString = "";
		for (String keyString : map2.keySet()) {
			showString += "key:\n" + keyString + "\nvalue:\n"
					+ map2.get(keyString).toString() + "-----\n";
		}

		showString += "----------------------\n";
		return showString;
	}

	/**
	 * 
	 * @Title: ten
	 * @Description: 解析json数据，带注解的例子
	 * @param @return
	 * @return String
	 * @throws
	 */
	private String ten() {
		Gson gson2 = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();

		String showString = "";
		String jsonString = "{'username':'144','password':'123','school':'华软','classroom':'软工五班','sex':'男'}";

		showString += "json:" + jsonString + "\n解析后的数据：\n";
		GsonBuilderBeanOne beanOne = gson2.fromJson(jsonString,
				GsonBuilderBeanOne.class);
		showString += beanOne.toString();

		showString += "----------------------\n";
		return showString;
	}

	/**
	 * 
	 * @Title: eleven
	 * @Description: 解析json数据，自定义字段名
	 * @param @return
	 * @return String
	 * @throws
	 */
	private String eleven() {

		GsonBuilderBeanTwo gsonBuilderBeanTwo = new GsonBuilderBeanTwo("144",
				"123");

		String showString = "";
		String jsonString = gson.toJson(gsonBuilderBeanTwo);
		showString += "json:" + jsonString + "\n解析后的数据：\n";
		GsonBuilderBeanTwo beanTwo = gson.fromJson(jsonString,
				GsonBuilderBeanTwo.class);

		showString += beanTwo.toString();

		showString += "----------------------\n";
		return showString;
	}

	/**
	 * 
	 * @Title: twelve
	 * @Description: 解析json数据，根据版本号
	 * @param @return
	 * @return String
	 * @throws
	 */
	private String twelve() {

		Gson gson2 = new GsonBuilder().setVersion(1.0).create();

		String showString = "";
		String jsonString = "{'username':'144','password':'123'}";
		showString += "json:" + jsonString + "\n解析后的数据：\n";
		GsonBuilderBeanThree beanThree = gson2.fromJson(jsonString,
				GsonBuilderBeanThree.class);

		showString += beanThree.toString();

		showString += "----------------------\n";
		return showString;
	}
}
