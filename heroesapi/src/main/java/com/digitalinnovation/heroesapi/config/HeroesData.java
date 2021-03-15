package com.digitalinnovation.heroesapi.config;

import com.amazonaws.client.builder.AwsClientBuilder; 
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder; 

import com.amazonaws.services.dynamodbv2.document.DynamoDB; 
import com.amazonaws.services.dynamodbv2.document.Table; 
import com.amazonaws.services.dynamodbv2.document.Item; 
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome; 
import static com.digitalinnovation.heroesapi.constans.HeroesConstant.REGION_DYNAMO; 
import static com.digitalinnovation.heroesapi.constans.HeroesConstant.ENDPOINT_DYNAMO; 



public class HeroesData {
	public static void main (String [] args) throws Exception{
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO,REGION_DYNAMO))
				.build();
		
		DynamoDB dynamoDB = new DynamoDB(client);
		
		Table table = dynamoDB.getTable("Heroes_Table");
		Item hero = new Item()
				.withPrimaryKey ( "id", "1")
				.withString( "name", "Mulher Maravilha")
				.withString("universe", "DC")
				.withNumber("films", 3);
		
		Item hero1 = new Item()
				.withPrimaryKey ( "id", "2")
				.withString( "name", "Feiticeira Escarlate")
				.withString("universe", "Marvel")
				.withNumber("films", 2);
		
		Item hero2 = new Item()
				.withPrimaryKey ( "id", "3")
				.withString( "name", "Homem de Ferro")
				.withString("universe", "Marvel")
				.withNumber("films", 5);
		
		Item hero3 = new Item()
				.withPrimaryKey ( "id", "4")
				.withString( "name", "Batman")
				.withString("universe", "DC")
				.withNumber("films", 3);
		
		PutItemOutcome outcome = table.putItem(hero);
		PutItemOutcome outcome1 = table.putItem(hero1);
		PutItemOutcome outcome2 = table.putItem(hero2);
		PutItemOutcome outcome3 = table.putItem(hero3);
	}

}
