/**
 * TODO
 * @author ColinFischer
 * Date Last Modified: 8 March 2017
 */

import java.io.*;

public class RecursiveBinaryTriangle
{

	/**
	 * TODO
	 */
	public static void main(String[] args)
	{
		try
		{
			printRecursiveFun();
			printBinaryRep();
			printTriangularTargets();
		}
		catch(Exception e)
		{
			System.out.println("An error occurred.");
		}
	}
	
	/**
	 * TODO
	 */
	private static void printRecursiveFun() throws IOException
	{
		
		FileWriter fw = new FileWriter("recursiveBinaryTriangleOutput.txt");
		fw.write("Recursive CompPrime Functions\n\n");
		CompPrimeFun[] funArray = 
			{new CompPrimeFun(1), new CompPrimeFun(15),
			new CompPrimeFun(27), new CompPrimeFun(53)};
		for(int i=0;i<funArray.length;i++)
		{
			fw.write("f("+funArray[i].getValue()+") = "+
					funArray[i].calculateFun()+"\n");
		}
		fw.write("\n");
		fw.close();
	}
	
	/**
	 * TODO
	 */
	private static void printBinaryRep() throws IOException
	{
		FileWriter fw = new FileWriter("recursiveBinaryTriangleOutput.txt", true);
		fw.write("Binary Representation\n\n");
		int numOnes = 0, x = 0, y = 1022;
		for(int i=x;i<y;i++)
		{
			BinaryRepresentation t = new BinaryRepresentation(i);
			if(t.getNumOnes()>=8)
				numOnes++;
		}
		fw.write("Number of whole numbers between "+x+" and "+y+"\n");
		fw.write("that contain eight 1's in their binary representation:\n");
		fw.write(""+numOnes+"\n\n");
		fw.close();
	}
	
	/**
	 * TODO
	 */
	private static void printTriangularTargets() throws IOException
	{
		FileWriter fw = new FileWriter("recursiveBinaryTriangleOutput.txt", true);
		fw.write("Triangular Targets\n\n");
		double[] v1, v2, v3, target;
		v1 = new double[]{0.0, 0.0};
		v2 = new double[]{9.0, 0.1};
		v3 = new double[]{0.5, 9.0};
		target = new double[]{2.0, 1.9};
		TriangularTargets tt = new TriangularTargets(
									v1[0],v1[1],v2[0],v2[1],v3[0],v3[1]);
		if(tt.isInTarget(target[0], target[1]))
			fw.write("The point ("+target[0]+", "+target[1]+") is inside");
		else
			fw.write("The point ("+target[0]+","+target[1]+") is outside");
		fw.write(" the triangle\nwith coordinates ("+v1[0]+", "+v1[1]+")"+
					" ("+v2[0]+", "+v2[1]+") and ("+v3[0]+", "+v3[1]+")");
		fw.close();
	}
}