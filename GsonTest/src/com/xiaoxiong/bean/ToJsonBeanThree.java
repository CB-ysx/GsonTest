package com.xiaoxiong.bean;

import java.util.List;

/**
 * 
 * @ClassName: ToJsonBeanThree
 * @Description: 即带对象又带数组的json数据，java中List代表json中的数组
 * @author smile
 * @date 2016年5月12日 上午11:55:29
 * 
 */
public class ToJsonBeanThree {
	private String number;
	private ToJsonBeanTwo toJsonBeanTwo;
	private List<Book> books;

	public ToJsonBeanThree(String number, ToJsonBeanTwo toJsonBeanTwo,
			List<Book> books) {
		super();
		this.number = number;
		this.toJsonBeanTwo = toJsonBeanTwo;
		this.books = books;
	}

	public ToJsonBeanTwo getToJsonBeanTwo() {
		return toJsonBeanTwo;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setToJsonBeanTwo(ToJsonBeanTwo toJsonBeanTwo) {
		this.toJsonBeanTwo = toJsonBeanTwo;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {

		String resultString = "";
		resultString += "number:" + number + "\n";
		ToJsonBeanOne toJsonBeanOne = toJsonBeanTwo.getToJsonBeanOne();
		resultString += "toJsonBeanTwo:\nschool:" + toJsonBeanTwo.getSchool()
				+ "\nclassroom:" + toJsonBeanTwo.getClassroom() + "\n";
		resultString += "toJsonBeanOne:\nid:" + toJsonBeanOne.getId()
				+ "\nname:" + toJsonBeanOne.getName() + "\nage:"
				+ toJsonBeanOne.getAge() + "\n";
		resultString += "books:\n";

		for (int i = 0; i < books.size(); ++i) {
			resultString += "bookName:" + books.get(i).getBookName()
					+ "\nprice:" + books.get(i).getPrice() + "\n";
		}

		return resultString;
	}

	/**
	 * 
	 * @ClassName: Book
	 * @Description: 内部类
	 * @author smile
	 * @date 2016年5月12日 上午12:23:42
	 * 
	 */
	public static class Book {
		private String bookName;
		private float price;

		public Book(String bookName, float price) {
			super();
			this.bookName = bookName;
			this.price = price;
		}

		public String getBookName() {
			return bookName;
		}

		public float getPrice() {
			return price;
		}

		public void setBookName(String bookName) {
			this.bookName = bookName;
		}

		public void setPrice(float price) {
			this.price = price;
		}

	}
}
