
public class Matrix 
{
	private double[][] elements;
	private int row=0,col=0;
	
	/**
	 * Instantiates matrix based on col and row values
	 * 
	 * @param r initializes row
	 * @param c initializes col
	 */
	public Matrix(int r, int c)
	{
		row=r;
		col=c;
		elements=new double[r][c];
	}
	
	/**
	 * Instantiates matrix based on a 2-d array for the elements
	 * 
	 * @param matrix used to instantiate elements
	 */
	public Matrix(double[][] matrix)
	{
		row=matrix.length;
		col=matrix[0].length;
		elements= matrix;
	}
	
	/**
	 * 
	 * @return returns the rows for the matrix size
	 */
	public int getRows()
	{
		return row;
	}
	
	/**
	 * 
	 * @return returns the columns for the matrix size
	 */
	public int getCol()
	{
		return col;
	}
	
	/**
	 * 
	 * @return returns the 2-d array of elements
	 */
	public double[][] getMatrix()
	{
		return elements;
	}
	
	/**
	 * 
	 * @param r is the value for the row position in the 2-d array
	 * @param c i the value for the column position in the 2-d array
	 * @return returns the value of the element being accessed
	 */
	public double getElement(int r, int c)
	{
		if(r<row && r>=0 && c<col && c>=0)
		{
			return elements[r][c];
		}else
		{
			throw new IllegalArgumentException("Enter a valid Row/Col value");
		}
		
	}
	
	/**
	 * 
	 * @param r is the row position to be set
	 * @param c is the column position to be set
	 * @param val is the value to be set at the position row,column
	 */
	public void setElement(int r, int c, double val)
	{
		if(r<row && r>=0 && c<col && c>=0)
		{
			elements[r][c]=val;
		}else
		{
			throw new IllegalArgumentException("Enter a valid Row/Col value");
		}
	}
	
	/**
	 * Adds this matrix to another matrix
	 * @param comp is the matrix being added to this matrix
	 * @return returns a new matrix that is the sum of the two matrices
	 */
	public Matrix addMatrices(Matrix comp)
	{
		if(comp.getRows()==this.getRows()&&comp.getCol()==this.getCol())
		{
			Matrix temp = new Matrix(this.getRows(),this.getCol());
			for(int i = 0; i < this.getRows(); i++)
			{
				for(int j = 0; j < this.getCol(); j++)
				{
					double value=elements[i][j]+comp.getElement(i, j);
					temp.setElement(i,j, value);
				}
			}
			return temp;
		}else
		{
			throw new IllegalArgumentException("Enter a valid Matrix(Must have same number of rows and cols as this matrix)");
		}
	}
	
	/**
	 * Multiplies this matrix to comp
	 * @param comp is the matrix being multiplied to this matrix
	 * @return returns the product of the two matrices multiplied together
	 */
	public Matrix multMatrices(Matrix comp)
	{
		if(comp.getRows()==this.getCol())
		{
			double[][] matrix = new double[this.getRows()][comp.getCol()];
			
			for(int i = 0; i < elements.length; i ++)
			{
				for(int j = 0; j < comp.getCol(); j++)//run through the 
				{
					for(int h=0; h< this.col; h++)
					{
						matrix[i][j]+= elements[i][h]*comp.getElement(h, j);
					}					
				}
			}
			Matrix temp = new Matrix(matrix);
			return temp;
		}else
		{
			throw new IllegalArgumentException("Enter a valid Matrix(The Matrix must have the same number of Rows as this Matrix's Cols)");
		}
	}
	
}
