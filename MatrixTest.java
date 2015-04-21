import static org.junit.Assert.*;

import org.junit.Test;


public class MatrixTest {

	@Test
	public void setElementTest() {
		Matrix m1= new Matrix(3,3);
		m1.setElement(2, 1, 5);
		double[][] result = m1.getMatrix();
		assertTrue(result[2][1]==5);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void addMatrixTest()
	{
		double[][] array = new double[][]{{2,3,5},{6,10,5},{4,2,1}};
		double[][] anw= new double[][]{{4,6,10},{12,20,10},{8,4,2}};
		Matrix expected = new Matrix(anw);
		Matrix m1= new Matrix(array);
		Matrix result = m1.addMatrices(m1);
		
		assertEquals(expected.getMatrix() , result.getMatrix());	
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void multMatrixTest()
	{
		double[][] array = new double[][]{{2,3,5},{6,10,5},{4,2,1}};
		double[][] anw= new double[][]{{42,46,30},{92,128,85},{24,34,31}};
		Matrix expected = new Matrix(anw);
		Matrix m1= new Matrix(array);
		Matrix result = m1.multMatrices(m1);
		
		assertEquals(expected.getMatrix() , result.getMatrix());
	}

}
