package dbaselogin;

import java.sql.Connection;


public class Dbob
	{

	public Dbcon dbo;           
        public  Connection con; 
     
		public Dbob()
		{

			   

		}



	    public void setDbob(Dbcon dbo)
		{

		  this.dbo = dbo;	



		}

	     public Dbcon getDbob()
		{

		  


		return dbo;	
		
		}

	    public void setCon(Connection con)
		{


		 this.con=con;	

		}	

	
	     public Connection getCon()
			{



			return con;
	

			}

    }