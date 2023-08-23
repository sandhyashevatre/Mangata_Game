package com.learning.hello.model;

public class Card {
	
	private final int rank;
	private final int suit;
	
	public static final String ABBR_RANKS = " A23456789TJQK";
	public static final String ABBR_SUITS = " CDHS";
	
	public static final int MIN_RANK = 1;
	public static final int MAX_RANK = 13;
	public static final int MIN_SUIT = 1;
	public static final int MAX_SUIT = 4;
	
	public static final int CLUBS = 1;
	public static final int DIAMONDS = 2;
	public static final int HEARTS = 3;
	public static final int SPADES = 4;
	
	public static final String BLACK = "Black";
	public static final String RED = "Red";
	
	public Card(int newRank, int newSuit) {
		if (newRank > MAX_RANK || newRank < MIN_RANK) {
			System.out.println("hey, not allowed, expect invalid behaviour");
			rank = 0;
			suit = 0;
		}
		else if (newSuit > MAX_SUIT || newSuit < MIN_SUIT) {
			System.out.println("hey, not allowed, expect invalid behaviour");
			rank = 0;
			suit = 0;
		}
		else {
			rank = newRank;
			suit = newSuit;
		}
	}
	
	/*
	 * Requires an input String abbr
	 * That is formatted as `RS`
	 * where R is one among A23456789TJQK
	 * and S is one among CDHS
	 */
	public Card(String abbr) {
		int parsedRank = ABBR_RANKS.indexOf(abbr.charAt(0));
		if (parsedRank == -1) {
			System.out.println("Invalid rank, expect invalid behaviour");
			rank = 0;
		}
		else
			rank = parsedRank;
		int parsedSuit = ABBR_SUITS.indexOf(abbr.charAt(1));
		if (parsedSuit == -1) {
			System.out.println("Invalid suit, expect invalid behaviour");
			suit = 0;
		}
		else
			suit = parsedSuit;
	}
	
	public int getRank() {
		return rank;
	}
	
	public int getSuit() {
		return suit;
	}
	
	public String color() {
		return (suit == SPADES || suit == CLUBS) ? BLACK : RED;
	}
	
	public boolean isFaceCard() {
		return isFaceCard(false);
	}
	
	public boolean isFaceCard(boolean isAceIncluded) {
		if (isAceIncluded)
			return (rank == 1 || rank > 10);
		else
			return rank > 10;
	}
	
	@Override
	public String toString() {
		return ABBR_RANKS.substring(rank, rank+1) + ABBR_SUITS.substring(suit, suit+1);
	}
}