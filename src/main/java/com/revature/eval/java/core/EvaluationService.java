package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		int size = string.length();
		char[] chars = string.toCharArray();
        String reversed = "";
		for (int i = size - 1; i >= 0; i--) {
				reversed += chars[i];
		}
		return reversed;
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		String acronym = "";
		String[] words = phrase.split(" |\\-");
		for (String s: words) {
			acronym += s.charAt(0);
		}
		return acronym.toUpperCase();
	}	

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if ((this.sideOne == this.sideTwo) && (this.sideTwo == this.sideThree) && (this.sideOne == this.sideThree)) {
				return true;
			}
			return false;
		}

		public boolean isIsosceles() {
			if ((this.isEquilateral() == false) && (this.isScalene() == false)) {
				return true;
			}
			
			return false;
		}

		public boolean isScalene() {
			if ((this.sideOne != this.sideTwo) && (this.sideTwo != this.sideThree) && (this.sideOne != this.sideThree)) {
				return true;
			}
			return false;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
        HashMap<Character, Integer> values = new HashMap<Character, Integer>();
        values.put('A',1);
        values.put('B',3);
        values.put('C',3);
        values.put('D',2);
        values.put('E',1);
        values.put('F',4);
        values.put('G',2);
        values.put('H',4);
        values.put('I',1);
        values.put('J',8);
        values.put('K',5);
        values.put('L',1);
        values.put('M',3);
        values.put('N',1);
        values.put('O',1);
        values.put('P',3);
        values.put('Q',10);
        values.put('R',1);
        values.put('S',1);
        values.put('T',1);
        values.put('U',1);
        values.put('V',4);
        values.put('W',4);
        values.put('X',8);
        values.put('Y',4);
        values.put('Z',10);

		int value = 0; 
		for (char c : string.toCharArray()) {
			value += values.get(Character.toUpperCase(c));
		}
		
	return value;
	}
	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
    public String cleanPhoneNumber(String string) {
        String phoneNumber = "";
        for (char c : string.toCharArray()) {
        	if (Character.isLetter(c)) {
        		throw new IllegalArgumentException();
        	}
            if (Character.isDigit(c)) {
                phoneNumber += c;
            }
        }
        if (phoneNumber.substring(0,1).equals("1")) {
            StringBuilder sb = new StringBuilder(phoneNumber);
            return sb.substring(1);
        }
        
        if ((phoneNumber.length() > 10) || (phoneNumber.contains("-"))) {
        	throw new IllegalArgumentException();
        }
        return phoneNumber;
    }
	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		Map<String, Integer> wordCount = new HashMap<String, Integer>();
		string = string.replace(",", " ");
		string = string.replace("\n", "");		
		for (String word : string.split(" ")) {
			if (wordCount.containsKey(word)) {
				int count = wordCount.get(word);
				wordCount.put(word, ++count);
			} else {
				wordCount.put(word, 1);
			}
		}
		
		return wordCount;
	}
	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;
		public int indexOf(T t) {
			if (t == null) {
				for (int i = 0; i < sortedList.size(); i++) {
					if (sortedList.get(i) == null) {
						return i;
					}
				}
			} else {
				for (int i = 0; i < sortedList.size(); i++) {
					if (t.equals(sortedList.get(i))) {
						return i;
					}
				}
			}
			throw new NullPointerException();
		}



		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
        String[] vowels = {"a", "e", "i", "o", "u"};
        String[] words = string.split(" ");
        String returnVal = "";
    
		for (String word: words) {
			if (word.substring(0,3).equals("sch")) {
				word = word.replace("sch", "");
				returnVal += word + "schay ";
                continue;
			}
            if (word.substring(0,2).equals("th")) {
				word = word.replace("th", "");
				returnVal += word + "thay ";
                continue;
			} 
            if (word.substring(0,2).equals("qu")) {
				word = word.replace("qu", "");
				returnVal += word + "quay ";
                continue;
            } else {
				for (String l: vowels) {
					if (!word.substring(0,1).equals(l)) {
						String first = word.substring(0,1);
						word = word.replace(first, "");
						returnVal += word + first + "ay ";
	                    break;
					} else {
	                    returnVal += word + "ay ";
	                    break;
	                }
				}
			}
		}

		if (returnVal.substring(returnVal.length() - 1).equals(" ")) {
            return returnVal.substring(0, returnVal.length()-1);
		}
        return returnVal;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
    public boolean isArmstrongNumber(int input) {
		int nDigits = String.valueOf(input).length();
		int total = 0;
		for (char c: String.valueOf(input).toCharArray()) {
			total += Math.pow(Character.getNumericValue(c), nDigits);
		}
        
        Integer t = total;
        Integer n = input;
		if (t.equals(n)) {
			return true;
		}
		else { 
			return false;
		}
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
    public List<Long> calculatePrimeFactorsOf(long l) {
		List<Long> factors = new ArrayList<Long>();
		for(long i = 2; i < l; i++) {
			while (l % i == 0) {
				factors.add(i);
				l = l / i;
			}
		}
		if (l >= 2) {
			factors.add(l);
		}
		return factors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.null
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}
		
	    public String rotate(String string) {
	        String[] words = string.split(" ");
	        
	        StringBuilder encodedString = new StringBuilder();
	        for (String word: words) {
	            String symbol = "";
	            String alph = "";
	            StringBuilder encodedWord = new StringBuilder(word);
	            for (int i = 0; i <= word.length() - 1; i++) {
	                symbol = word.substring(i, i+1);
	                if (!Character.isLetter(word.charAt(i))) {
	                	continue;
	                }
	                alph = "abcdefghijklmnopqrstuvwxyz";
	                if (Character.isUpperCase(word.charAt(i))) {
	                	alph = alph.toUpperCase();
	                }
	                int cipherPosition = alph.indexOf(symbol) + key;
	                if (cipherPosition > 25) {
	                    cipherPosition = cipherPosition - 26;
	                }
	                String encodedSymbol = alph.substring(cipherPosition, cipherPosition+1);
	                encodedWord = encodedWord.replace(i, i+1, encodedSymbol);
	            }
	            encodedString.append(String.valueOf(encodedWord) + " ");
	        }
	        if (encodedString.substring(encodedString.length() - 1).equals(" ")) {
	            return encodedString.substring(0, encodedString.length()-1);
			}
	        return String.valueOf(encodedString);
	    }
	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
    public int calculateNthPrime(int i) {
		int nPrimes = 0; 
		int iter;
		int number = 1;
		if (i == 0) {
			throw new IllegalArgumentException();
		}
		while (nPrimes < i) {
			number += 1;
			for (iter = 2; iter < number; iter++) {
				if (number % iter == 0) {
					break; 
				}
			}
			if (iter == number) {
				nPrimes += 1;
			}
		}
		return number;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
	    public static String encode(String string) {
	        String symbol = "", encodedWord = "", encodedString = "";
	        String alph = "abcdefghijklmnopqrstuvwxyz";
	        String cipher = new StringBuilder(alph).reverse().toString();
	        for (int i = 0; i <= string.length() - 1; i++) {
	            symbol = string.substring(i, i + 1);
	            if (Character.isDigit(string.charAt(i))){
	                encodedWord += symbol;
	            }
	            if (!Character.isLetter(string.charAt(i))) {
	                continue; 
	            }

	            if (Character.isUpperCase(string.charAt(i))) {
	                symbol = symbol.toLowerCase();
	            }

	            int index = alph.indexOf(symbol);
	            String encodedSymbol = cipher.substring(index, index+1);
	            
	            if (encodedWord.length() < 5) {
	                encodedWord += encodedSymbol;
	            } else if (encodedWord.length() == 5) {
	                encodedString += encodedWord + " ";
	                encodedWord = encodedSymbol;
	            }
	        }
	        encodedString += encodedWord;
	        return encodedString;
	    }


		/**
		 * Question 14
		 * u
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			String symbol = "", decodedString = "";
			String alph = "abcdefghijklmnopqrstuvwxyz";
	        String cipher = new StringBuilder(alph).reverse().toString();
	        for (int i = 0; i <= string.length() - 1; i++) {
                symbol = string.substring(i, i + 1);
                if (!(Character.isLetter(string.charAt(i)) || Character.isDigit(string.charAt(i)))) {
                    continue;
                }
                if (Character.isDigit(string.charAt(i))) {
                    decodedString += symbol;
                    continue;
                }
                int index = cipher.indexOf(symbol);
                String decodedSymbol = alph.substring(index, index+1);
                decodedString += decodedSymbol;
                
            }
			return decodedString;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		String numbers = string.replaceAll(" |\\-", "");
		int total = 0;
		for (int index = 0; index < 9; index++) {
			String number = numbers.substring(index, index + 1);
			if (number.matches("[0-9]")) {
				total += Integer.parseInt(number) * (10 - index);
			} else {
				return false;
			}
		}
		char check = numbers.charAt(9);
		if (check == 'X') {
           total += 10;
		} else {
			total += check - '0';
        }
        
        if (total % 11 == 0) {
            return true;
        } else {
            return false;
        }
    }

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		String alph = "abcdefghijklmnopqrstuvwxyz"; 
		for (char c1: string.toCharArray()) {
			for (char c2: alph.toCharArray()) {
				if (c1 == c2) {
					alph = alph.replace(c2, '~');
				}
			}
		}
        for (char c: alph.toCharArray()) {
            if (c != '~') {
                return false;
            }
        }
        return true;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		final long GIGASECOND = 1000000000;
		LocalDateTime beginning = null;
		if (given instanceof LocalDateTime) {
			return given.plus(GIGASECOND, ChronoUnit.SECONDS);
		} else {
			LocalDate g = (LocalDate) given;
			beginning = g.atStartOfDay();
			return beginning.plus(GIGASECOND, ChronoUnit.SECONDS);
		}
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		int total = 0;
		int[] foundMultiples = new int[11000];
		for (int count = 0; count < i; count++) {
			for (int multiple: set) {
				if (count % multiple == 0) {
					if (foundMultiples[count] != count) {
						foundMultiples[count] = count;
                    }
                }
            }
        }
        for (int count : foundMultiples) {
            total += count;
        }
        return total;
    }

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		String text = string.replace(" ", "");
        int counter = 0, total = 0;
        for (int i = text.length() - 1; i >=0; i--) {
            char c = text.charAt(i);
            if (!Character.isDigit(c)) {
            	return false;
            }
            if (counter != 1) {
                total += Character.getNumericValue(c);
                counter += 1;
                continue;
            } else if (counter == 1) {
                int d = Character.getNumericValue(c) * 2;
                if (d > 9) {
                    d -= 9;
                    total += d;
                } else {
                    total += d;
                }
                counter = 0;
            }
        }
        if (total % 10 == 0) {
            return true;
        } 
		return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		String[] words = string.replace("?","").split(" ");
		if (words[3].contentEquals("plus")) {
			return Integer.parseInt(words[2]) + Integer.parseInt(words[4]);
		} else if (words[3].contentEquals("minus")) {
			return Integer.parseInt(words[2]) - Integer.parseInt(words[4]);
		} else if (words[3].contentEquals("multiplied")) {
			return Integer.parseInt(words[2]) * Integer.parseInt(words[5]);
		} else if (words[3].contentEquals("divided")) {
			return Integer.parseInt(words[2]) / Integer.parseInt(words[5]);
		}
		return 0;
	}

}
