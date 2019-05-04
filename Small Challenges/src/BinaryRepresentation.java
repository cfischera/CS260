/**
 * TODO
 * @author ColinFischer
 * Date Last Modified: 8 March 2017
 */
public class BinaryRepresentation
{
	private int value;
	public String bRep;
	
	/**
	 * TODO
	 */
	public BinaryRepresentation(int n)
	{
		value = n;
		bRep = Integer.toString(value, 2);
	}
	
	public int getNumOnes()
	{
		int numOnes = 0;
		char[] bRepChars = bRep.toCharArray();
		for(int i=0;i<bRepChars.length;i++)
		{
			if(bRepChars[i]=='1')
				numOnes++;
		}
		return numOnes;
	}
}