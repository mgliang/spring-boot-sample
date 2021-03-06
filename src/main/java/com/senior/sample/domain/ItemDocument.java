package com.senior.sample.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * 商品Document -example
 * <p>
 */
@Document(indexName = ItemDocument.INDEX, type = ItemDocument.TYPE)
public class ItemDocument {

	public static final String INDEX = "items";
	public static final String TYPE = "item";

	public ItemDocument() {
	}

	public ItemDocument(String id, Integer catId, String name, Long price, String description) {
		this.id = id;
		this.catId = catId;
		this.name = name;
		this.price = price;
		this.description = description;
	}

	/**
	 * 商品唯一标识
	 */
	@Id
	@Field(type = FieldType.keyword)
	private String id;

	/**
	 * 类目id
	 */
	@Field(type = FieldType.Integer)
	private Integer catId;

	/**
	 * 商品名称
	 */
	@Field(type = FieldType.text, index = false)
	private String name;

	/**
	 * 商品价格
	 */
	@Field(type = FieldType.Long)
	private Long price;

	/**
	 * 商品的描述
	 */
	@Field(type = FieldType.text, searchAnalyzer = "ik", analyzer = "ik")
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getCatId() {
		return catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ItemDocument{" + "id='" + id + '\'' + ", catId=" + catId + ", name='" + name + '\'' + ", description='"
				+ description + '\'' + ", price=" + price + '}';
	}
}