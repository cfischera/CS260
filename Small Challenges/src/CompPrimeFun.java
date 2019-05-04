/**
 * This Class calculates the value of an arbitrary function
 * defined by Mr. Meinzen.
 * @author ColinFischer
 * Date Last Modified: 8 March 2017
 */
public class CompPrimeFun
{
	private int value;
	
	/**
	 * Creates a CompPrimeFun Object with an
	 * integer value.
	 */
	public CompPrimeFun(int n)
	{
		value = n;
	}
	
	/**
	 * Calculates function value:
	 * if composite f(x) = 2*(x-3)-4
	 * if prime f(x) = x^2+x
	 * if x <=1 f(x) = 1
	 */
	public int calculateFun()
	{
		return calculateFun(value);
	}
	
	/**
	 * Private helper method to calculate function value.
	 */
	private int calculateFun(int n)
	{
		if(n<=1)
			return 1;
		else if(isPrime(n))
			return ((n*n)+n);
		else
			return (2*calculateFun(n-3)-4);
	}
	
	/**
	 * Returns if a passed number is prime.
	 */
	private boolean isPrime(int n)
	{
		for(int i=2;i<(int)Math.sqrt(n)+1;i++)
		{
			if(n%i==0)
				return false;
		}
		return true;
	}
	
	/**
	 * Returns value of CompPrimeFun Object.
	 */
	public int getValue()
	{
		return value;
	}
}