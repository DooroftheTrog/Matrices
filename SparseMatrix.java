import java.util.ArrayList;


public class SparseMatrix 
{
    private ArrayList<Element> elements;
    private int row=0,col=0;
    private int i,j;
    /**
     * Create a new blank Sparse Matrix that can be easily manipulated
     */
    public SparseMatrix()
    {
        elements = new ArrayList<Element>();
    }
    
    /**
     * Sets elements to e
     * Sets row to the highest row value of the elements
     * Sets col to the highest col value of the elements
     * 
     * @param e arraylist of elements that elements will be set to
     */
    public SparseMatrix(ArrayList<Element> e)
    {
        elements = e;
        for(i = 0; i<e.size(); i++)
        {
            Element e1 = elements.get(i);
            if(e1.getRow()>row)
            {
                row=e1.getRow();
            }
            if(e1.getCol()>col)
            {
                col=e1.getCol();
            }
        }
    }
    
    /**
     *
     * @param e what elements will be set to/a list of the elements in the Sparse Matrix
     * @param r the number of rows that the sparse matrix will have
     * @param c the number of Cols that the sparse matrix will have
     */
    public SparseMatrix(ArrayList<Element> e, int r, int c)
    {
        elements = e;
        row = r;
        col = c;
    }
    
    /**
     * @return returns the number of rows the sparse matrix has
     */
    public int getRow()
    {
        return row;
    }
    
    /**
     * @return returns the number of columns the sparse matrix has
     */
    public int getCol()
    {
        return col;
    }
    
    /**
     * @return returns the arraylist of elements
     */
    public ArrayList<Element> getElements()
    {
        return elements;
    }
    
    public Element getElement(Element e)
    {
        if(elements.contains(e))
        {
            for(i=0; i < elements.size(); i++)
            {
                if(elements.get(i).equals(e))
                {
                    return elements.get(i);
                }
            }
        }else{
            throw new IllegalArgumentException("Enter an element with valid Row/Col values");
        }
        return new Element(e.getRow(),e.getCol(),0);
    }
    
    /**
     * If there is an element already at the position specified then it will remove that element and put in the new one this works since element.equals only has to do with col and row
     * But only if the Element is within the range of the list must have row and col less than the rows and cols of the matrix
     * 
     * @param e the new element to be added to the matrix
     */
    public void addElement(Element e)
    {
        if(e.getCol()<=col||e.getRow()<=row)
        {
            if(elements.contains(e))
            {
                elements.remove(e);
                elements.add(e);
            }else{
                elements.add(e);
            }
        }else
        {
            throw new IllegalArgumentException("Enter an element with valid Row/Col values");
        }
        
        elements.add(e);
    }
    
    /**
     * removes an element from the matrices list of elements
     * 
     * @param e element to be removed from the list
     */
    public void removeElement(Element e)
    {
        elements.remove(e);
    }
    
    /**
     * This method starts by adding all the elements from the first 
     * matrix into the new matrix and if they have the same position
     * as an element in the other matrix then it adds the values from 
     * the two elements and then adds the new element in.
     * Then the remaining elements from m are added into the new matrix.
     * 
     * @param m the matrix that will be added to this matrix
     * @return returns a new matrix of the 2 matrices added together
     */
    public SparseMatrix addMatrices(SparseMatrix m)
    {
        int mRow = m.getRow();
        int mCol = m.getCol();
        ArrayList<Element> e = new ArrayList<Element>();
        
        if(mRow==row&&mCol==col)
        {
            ArrayList<Element> mList = new ArrayList<Element>();
            for(i=0; i < elements.size(); i++)
            {
                mList.add(m.getElements().get(i));
            }
            
            for(i = 0; i < elements.size(); i++)//loop to add all elements from this list and elements with same position
            {
                Element e1 = elements.get(i);
                if(mList.contains(e1))
                {
                    for(j=0; j< mList.size(); j++)
                    {
                        if(mList.get(j).equals(e1))
                        {
                            double val = mList.get(j).getVal();
                            mList.remove(e1);
                            e1.setVal(e1.getVal()+val);
                        }
                    }
                }
                e.add(e1);
            }
            
            if(mList.isEmpty()==false)
            {
                for(i = 0; i < mList.size(); i++)
                {
                    e.add(mList.get(i));
                }
            }
            
            SparseMatrix result = new SparseMatrix(e);
            return result;
        }else{
            throw new IllegalArgumentException("Enter a matrix with valid Row/Col values");
        }
    }
    
    /**
     * Multiplies this matrix to another matrix 
     * 
     * @param m accepts a matrix to multiply to this matrix
     * @return returns the product of the matrices
     */
    public SparseMatrix multMatrix(SparseMatrix m)
    {
        if(col==m.getRow())
        {
            ArrayList<Element> matrix = new ArrayList<Element>();
            Element e;
            for(i = 0; i < row; i ++)
            {
                for(j = 0; j < m.getCol(); j++)//run through the 
                {
                    e=new Element(i,j,0);
                    for(int h=0; h< this.col; h++)
                    {
                         Element e1 = new Element(i,h,0);
                         Element e2 = new Element(h,j,0);
                        if(elements.contains(e1)&&m.getElements().contains(e2))
                        {
                            e.setVal(e.getVal()+(this.getElement(e1).getVal()*m.getElement(e2).getVal()));
                        }
                    } 
                    if(e.getVal()!=0)
                    {
                        matrix.add(e);
                    }
                }
            }
            SparseMatrix temp = new SparseMatrix(matrix);
            return temp;
        }else{
            throw new IllegalArgumentException("Enter a matrix with the valid col value");
        }
    }
    
    public boolean equals(SparseMatrix m)
    {
        ArrayList<Element> mList =m.getElements();
        for(i = 0; i < mList.size(); i++)
        {
            if(!mList.get(i).equals(elements.get(i)))
            {
                return false;
            }
        }
        return true;
    }
    
}
