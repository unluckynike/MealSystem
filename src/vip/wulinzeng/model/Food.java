package vip.wulinzeng.model;

/**
 * 菜品实体类
 * @author 22304
 *
 */
public class Food {

	private int id;
	private String foodnameString;
	private String featureString;//特色
	private String materialString;//食材
	private int    price;
	private String    type;//分类
	private String pictureString;
	private int    hits;//点击率
	private String    comment;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFoodnameString() {
		return foodnameString;
	}
	public void setFoodnameString(String foodnameString) {
		this.foodnameString = foodnameString;
	}
	public String getFeatureString() {
		return featureString;
	}
	public void setFeatureString(String featureString) {
		this.featureString = featureString;
	}
	public String getMaterialString() {
		return materialString;
	}
	public void setMaterialString(String materialString) {
		this.materialString = materialString;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPictureString() {
		return pictureString;
	}
	public void setPictureString(String pictureString) {
		this.pictureString = pictureString;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
