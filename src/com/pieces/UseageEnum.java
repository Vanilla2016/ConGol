package com.pieces;

public enum UseageEnum
{
	CREATE("create"),
	COUNT("count"),
	DRAW("draw"),
	GETACTIVE("activate");
	
private final String attributeType;
		
	UseageEnum(String aType){
			attributeType = aType;
		}
	
	public String getAttributeType(){
		return attributeType;
	}
}
