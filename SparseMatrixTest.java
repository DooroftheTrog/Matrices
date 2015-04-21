import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class SparseMatrixTest {

	Element e1 = new Element(1, 3, 6);
	Element e2 = new Element(1, 2, 4);
	Element e3 = new Element(2, 2, 8);
	Element e4 = new Element(1, 3, 12);
	Element e5 = new Element(1, 2, 8);
	Element e6 = new Element(2, 2, 16);
	Element e7 = new Element(1, 2, 32);
	Element e8 = new Element(2, 2, 64);
	ArrayList<Element> elements = new ArrayList<Element>();
	
	@Test
	public void checkInstantiation()
	{
		elements.add(e1);
		elements.add(e2);
		elements.add(e3);
		SparseMatrix m = new SparseMatrix(elements);
		assertTrue(m.getRow()==2);
		assertTrue(m.getCol()==3);
		elements.clear();
	}
	
	@Test
	public void addElementTest()
	{
		elements.add(e1);
		elements.add(e2);
		elements.add(e3);
		SparseMatrix m = new SparseMatrix(elements);
		elements.remove(e3);
		elements.add(e4);
		m.addElement(e4);
		assertTrue(m.getElements().equals(elements));
		elements.clear();
		
	}
	
	@Test
	public void addMatrixTest()
	{
		elements.add(e1);
		elements.add(e2);
		elements.add(e3);
		SparseMatrix m = new SparseMatrix(elements);
		m=m.addMatrices(m);
		elements.clear();
		elements.add(e4);
		elements.add(e5);
		elements.add(e6);
		SparseMatrix actual = new SparseMatrix(elements);
		
		assertTrue(m.equals(actual));
		
	}
	
	@Test
	public void mulitMatrix()
	{
		elements.add(e1);
		elements.add(e2);
		elements.add(e3);
		SparseMatrix m = new SparseMatrix(elements,3,3);
		m=m.multMatrix(m);
		elements.clear();
		elements.add(e7);
		elements.add(e8);
		SparseMatrix actual = new SparseMatrix(elements,3,3);
		
		assertTrue(m.equals(actual));
	}
	
}
