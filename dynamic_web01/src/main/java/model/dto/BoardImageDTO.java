package model.dto;

public class BoardImageDTO {
	
	private int id;
	private int BoardId;
	private String name;
	private String path;
	private String uuid;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBoardId() {
		return BoardId;
	}
	public void setBoardId(int boardId) {
		BoardId = boardId;
	}
	
	
}
