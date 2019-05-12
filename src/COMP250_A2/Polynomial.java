package COMP250_A2;

import java.math.BigInteger;

public class Polynomial 
{
	private SLinkedList<Term> polynomial;
	public int size()
	{	
		return polynomial.size();
	}
	private Polynomial(SLinkedList<Term> p)
	{
		polynomial = p;
	}
	
	public Polynomial()
	{
		polynomial = new SLinkedList<Term>();
	}
	
	// Returns a deep copy of the object.
	public Polynomial deepClone()
	{	
		return new Polynomial(polynomial.deepClone());
	}
	
	/* 
	 * TODO: Add new term to the polynomial. Also ensure the polynomial is
	 * in decreasing order of exponent.
	 */
	public void addTerm(Term t)
	{	
		//Used to keep track of whether the term has been added to the polynomial yet
		boolean termAdded = false; 
		
		//This for loop finds a term with a matching coefficient if present, and 
		//Adds the added term's coefficient to the existing term with the same 
		//coefficient
		
		for (Term term : polynomial) {
			if (t.getExponent() == term.getExponent()) {
				term.setCoefficient(t.getCoefficient().add(term.getCoefficient()));
			termAdded = true; 
			}
		}
		
		//If termAdded here is false, then we know that a term with the
		//same exponent does not exist, so we'll need to add a new term.
		
		//In order to maintain decreasing exponential order, it will be before 
		//the term with a lower exponent
		
		if (!termAdded) {
			//Keeps track of where the exponent should be added
			int i = 0;  	
			for (Term term : polynomial) {
				
				//If entered term exponent is larger than current term exponent, it is added 
				if (t.getExponent() > term.getExponent()) {
					polynomial.add(i, t);
					//When a term has been added, the for-each loop will be exited
					break;					
				}
				i++;
			}
		}
		
		
		
	}
	
	public Term getTerm(int index)
	{
		return polynomial.get(index);
	}
	
	//TODO: Add two polynomial without modifying either
	public static Polynomial add(Polynomial p1, Polynomial p2)
	{
		/**** ADD CODE HERE ****/
		
		
		return null;
	}
	
	//TODO: multiply this polynomial by a given term.
	private void multiplyTerm(Term t)
	{	
		/**** ADD CODE HERE ****/
		
	}
	
	//TODO: multiply two polynomials
	public static Polynomial multiply(Polynomial p1, Polynomial p2)
	{
		/**** ADD CODE HERE ****/
		
		return null;
	}
	
	//TODO: evaluate this polynomial.
	// Hint:  The time complexity of eval() must be order O(m), 
	// where m is the largest degree of the polynomial. Notice 
	// that the function SLinkedList.get(index) method is O(m), 
	// so if your eval() method were to call the get(index) 
	// method m times then your eval method would be O(m^2).
	// Instead, use a Java enhanced for loop to iterate through 
	// the terms of an SLinkedList.

	public BigInteger eval(BigInteger x)
	{
		/**** ADD CODE HERE ****/
		return new BigInteger("0");
	}
	
	// Checks if this polynomial is same as the polynomial in the argument
	public boolean checkEqual(Polynomial p)
	{	
		if (polynomial == null || p.polynomial == null || size() != p.size())
			return false;
		
		int index = 0;
		for (Term term0 : polynomial)
		{
			Term term1 = p.getTerm(index);
			
			if (term0.getExponent() != term1.getExponent() ||
				term0.getCoefficient().compareTo(term1.getCoefficient()) != 0 || term1 == term0)
					return false;
			
			index++;
		}
		return true;
	}
	
	// This method blindly adds a term to the end of LinkedList polynomial. 
	// Avoid using this method in your implementation as it is only used for testing.
	public void addTermLast(Term t)
	{	
		polynomial.addLast(t);
	}
	
	// This is used for testing multiplyTerm
	public void multiplyTermTest(Term t)
	{
		multiplyTerm(t);
	}
	
	@Override
	public String toString()
	{	
		if (polynomial.size() == 0) return "0";
		return polynomial.toString();
	}
}
