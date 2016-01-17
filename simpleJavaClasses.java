//Pawel Adamczuk

import java.util.ArrayList;

public class TouchScreen {
	
	/*
		class ActionVector {
	    
	    public boolean isMovement;
	    public int startX;
	    public int startY;
	    public int endX;
	    public int endY;
	    public int numberOfPoints;
	    public int force;
	    
	    @Override public String toString() {
		    if(isMovement)
		    {
		  
		      String s = "Movement, numberOfPoints = "+numberOfPoints + "  vector = [" + startX + ", "+ startY + ", " +endX +", " + endY+"] Force= " + force;
		        return s;
		    }
		    else
		    
		    return "Touch, Point=["+startX + ", "+startY+"] Force= "+force ;
		    }	      
		}
	*/
	
	public enum State {
		AWAITING,
		WORKING;
	}
	
	private State state;
	
	private int n; //the dimensions of the screen that is currently being analysed
	private int m;
	
	public TouchScreen () {
		this.state = State.AWAITING;
		n = 0;
		m = 0;
	}
	
	ArrayList<ActionVector> list = new ArrayList<ActionVector>();
	
	public ActionVector[] AnalyzeMatrix(byte[][] matrix) {
		
		boolean isEmpty = true;
		
		if ( this.state == State.AWAITING ) //first matrix in the set
		{
			this.n = matrix.length;
			this.m = matrix[0].length;
			
			for ( int i = 0; i < n; ++i )
				for ( int j = 0; j < m; ++j )
				{
					if ( matrix[i][j] != 0 ) //found a point that is being pressed
					{
						isEmpty = false;
						
						ActionVector tempVector = new ActionVector();
						tempVector.startX = i;
						tempVector.startY = j;
						tempVector.endX = i;
						tempVector.endY = j;
						tempVector.isMovement = false;
						tempVector.force = matrix[i][j];
						tempVector.numberOfPoints = 1;
						
						this.list.add(tempVector);
					}
					
				}
			
			if ( !isEmpty )
				this.state = State.WORKING;
		}
		
		else
		{		
			for ( int i = 0; i < n; ++i )
				for ( int j = 0; j < m; ++j )
				{
					if ( matrix[i][j] != 0 ) //found a point that is being pressed
					{
						boolean isCont = false;
						isEmpty = false;
						
						
						for ( ActionVector aV : this.list ) //checking if the point is a continuation of an existing action
						{
							if ( Math.abs(aV.endX-i) <= 1 && Math.abs(aV.endY-j) <= 1 )
							{
								if ( aV.endX != i || aV.endY != j ) //the point considered is a continuation
								{
									isCont = true;
									aV.endX = i;
									aV.endY = j;
									aV.force += matrix[i][j];
									aV.isMovement = true;
									aV.numberOfPoints += 1;
								}
								
							}
							
						}
						
						if ( isCont == false )
						{					
							ActionVector tempVector = new ActionVector();
							tempVector.startX = i;
							tempVector.startY = j;
							tempVector.endX = i;
							tempVector.endY = j;
							tempVector.isMovement = false;
							tempVector.force = matrix[i][j];
							tempVector.numberOfPoints = 1;
							
							this.list.add(tempVector);
						}
						
					}
					
				}			
						
		}
		
		ActionVector[] aVectorArray = new ActionVector[this.list.size()];
		
		for ( int i = 0; i < this.list.size(); ++i )
		{
			aVectorArray[i] = this.list.get(i);
		}
		
		if ( isEmpty )
		{
			this.list.clear();
			this.state = State.AWAITING;
		}
		
		return aVectorArray;
		
		
		
	}	

}
