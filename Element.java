
public class Element
{
	private int row,col;
	private double value;
	
	public Element(int r, int c, double val)
	{
		row=r;
		col=c;
		value=val;
	}
	
	public int getRow()
	{
		return row;
	}
	
	public int getCol()
	{
		return col;
	}
	
	public double getVal()
	{
		return value;
	}
	
	public void setVal(double val)
	{
		value = val;
	}
	/**
	 * Used for comparative purposes if the row and col values of 2 elements are the same then they are considered the same for the purpose of having the same position
	 * 
	 * @param e element that this is being compared to
	 * @return returns whether the objects are at the same position or not
	 */
	public boolean equals(Element e)
	{
		if(e.getCol()==this.getCol()&&e.getRow()==this.getRow())
		{
			return true;
		}else{
			return false;
		}
	}
	
	public String toString()
	{
		return Double.toString(value);
	}
	
	

}
