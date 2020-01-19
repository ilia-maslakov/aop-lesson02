package sut.ism71z.maslakoviv.lesson02;

public class Greeting {

	private long id;
	private final String content;

	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {

		System.out.println("original id:" + id);
		return id;
	}

	public String getContent() {
		return content;
	}
}
