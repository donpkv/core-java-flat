package dbaselogin;

import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LGAImplDetails
	{
		

	private Dbob dbob;
        private static LGAImplDetails LGAImplObj;
    private String[] vehicalCategory;
		private Dbob prdbob;
		private JTable prtable;
		private LGAObj prlobj;
		private JFXPanel fxPanel;
		private String strKey;

		private LGAImplDetails()
				{



				}


			 public static LGAImplDetails getLGAImplObj()
				{

					if(LGAImplObj==null)
						{LGAImplObj=new LGAImplDetails();
						
						 return LGAImplObj; 	
						}

				return LGAImplObj;	
				}	

			 public boolean getAdminDetails(Dbob dbob, String tableName, String user_id_col, String password_col, String userId, String pswdval)
				{

					return dbob.getDbob().getAdminV(dbob.getCon(),tableName, user_id_col, password_col,userId, pswdval);
				
					

				}


		public boolean addAdminDetails(Dbob dbob, String tableName, String user_id_col, String password_col, String userId, String pswdval,int uId,int vooz)
		{

			return dbob.getDbob().addAdminValues(dbob.getCon(),tableName, user_id_col, password_col,userId, pswdval,uId,vooz);



		}

			 public String 	getLGAName(Dbob dbob, String ColName, String matchCol, String TableName, int matchValue)
				{
	
	            String lgaName= dbob.getDbob().getColData(dbob.getCon(),ColName,matchCol,matchValue,TableName);
		
				return lgaName;
				}

			


			    public void AddCylCategory(Dbob dbob, String txtCylCategory)
					{

						//this.dbob=dbob;
						
                                               // dbob.getDbob().addCylCategoryNames(dbob.getCon(),txtCylCategory);
                                                  
						


					}

			   public void addStaffName(Dbob dbob, String StaffName)
				  	{


				          dbob.getDbob().addStaffNames(dbob.getCon(),StaffName);



					}

			 /*  public void addPartyName(dbaselogin.Dbob dbob, String startBranch, String tabName, String colName, int id, int vOOz)
					{
				          dbob.getDbob().addPartyNames(dbob.getCon(),startBranch,tabName,colName,id,vOOz);
					}*/

		public boolean addBranch(Dbob dbob, String startBranch, String tabName, String colName, int id, int vOOz)
		{
			 return dbob.getDbob().addBranch(dbob.getCon(),startBranch,tabName,colName,id,vOOz);

			}
			
			    public String[] getVehicalCategory(Dbob dbob, String id, String tabName)
					{

		String cylCatNames[]=dbob.getDbob().getVehicalCategoryNames(dbob.getCon(),id,tabName).split(":");

			    	
				       return cylCatNames;	
					}


	        
		public String[][] getVehicalCatRecords(Dbob dbob, String cylCatVal, String tabName, String colName)
					{
						  String dataValues[][]=null;   
                                        String CylCatDetails[]=null;
					String RowColSize[]=null; 
					  int idx=0;


				 if(!(colName.equals("")) && !(cylCatVal.equals("")))
					      {    
										System.out.println("inside if from getCylCategoryRecords ImplDetails");
	
                                                              
				String CylCatDetails1[]= dbob.getDbob().getCylCategoryRecords(dbob.getCon(),cylCatVal,tabName,colName).split("--");
                                String RowColSize1[]= dbob.getDbob().getRowColCount(dbob.getCon(),cylCatVal,tabName,colName).split(":"); 
					CylCatDetails=CylCatDetails1;							                              
                                        RowColSize=RowColSize1; 
						}
					else
					   {
	String CylCatDetails1[]= dbob.getDbob().getCylCategoryRecords(dbob.getCon(),cylCatVal,tabName,colName).split("--");
                                String RowColSize1[]= dbob.getDbob().getRowColCount(dbob.getCon(),cylCatVal,tabName,colName).split(":"); 
					CylCatDetails=CylCatDetails1;							                              
                                        RowColSize=RowColSize1; 
				

						
					  }	
					    	
					

			
							 int rowSize=Integer.parseInt(RowColSize[0]);
							 int colSize=Integer.parseInt(RowColSize[1]);

	 System.out.println("from setAllCylCatRecords Row : "+rowSize+"  Col : "+colSize);
			

								dataValues=new String[rowSize][colSize]; 
						    
						for(int idx2=0;idx2<CylCatDetails.length;idx2++)
								{
                                                        	
                                                             System.out.println(idx2+" : "+CylCatDetails[idx2]);
								}

						System.out.println("--->"+CylCatDetails.length);
			 			 
						for(int idx1=0;idx1<rowSize;idx1++)
							{
							    for(int idx2=0;idx2<colSize;idx2++)
								{
                                                        	
                                                            		idx++;
							     		if(idx<CylCatDetails.length)
										{
							 System.out.println(idx+" : "+CylCatDetails[idx]);
	
									dataValues[idx1][idx2]=CylCatDetails[idx];	
									
									        }					
					
								}
								    
						        } 
							
							if(dataValues.length>0)
		 					 {
   								 
                                                            return dataValues;	
							
							 }
                  



             
										                              

					                               

					  return dataValues; 	

					}

			 String[] getColNames(Dbob dbob, String tabName)
			{
             String columnNames[]= dbob.getDbob().getColumnNames(dbob.getCon(),tabName).split(":");

			return columnNames;
			}



	   void updateCylCatValues(Dbob dbob, String cylCatVal, String CylRate, String CylQty, int vOoZ)
					{


		     //  dbob.getDbob().updateCylCategoryValues(dbob.getCon(),cylCatVal,CylRate,CylQty,vOoZ);
	


					}
		
	  	String[] getStaffList(Dbob dbob, String ColName, String TableName)
				{
					

				 String staffNames[]= dbob.getDbob().getColValues(dbob.getCon(),ColName,TableName ).split(",");
					

				return staffNames;
				}
/*
		String[] getPartyNames(dbaselogin.Dbob dbob)
				{
				String ColName = "Party_Name" , TableName = "LGABankParty";	

				 String partyNames[]= dbob.getDbob().getLGAValues(dbob.getCon(),ColName,TableName ).split(":");
					

				return partyNames;
				}
*/
	/*	String[] getDates(dbaselogin.Dbob dbob)
				{
				String ColName = "Cash_Date" , TableName = "Cash_Bank";	

				 String Dates[]= dbob.getDbob().getLGAValues(dbob.getCon(),ColName,TableName ).split(":");
					

				return Dates;


				}

*/
		String  depositToParty(Dbob dbob, String BankPartyVal, String tabName, String colName, String setColValue, String txtCash)
				{


		// String valDeduction = dbob.getDbob().updatePartyValues(dbob.getCon(),BankPartyVal,tabName,colName,setColValue,txtCash);
		
				return "";//valDeduction;
				}

	      /* public String[][] getCylCatReport(dbaselogin.Dbob dbob,String cylCatVal)
					{

					  String dataValues[][]=null;   
                                        String CylCatReportDetails[]=null;
					String RowColSize[]=null; 
					  int idx=0;


				 if(cylCatVal!="")
					      {    String tabName="LGASalesReport";
                                                              
				String CylCatReportDetails1[]= dbob.getDbob().getCylCategoryRecords(dbob.getCon(),cylCatVal,tabName).split("--");
                                String RowColSize1[]= dbob.getDbob().getRowColCount(dbob.getCon(),cylCatVal,tabName).split(":"); 
					CylCatReportDetails=CylCatReportDetails1;							                              
                                        RowColSize=RowColSize1; 
						}
					    	
					

			
							 int rowSize=Integer.parseInt(RowColSize[0]);
							 int colSize=Integer.parseInt(RowColSize[1]);

	 System.out.println("from setAllCylCatRecords Row : "+rowSize+"  Col : "+colSize);
			

								dataValues=new String[rowSize][colSize]; 
						    
						for(int idx2=0;idx2<CylCatReportDetails.length;idx2++)
								{
                                                        	
                                                             System.out.println(idx2+" : "+CylCatReportDetails[idx2]);
								}

						System.out.println("--->"+CylCatReportDetails.length);
			 			 
						for(int idx1=0;idx1<rowSize;idx1++)
							{
							    for(int idx2=0;idx2<colSize;idx2++)
								{
                                                        	
                                                            		idx++;
							     		if(idx<CylCatReportDetails.length)
										{
							 System.out.println(idx+" : "+CylCatReportDetails[idx]);
	
									dataValues[idx1][idx2]=CylCatReportDetails[idx];	
									
									        }					
					
								}
								    
						        } 
							
							if(dataValues.length>0)
		 					 {
   								 
                                                            return dataValues;	
							
							 }
                  



             
										                              

					                               

					  return dataValues; 	




					}*/	

		/*	String[][] getStaffCylCatReport(dbaselogin.Dbob dbob,String staffName)
					{

					  String dataValues[][]=null;   
                                        String CylCatReportDetails[]=null;
					String RowColSize[]=null; 
					  int idx=0;


				 if(cylCatVal!="")
					      {    String tabName="LGASalesReport";
                                                              
				String CylCatReportDetails1[]= dbob.getDbob().getCylCategoryRecords(dbob.getCon(),cylCatVal,tabName).split("--");
                                String RowColSize1[]= dbob.getDbob().getRowColCount(dbob.getCon(),cylCatVal,tabName).split(":"); 
					CylCatReportDetails=CylCatReportDetails1;							                              
                                        RowColSize=RowColSize1; 
						}
					    	
					

			
							 int rowSize=Integer.parseInt(RowColSize[0]);
							 int colSize=Integer.parseInt(RowColSize[1]);

	 System.out.println("from setAllCylCatRecords Row : "+rowSize+"  Col : "+colSize);
			

								dataValues=new String[rowSize][colSize]; 
						    
						for(int idx2=0;idx2<CylCatReportDetails.length;idx2++)
								{
                                                        	
                                                             System.out.println(idx2+" : "+CylCatReportDetails[idx2]);
								}

						System.out.println("--->"+CylCatReportDetails.length);
			 			 
						for(int idx1=0;idx1<rowSize;idx1++)
							{
							    for(int idx2=0;idx2<colSize;idx2++)
								{
                                                        	
                                                            		idx++;
							     		if(idx<CylCatReportDetails.length)
										{
							 System.out.println(idx+" : "+CylCatReportDetails[idx]);
	
									dataValues[idx1][idx2]=CylCatReportDetails[idx];	
									
									        }					
					
								}
								    
						        } 
							
							if(dataValues.length>0)
		 					 {
   								 
                                                            return dataValues;	
							
							 }
                  



             
										                              

					                               

					  return dataValues; 	






					}

				*/	
				

                        String[] addVehicalCatValues(Dbob dbob, String vehcatid, String VehicalCatVal, String StaffId, String StaffName, String VehicalAvailableCount, String VehicalSellCount, String GivenAmt, int discountValue, String cheqCash, String ChequeNumber, String Model, String chasisNo, String price, String engineNo, String color, String key, String customerName, String remarks)
					{

             		    String CylCatValues[]=dbob.getDbob().addVehicalCategoryValues(dbob.getCon(),vehcatid,VehicalCatVal,StaffId,StaffName,VehicalAvailableCount,VehicalSellCount,GivenAmt,discountValue,cheqCash,ChequeNumber,Model,chasisNo,price,engineNo,color, key,customerName,remarks).split(":");

					return CylCatValues;
					}

			void updateSalesCylCatValues(Dbob dbob, String IDStaffReport, String ColNamesStaffReport, String ColValuesStaffReport)
					{
					 //  dbob.getDbob().updateSalesCylCategoryValues(dbob.getCon(),IDStaffReport,ColNamesStaffReport,ColValuesStaffReport);


					}

			String	getTotalCashAvailable(Dbob dbob, String colName, String tabName)
					{

			//		 int totalCash = dbob.getDbob().getTotalCash(dbob.getCon(),colName,tabName);
						
                                                 
					
					return "";//+totalCash;
					}

    void addVahicalValues(Dbob dbob, String vehicalId, String vehicalName, String vehicalNo, String materialId, String materialName, String materialQty, String materialPrice , String driverId, String driverName, String conductorName, String fromTo, String vivaran, String amount
			, String loader, String orderOrBuyer, String cashDeposit, String oldExpVal, String expenses, String diesel, String fromv, String startReading, String endReading, String oldBalance, String balance, int vOoZ)
          {
        dbob.getDbob().addVahicalValues(dbob.getCon(),vehicalId,vehicalName,vehicalNo,materialId,materialName,materialQty,materialPrice ,driverId, driverName,conductorName,fromTo,vivaran,amount,loader,orderOrBuyer,cashDeposit,oldExpVal,expenses,diesel,fromv, startReading, endReading,oldBalance,balance, vOoZ);
	//updateCylCategoryValues
           }

    void setVehicalValues(String[] vehicalCategory) {
    
                     this.vehicalCategory=  vehicalCategory;
    }

 String[] getVehicalValues() {
    
                   return this.vehicalCategory;
    }

    String[] getVehicalColorList(Dbob dbob) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
         String[] colors=  dbob.getDbob().getVehicalColorList(dbob.getCon()).split(":");
	
    return colors;
    }

    void addDriverDetails(Dbob dbob, String driverName, String address, String phoneNo, String amountGiven, String remark, int vOoZ) {
    
      dbob.getDbob().addDriverDetails(dbob.getCon(), driverName,address,phoneNo,amountGiven,remark,vOoZ);
	
    }


		public String[] getDriverList(Dbob dbob) {

		String details=	dbob.getDbob().getDriverDetails(dbob.getCon());

                     return   details.split(":");
                        }

		public String getBalance(String driverVal, Dbob dbob) {

			String detail=	dbob.getDbob().getColData(dbob.getCon(),"AMOUNT_GIVEN","ID",driverVal,"DRIVER_DETAIL,");//"INVENTORY_DETAIL"

			return detail;
		}

        public void addVehicalDetails(Dbob dbob, String vehicalName, String vehicalNo, String vehicalModel, String vehicalChasis, String remark, int vOoZ) {

			dbob.getDbob().addVehicalDetails(dbob.getCon(), vehicalName,vehicalNo,vehicalModel,vehicalChasis,remark,vOoZ);

		}

		public void addMaterialDetails(Dbob dbob, String materialName, String materialSize, String materialQty, String materialPrice, String remark, int vOoZ) {
			dbob.getDbob().addMaterialDetails(dbob.getCon(),materialName,materialSize,materialQty,materialPrice,remark,vOoZ);

                        }





		public String getDetails(Dbob dbob) {
			String detail=	dbob.getDbob().getMultiTabData(dbob.getCon(),"ID,material_name,material_qty,material_price","ID,vehical_name,vehical_no","MATERIAL_DETAIL,VEHICAL_DETAIL");//"INVENTORY_DETAIL"

			return detail;
		}

		public void setInvoiceData(JTable table, LGAObj lObj, Dbob dbob, String strKey) {

             this.prtable =table;
             this.prlobj=lObj;
             this.prdbob=dbob;
             this.strKey=strKey;
		}

		public ArrayList getInvoiceData()
		{

			ArrayList arrayList = null;

			if(strKey!=null && !(strKey.equals(""))) {
				if (prtable != null && prlobj != null && prdbob != null) {
					arrayList = new ArrayList();
					arrayList.add(prtable);
					arrayList.add(prlobj);
					arrayList.add(prdbob);
					arrayList.add(strKey);

				}
			}
			else
			{
				if (prtable != null && prlobj != null && prdbob != null) {
					arrayList = new ArrayList();
					arrayList.add(prtable);
					arrayList.add(prlobj);
					arrayList.add(prdbob);
				}

			}
         return arrayList;
		}

		public String[] getList(String string, Dbob dbob, String tableName, String gstFlagsVal, String colName) {

			String value = dbob.getDbob().getList(string,dbob.getCon(),tableName,gstFlagsVal,colName, 0);

			if(value.contains(",")) {
				return value.split(",");
			}
			else
			{
				return null;
			}
      }

        public String  getSum(String strKey, Dbob dbob, String tableName, String gstFlagsVal, String colName,String colVal) {

            return dbob.getDbob().getSum(strKey, dbob.getCon(), tableName, gstFlagsVal, colName,colVal);


        }

		public String[] getTGListForDoc(String string, Dbob dbob, String tableName, String gstFlagsVal, String colName, int docId) {

			String value = dbob.getDbob().getList(string,dbob.getCon(),tableName,gstFlagsVal,colName,docId);

			if(value.contains(",")) {
				return value.split(",");
			}
			else
			{
				return null;
			}
		}

		public String[] getListWithCondition(String string, Dbob dbob, String tableName, String gstFlagsVal, String colName, int id, String[] searchColNames, String colVal) {
			String value = dbob.getDbob().getListWithCondition(string,dbob.getCon(),tableName,gstFlagsVal,colName,id, searchColNames,colVal);

			if(value.contains(":")) {
				return value.split(":");
			}
			else
			{
				return null;
			}

                        }

		public void setFxDatePicker(JFXPanel fxPanel) {

			this.fxPanel=fxPanel;
		}

		public JFXPanel getFxDatePicker() {

			this.fxPanel=fxPanel;

			return this.fxPanel;
		}

		public boolean addBuyerDetails(Dbob dbob, String tableName, String buyerName, String gstNo, String phoneNo, String address, String remark, int vOoZ, int sId) {
			return dbob.getDbob().addBuyerDetails(dbob.getCon(),tableName,buyerName,gstNo,phoneNo,address,remark,vOoZ, sId);


                        }


		public int updateAllowancedetail(Dbob dbob, String tableName, float ratePerHr,float overtimeHours,float totalOverTime, float medical, float bonus, float other,int empId) {

			return dbob.getDbob().updateAllowancedetail(dbob.getCon(),tableName,ratePerHr,overtimeHours,totalOverTime, medical, bonus, other,empId);

		}
		public int addPathoLabOrPatientOrDocDetails(Dbob dbob, String tableName, String pathoLabName, String sex, String age, String emailId, String phoneNo, String phoneNo2, String phoneNo3, String address, String address2, String address3, String remark, int vOoZ, int sId, String degree, float commission, float fees,float actAmtText,String testReport, String tableNameReceiptDTL, String tableNameReportDTL, String childOrAdult) {



              if(vOoZ == 1) {
				  int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Update or Delete",
						  JOptionPane.YES_NO_OPTION,
						  JOptionPane.QUESTION_MESSAGE);
				  if (result == JOptionPane.YES_OPTION) {

					  return dbob.getDbob().addPathoLabOrPatientOrDocDetails(dbob.getCon(), tableName, pathoLabName, sex, age, emailId, phoneNo, phoneNo2, phoneNo3, address, address2, address3, remark, vOoZ, sId, degree, commission,fees,actAmtText,testReport,tableNameReceiptDTL, tableNameReportDTL, childOrAdult);

				  } else if (result == JOptionPane.NO_OPTION) {

					  return 0;
				  } else {
					  return 0;
				  }
			  }
			  else
			  {

				  return dbob.getDbob().addPathoLabOrPatientOrDocDetails(dbob.getCon(), tableName, pathoLabName, sex, age, emailId, phoneNo, phoneNo2, phoneNo3, address, address2, address3, remark, vOoZ, sId, degree, commission,fees,actAmtText, testReport, tableNameReceiptDTL, tableNameReportDTL, childOrAdult);


			  }
		}

		public boolean addPatientDetails(Dbob dbob, String tableName, String patientName, String emailId, String phoneNo, String address, String remark, int vOoZ, int sId) {
			return dbob.getDbob().addBuyerDetails(dbob.getCon(),tableName,patientName,emailId,phoneNo,address,remark,vOoZ, sId);


		}

		public int addPatientTestReceiptDetails(Dbob dbob, String tabName, int labId, String doctorName, String sampleCollectionBranch, String datePicker1Val, String datePicker2Val, String timePicker1Val, String timePicker2Val,int patientID, String patientNameVal, int ageVal, String gender, String isChildVal, String phoneNoVal, String emailIdVal, String address, String testName, int testGrouppId,float fees, float totalFees, float discount, float payable, float paid, float balance, int vOoZ, String gstFlagsVal, String remark, String searchKey) {
			return dbob.getDbob().addPatientTestReceiptDetails(dbob.getCon(),tabName, labId,doctorName,sampleCollectionBranch,datePicker1Val,
					datePicker2Val,timePicker1Val,timePicker2Val,
					patientID,patientNameVal,ageVal,gender,isChildVal,phoneNoVal,emailIdVal,address,
					testName,testGrouppId,fees,totalFees,discount,payable,paid,balance
					, vOoZ,remark, searchKey);

		}

		public String addPatientTestReportDetails(Dbob dbob, String tabName, String colName, int patientIdOrLabId, JTable table, String patientNameVal, String gender, int age, String phoneNo, String address, String remark, String isChildVal, String testGroup,String doctorName, String method, String testRemarks, String collectDate, String reportDate, String collectTime, String reportTime, int testGroupId, int iflag, String tabNamePDetail, String tabNameTRECDetail) {
           	return dbob.getDbob().addPatientTestReportDetails(dbob.getCon(),tabName, colName,patientIdOrLabId,table,patientNameVal,gender,age,phoneNo,address,remark,isChildVal,testGroup,doctorName,method,testRemarks,collectDate,reportDate,collectTime,reportTime, testGroupId,iflag,tabNamePDetail,tabNameTRECDetail);
		}





		public int addGroupDetails(Dbob dbob, String tableName, int testGroupId, String testGroupName,String chkBoxTestType,String testName, String defaultValue, String unit, String options, String normalValuesMale, String normalValuesFeMale, String normalValuesChildMale, String normalValuesChildFeMale, String status, String testNote, String searchKey, int vOoZ, String groupNamesTable) {

			return dbob.getDbob().addGroupDetails(dbob.getCon(),tableName, testGroupId,  testGroupName,chkBoxTestType,testName,
					defaultValue, unit, options, normalValuesMale
					, normalValuesFeMale, normalValuesChildMale, normalValuesChildFeMale, status, testNote, searchKey,vOoZ, groupNamesTable);

		}

		public int addPosNegGroupDetails(Dbob dbob, String tableName, int testGroupId, String testGroupName,String chkBoxTestType,String testName, String defaultValue, String unit, String options, String normalValuesMale, String normalValuesFeMale, String normalValuesChildMale, String normalValuesChildFeMale, String status, String testNote, String searchKey, int vOoZ, String groupNamesTable) {

			return dbob.getDbob().addGroupDetails(dbob.getCon(),tableName, testGroupId,  testGroupName,chkBoxTestType,testName,
					defaultValue, unit, options, normalValuesMale
					, normalValuesFeMale, normalValuesChildMale, normalValuesChildFeMale, status, testNote, searchKey,vOoZ, groupNamesTable);

		}



		public void addOrgDetail(Dbob dbob, String tableName, String strCompanyName, String strTopHead, String strAuthorisedBy, String strImageOrLogoPath) {

			dbob.getDbob().addOrgDetail(dbob.getCon(),tableName, strCompanyName,strTopHead,strAuthorisedBy,strImageOrLogoPath);

		}


		public String insertInToOrderTable(Dbob dbob, JTable table, String quotationId, String quotationName, String supplierName, String partyName,String transportName, String tableName, String inTableName, String[] gstFlagsVal) {

			String ordId=dbob.getDbob().insertInToOrderTable(dbob.getCon(),table,quotationId,quotationName,supplierName,partyName,transportName,tableName ,inTableName,gstFlagsVal);
		return ordId;
                        }



		public boolean deleteFromOrderTable(Dbob dbob, JTable table, String tableName, String inTableName, String colName, String colVal) {

		boolean flag=	dbob.getDbob().deleteFromOrderTable(dbob.getCon(),table,tableName, inTableName,colName,colVal);

                return flag;
                        }


		public boolean deleteFromTables(Dbob dbob, JTable table, String tableName, String colName, String strKey, String strDelKey, String[] gstFlagsVal, String ordType, String colVal) {

			boolean flag=	dbob.getDbob().deleteFromTables(dbob.getCon(),table,tableName, colName,strKey,strDelKey,gstFlagsVal,ordType,colVal);

			return flag;

		}


			public void changeGstDetails(Dbob dbob, String tableName, int gstId, String txtChangeGstRateVal, int vOoZ,String gstCategory) {

			dbob.getDbob().changeGstDetails(dbob.getCon(),tableName,gstId,txtChangeGstRateVal,vOoZ,gstCategory);

		}



		public String[][] getDetail(Dbob dbob, String colVal, String tabName, String colName, String ordByCol, String gstFlagsVal, String strKey, String finalGender, String finalIsChildVal)
		{
			String dataValues[][]=null;
			String CylCatDetails[]=null;
			String RowColSize[]=null;
			int idx=0;
			//JOptionPane.showMessageDialog(null, " inside getDetail");


			//System.out.println("inside getDetail");


/*
			if(!(colName.equals("")) && !(colVal.equals("")))
			{
*/
				//System.out.println("inside if from getGoodsDetailimpl");

				//values+":"+rowCount+","+columnCount
				String goodsDetailsRowColCount[]= dbob.getDbob().getDetail(dbob.getCon(),colVal,tabName,colName,ordByCol,gstFlagsVal,strKey,finalGender, finalIsChildVal).split(";");


				String CylCatDetails1[]= goodsDetailsRowColCount[0].split("--");


				String RowColSize1[]= goodsDetailsRowColCount[1].split("--");
						//dbob.getDbob().getRowColCount(dbob.getCon(),cylCatVal,tabName,colName).split(":");
				CylCatDetails=CylCatDetails1;
				RowColSize=RowColSize1;
			/*}
			else
			{
				String CylCatDetails1[]= dbob.getDbob().getCylCategoryRecords(dbob.getCon(),colVal,tabName,colName).split("--");
				String RowColSize1[]= dbob.getDbob().getRowColCount(dbob.getCon(),colVal,tabName,colName).split(":");
				CylCatDetails=CylCatDetails1;
				RowColSize=RowColSize1;



			}
*/



			int rowSize=Integer.parseInt(RowColSize[0]);
			int colSize=Integer.parseInt(RowColSize[1]);

			System.out.println("from setAllCylCatRecords Row : "+rowSize+"  Col : "+colSize);


			dataValues=new String[rowSize][colSize];

			/*for(int idx2=0;idx2<CylCatDetails.length;idx2++)
			{

				System.out.println(idx2+" : "+CylCatDetails[idx2]);
			}*/

			//System.out.println("--->"+CylCatDetails.length);

			for(int idx1=0;idx1<rowSize;idx1++)
			{
				for(int idx2=0;idx2<colSize;idx2++)
				{

					idx++;
					if(idx<CylCatDetails.length)
					{
						System.out.println(idx+" : "+CylCatDetails[idx]);

						dataValues[idx1][idx2]=CylCatDetails[idx];

					}

				}

			}

			if(dataValues.length>0)
			{

				return dataValues;

			}









			return dataValues;

		}

		public String[] getMultiColListDetail(String strId, Dbob dbob, String tabName) {

			return dbob.getDbob().getMultiColListDetail(strId,dbob.getCon(),tabName).split(":");

		}

		public String[] getMultiColList(String strId, Dbob dbob, String tableName, String colName) {

			return dbob.getDbob().getMultiColList(strId,dbob.getCon(),tableName, colName).split(":");

		}

		public void addQuotationDetails(Dbob dbob, String tableName, String quotationName, String gstNo,String  bnkName,String bankAccNo, String termsCondition1, String termsCondition2, String termsCondition3, int vOoZ,int quoId) {

			 dbob.getDbob().addQuotationDetails(dbob.getCon(),tableName, quotationName,gstNo,bnkName,bankAccNo,termsCondition1,termsCondition2,termsCondition3,vOoZ, quoId);

		}

		public String[][] getSearchCatRecords(Dbob dbob, String colVal, String tabName, String[] colName, String ordByCol, String gstFlagsVal, String strKey, String finalGender, String finalIsChildVal)
		{
			String dataValues[][]=null;
			String CylCatDetails[]=null;
			String RowColSize[]=null;
			int idx=0;
			//JOptionPane.showMessageDialog(null, " inside getDetail");


			//System.out.println("inside getDetail");


			if(!(colName.equals("")) && !(colVal.equals("")))
			{
				//System.out.println("inside if from getGoodsDetailimpl");

				//values+":"+rowCount+","+columnCount
				String goodsDetailsRowColCount[]= dbob.getDbob().getDetail(dbob.getCon(),colVal,tabName,colName,ordByCol,strKey,finalGender, finalIsChildVal).split(";");

				String CylCatDetails1[]= goodsDetailsRowColCount[0].split("--");


				String RowColSize1[]= goodsDetailsRowColCount[1].split("--");
				//dbob.getDbob().getRowColCount(dbob.getCon(),cylCatVal,tabName,colName).split(":");
				CylCatDetails=CylCatDetails1;
				RowColSize=RowColSize1;
			}
			else
			{


			}




			int rowSize=Integer.parseInt(RowColSize[0]);
			int colSize=Integer.parseInt(RowColSize[1]);

			System.out.println("from setAllCylCatRecords Row : "+rowSize+"  Col : "+colSize);


			dataValues=new String[rowSize][colSize];

			/*for(int idx2=0;idx2<CylCatDetails.length;idx2++)
			{

				System.out.println(idx2+" : "+CylCatDetails[idx2]);
			}*/

			//System.out.println("--->"+CylCatDetails.length);

			for(int idx1=0;idx1<rowSize;idx1++)
			{
				for(int idx2=0;idx2<colSize;idx2++)
				{

					idx++;
					if(idx<CylCatDetails.length)
					{
						System.out.println(idx+" : "+CylCatDetails[idx]);

						dataValues[idx1][idx2]=CylCatDetails[idx];

					}

				}

			}

			if(dataValues.length>0)
			{

				return dataValues;

			}









			return dataValues;

		}
        /*{
			String dataValues[][]=null;
			String CylCatDetails[]=null;
			String RowColSize[]=null;
			int idx=0;


			if(colName.length>0 && !(cylCatVal.equals("")))
			{
				System.out.println("inside if from getCylCategoryRecords ImplDetails");


				String CylCatDetails1[]= dbob.getDbob().getSearchCategoryRecords(dbob.getCon(),cylCatVal,tabName,colName,gstFlagsVal).split("--");
				String RowColSize1[]= dbob.getDbob().getSearchCatRowColCount(dbob.getCon(),cylCatVal,tabName).split(":");
				CylCatDetails=CylCatDetails1;
				RowColSize=RowColSize1;
			}
			else
			{
				String CylCatDetails1[]= dbob.getDbob().getSearchCategoryRecords(dbob.getCon(),cylCatVal,tabName,colName, gstFlagsVal).split("--");
				String RowColSize1[]= dbob.getDbob().getSearchCatRowColCount(dbob.getCon(),cylCatVal,tabName).split(":");
				CylCatDetails=CylCatDetails1;
				RowColSize=RowColSize1;



			}




			int rowSize=Integer.parseInt(RowColSize[0]);
			int colSize=Integer.parseInt(RowColSize[1]);

			System.out.println("from setAllCylCatRecords Row : "+rowSize+"  Col : "+colSize);


			dataValues=new String[rowSize][colSize];

			for(int idx2=0;idx2<CylCatDetails.length;idx2++)
			{

				System.out.println(idx2+" : "+CylCatDetails[idx2]);
			}

			System.out.println("--->"+CylCatDetails.length);

			for(int idx1=0;idx1<rowSize;idx1++)
			{
				for(int idx2=0;idx2<colSize;idx2++)
				{

					idx++;
					if(idx<CylCatDetails.length)
					{
						System.out.println(idx+" : "+CylCatDetails[idx]);

						dataValues[idx1][idx2]=CylCatDetails[idx];

					}

				}

			}

			if(dataValues.length>0)
			{

				return dataValues;

			}









			return dataValues;

		}*/

		public String[] getDBLicennsedOrDemo(Dbob dbob, String check_license) {

			String value =	dbob.getDbob().getDBLicennsedOrDemo(dbob.getCon(),check_license);

			if(value.contains(":"))
			return value.split(":");
			else
				return  null;
		}

        public void addTransportDetails(Dbob dbob, String tableName, String transportName, String lrNo, String bankName, String bankAccNo, String ifscCode, String agent, String totalDagina, int vOoZ, int transportId) {
				dbob.getDbob().addTransportDetails(dbob.getCon(),tableName, transportName, lrNo, bankName, bankAccNo, ifscCode, agent, totalDagina,  vOoZ,transportId);
        }


		public void setDemoLicDate(Dbob dbob, String tableName, String dbValueStartDate, String stringDemoOrLic) {

			dbob.getDbob().setDemoLicDate(dbob.getCon(),tableName, dbValueStartDate,stringDemoOrLic);

		}

		public void setLicKeyToEncrypt(Dbob dbob, String tableName, String key, String hkeys) {
			dbob.getDbob().setLicKeyToEncrypt(dbob.getCon(),tableName, key,hkeys);

			}

		public void addGstDetails(Dbob dbob, String gstTypeVal, int gstRate, String tableName) {
			dbob.getDbob().addGstDetails(dbob.getCon(),gstTypeVal,gstRate,tableName);

		}

		public int addGroupName(Dbob dbob, String reportTitle, String groupName, String tableName, int vOoZ, String shortName, float rate, String srchKey, String colName, int groupId) {


			if(vOoZ == 1) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Update",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {

					return dbob.getDbob().addGroupName(dbob.getCon(),reportTitle , groupName,tableName,vOoZ,shortName,rate,srchKey, colName, groupId);

				} else if (result == JOptionPane.NO_OPTION) {

					return 0;
				} else {
					return 0;
				}
			}
			else
			{

				return dbob.getDbob().addGroupName(dbob.getCon(),reportTitle , groupName,tableName,vOoZ,shortName,rate, srchKey, colName, groupId);


			}


		}

		public int addDocTestGroupName(Dbob dbob, String reportTitle, String groupName, String tableName, int vOoZ, String shortName, float rate, float commission, float actAmt, String srchKey, String colName, int groupId, int docId) {


			if(vOoZ == 1) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Update",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {

					return dbob.getDbob().addDocTestGroupName(dbob.getCon(),reportTitle , groupName,tableName,vOoZ,shortName,rate,commission, actAmt,srchKey, colName, groupId,docId);

				} else if (result == JOptionPane.NO_OPTION) {

					return 0;
				} else {
					return 0;
				}
			}
			else
			{

				return dbob.getDbob().addDocTestGroupName(dbob.getCon(),reportTitle , groupName,tableName,vOoZ,shortName,rate,commission, actAmt,srchKey, colName, groupId,docId);


			}


		}



		boolean isValidSimOrd(String value,String matchString) {

			if (matchString.equalsIgnoreCase("mobile")) {
				String regex = "[0-9]+";
				return value.matches(regex);

			}
			else
			{
				String regex = "^[\\p{L} .'-]+$";
				return value.matches(regex);
			}


			}



	public 	boolean isValid(String value,String matchString) {

			if (matchString.equalsIgnoreCase("mobile")) {
				String regex = "[0-9]+";
				return value.matches(regex);

			}
			if (matchString.equalsIgnoreCase("number")) {
				String regex = "[0-9]+";
				return value.matches(regex);

			}
			else if (matchString.equalsIgnoreCase("numberfloat")) {
				String regex = "[0-9]*\\.?[0-9]+";
				return value.matches(regex);

			}
             else if (matchString.equalsIgnoreCase("validmobile")) {

				Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
				Matcher m = p.matcher(value);
				return (m.find() && m.group().equals(value));
			}else if (matchString.equalsIgnoreCase("accno")) {
				String regex = "[0-9]+";
				return value.matches(regex);

			}

			else if(matchString.equalsIgnoreCase("email")){
				String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
				return value.matches(regex);
			}
			else if(matchString.equalsIgnoreCase("name"))
			{
				String regex = "[a-zA-Z]+";
				//String regex = "^[\\p{L} .'-]+$";
				return value.matches(regex);
			}
			else if(matchString.equalsIgnoreCase("address"))
			{
				String regex = "^[A-Za-z0-9\\s]+$";
				return value.matches(regex);
			}
			else
			{
				String regex = "[a-zA-Z0-9]+";
				return value.matches(regex);
			}

		}


		public void changeGstFlags(Dbob dbob, String finalTableGstFlag,String gst_col, String gstCategory,float gstRate,int gst_s_no) {

			dbob.getDbob().changeGstFlags(dbob.getCon(),finalTableGstFlag,gst_col, gstCategory,gstRate,gst_s_no);

		}

		public String[] getGstFlag(String gst_col, Dbob dbob, String tableGstFlag, String string) {

			String gstVal= dbob.getDbob().getGstFlag(gst_col,dbob.getCon(),tableGstFlag,string);

			          if(gstVal!=null && gstVal.length()>0 && gstVal.contains(":"))
                         return gstVal.split(":");
			          else
			          	 return null;

                        }


		public void addGstFlag(Dbob dbob, int uniQID,String gstType, float gstRate, String tableName)
		{

			dbob.getDbob().addGstFlag(dbob.getCon(),uniQID,gstType, gstRate, tableName);

		}

		public String insertInToReceiptTable(Dbob dbob, JTable table, String quotationId, String quotationName, String supplierName, String partyName, String tableName, String inTableName, String receiptNo, String chequeId, String receivedAmount, String totalQty, String totalPrice, String remainQty, String remainPrice, String[] gstFlagsVal) {

			String ordId=dbob.getDbob().insertInToReceiptTable(dbob.getCon(),table,quotationId,quotationName,supplierName,partyName,tableName, inTableName,receiptNo, chequeId, receivedAmount, totalQty, totalPrice, remainQty, remainPrice, gstFlagsVal);
			return ordId;
                        }

		public String[] getGoodsColNames(Dbob dbob, String tabName, String gstFlagsVal, String strKey) {
			String columnNames[]= dbob.getDbob().getGoodsColumnNames(dbob.getCon(),tabName,gstFlagsVal,strKey).split(":");

			return columnNames;
		}


		public String[] getGoodsColNames(Dbob dbob, String tabName, String s, String strKey, String finalGender, String finalIsChildVal) {
			String columnNames[]= dbob.getDbob().getGoodsColumnNames(dbob.getCon(),tabName,strKey,finalGender, finalIsChildVal).split(":");

			return columnNames;


		}

		public int addMethod(Dbob dbob, String tableName, String methodName, String description, String srchKey, int vooz, int methodId) {
			return dbob.getDbob().addMethod(dbob.getCon(),tableName,methodName , description,srchKey, vooz, methodId);
		}

		public String getDateValue(Dbob dbob,String string) {
			return dbob.getDbob().getDateVal(string);
		}

		public Date getSqlDateValue(Dbob dbob, String string) {
			return dbob.getDbob().getDate(string);
		}

		public String getTimeValue(Dbob dbob,String string) {
			return dbob.getDbob().getTimeVal(string);
		}



		public String getIncomeDetail(String strKey, Dbob dbob, String tableName, String colName, String fromDate, String toDate, String colVal) {

			return dbob.getDbob().getIncomeDetail(dbob.getCon(), tableName, colName,strKey, fromDate ,toDate,colVal);
		}

		public boolean updateReport(Dbob dbob, JTable table, String tableName, String strKey, String colName, String strDelKey, String ordType, String colName2, int IdFromComboList, String tabNamePDetail, String loginDate,String shift,String markPOrA, String remark,String adharNo) {

			int result = JOptionPane.showConfirmDialog(null,"Are you sure?", "Update or Delete",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if(result == JOptionPane.YES_OPTION){

				return dbob.getDbob().updateReport(dbob.getCon(),table, tableName, strKey, colName, strDelKey, ordType,  colName2,IdFromComboList,tabNamePDetail,loginDate,shift,markPOrA,remark, adharNo);

			}else if (result == JOptionPane.NO_OPTION){

				return false;
			}else {
				return false;
			}

		}

		public void attendanceCount(Dbob dbob, LGAObj LObj, int empId, String userName, String division, String startBranch, String adharNo, String shift, String loginDate, String markPOrA, String remark) {
			Statement stat =null;
			ResultSet result =null;
			PreparedStatement pstat = null;
			try {
				String tableName ="attendance_count_detail_"+startBranch;

				Connection con= dbob.getCon();

				Statement statChk = con.createStatement();
					stat = con.createStatement();

					result = stat.executeQuery("select * from " + tableName);

					ResultSetMetaData rsmd = result.getMetaData();


					int columnCount = rsmd.getColumnCount();

/*
							ID INT NOT NULL " +
							"CONSTRAINT PK_ADM_TBL PRIMARY KEY," +
									" user_id VARCHAR(255) , password VARCHAR(255)
*/

					pstat = dbob.getCon().prepareStatement("insert into " + tableName + " values(?,?,?,?,?,?,?,?,?)");


					//String loginDate="";
					for (int i = 1; i <= columnCount; i++) {


						System.out.println("party_detail i value " + i);

						if (rsmd.getColumnName(i).equals("ID")) {
							int uniqId = LObj.getLGAObj().genEmpId(dbob, tableName);

							pstat.setInt(i, uniqId);
							System.out.println("From addVahicalValues  ID setting values " + uniqId + "  -->Col No" + i);


						}


						if (rsmd.getColumnName(i).equals("EMP_ID")) {
							pstat.setInt(i, empId);


						}

						if (rsmd.getColumnName(i).equals("DAYS_P")) {

							pstat.setInt(i, 0);
							//System.out.println("From addVahicalValues VehicalName setting values " + name + "  -->Col No" + i);


						}


						if (rsmd.getColumnName(i).equals("PAYMENT")) {

							pstat.setInt(i, 0);
							//System.out.println("From addVahicalValues VehicalName setting values " + name + "  -->Col No" + i);


						}


						if (rsmd.getColumnName(i).equals("DAYS_A")) {


							pstat.setInt(i, 0);
							//System.out.println("From addVahicalValues  VehicalFuelType setting values " + phoneNo + "  -->Col No" + i);


						}




						if (rsmd.getColumnName(i).equals("DATE_UPDATED")) {


							pstat.setString(i, loginDate);
							//System.out.println("From addVahicalValues  VehicalFuelType setting values " + phoneNo + "  -->Col No" + i);


						}


						if (rsmd.getColumnName(i).equals("DIVISION")) {
							pstat.setString(i, division);
							//System.out.println("From addVahicalValues  VehicalFuelType setting values " + phoneNo + "  -->Col No" + i);


						}

						if (rsmd.getColumnName(i).equals("ADHAR_NO")) {
							pstat.setString(i, adharNo);
							//System.out.println("From addVahicalValues  VehicalFuelType setting values " + phoneNo + "  -->Col No" + i);

						}
						if (rsmd.getColumnName(i).equals("SHIFT")) {
							pstat.setString(i, shift);
							//System.out.println("From addVahicalValues  VehicalFuelType setting values " + phoneNo + "  -->Col No" + i);

						}

						if (rsmd.getColumnName(i).equals("REMARK")) {
							pstat.setString(i, remark);
							//System.out.println("From addVahicalValues  VehicalFuelType setting values " + phoneNo + "  -->Col No" + i);

						}



             /*String strAttendanceDetailCreateQuery="CREATE TABLE attendance_detail_"+branch+"(ID INT NOT NULL " +
				", EMP_ID INT NOT NULL ," +
				" username VARCHAR(255), division VARCHAR(255), login_date VARCHAR(255),adhar_no VARCHAR(255),shift VARCHAR(255),marked VARCHAR(255),"
                        + "remark VARCHAR(255))";
              */

					}


					int insertVal = pstat.executeUpdate();
					//boolean insertVal=pstat.execute();

					System.out.println("row inserted");
					if (insertVal > 0) {
						System.out.println("Value from exUpdate--->" + insertVal);

						JOptionPane.showMessageDialog(null, userName + " log in " + loginDate);


					}


			}catch (Exception e)
			{  e.printStackTrace();
				JOptionPane.showMessageDialog(null,e);
				//e.printStackTrace();

			}
			finally {

				try{
					result.close();
					stat.close();
					pstat.close();
				}
				catch(Exception e){

				}
			}

		}


		public  boolean addUserAdminStaffDetail(LGAObj LObj, Dbob dbob, String tableName, String branch, int empId, String adharNo, String shift, String firstName, String lastName, String dob, String email, String telephone, String address, String dept, int salary, String gender, String address2, String postCode, String designation, String status, String jobTitle, String apartment, String doj, int vOoZ) {

			dbob.getDbob().addUserAdminStaffDetail(LObj,dbob,dbob.getCon(), tableName, branch, empId, adharNo, shift, firstName, lastName, dob, email, telephone, address, dept, salary, gender, address2, postCode, designation, status, jobTitle, apartment, doj,vOoZ);
			return false;
		}
		public void attendance(Dbob dbob, LGAObj LObj, int empId, String userName,String  gender,String division, String startBranch, String adharNo, String shift, String loginDate, String markPOrA, String remark, float payment) {
			Statement stat =null;
			ResultSet result =null;
			PreparedStatement pstat = null;
			try {
				String tableName ="attendance_detail_"+startBranch;

				Connection con= dbob.getCon();

				Statement statChk = con.createStatement();

				Date sqlDateLoginDate = LObj.getLGAObj().getSqlDateValue(dbob, loginDate);
				ResultSet	resultChk = statChk.executeQuery("select * from " + tableName +" where emp_id="+empId+" AND login_date='"+sqlDateLoginDate+"'");

				if(resultChk.next()){

					JOptionPane.showMessageDialog(null,"Already Logged in!!");

				}
				else {
					stat = con.createStatement();

					result = stat.executeQuery("select * from " + tableName);

					ResultSetMetaData rsmd = result.getMetaData();


					int columnCount = rsmd.getColumnCount();

/*
							ID INT NOT NULL " +
							"CONSTRAINT PK_ADM_TBL PRIMARY KEY," +
									" user_id VARCHAR(255) , password VARCHAR(255)
*/

					pstat = dbob.getCon().prepareStatement("insert into " + tableName + " values(?,?,?,?,?,?,?,?,?,?,?)");


					//String loginDate="";
					for (int i = 1; i <= columnCount; i++) {


						System.out.println("party_detail i value " + i);

						if (rsmd.getColumnName(i).equals("ID")) {
							int uniqId = LObj.getLGAObj().genEmpId(dbob, tableName);

							pstat.setInt(i, uniqId);
							System.out.println("From addVahicalValues  ID setting values " + uniqId + "  -->Col No" + i);


						}


						if (rsmd.getColumnName(i).equals("EMP_ID")) {
							pstat.setInt(i, empId);


						}

						if (rsmd.getColumnName(i).equals("USERNAME")) {

							pstat.setString(i, userName);
							//System.out.println("From addVahicalValues VehicalName setting values " + name + "  -->Col No" + i);


						}
						if (rsmd.getColumnName(i).equals("GENDER")) {

							pstat.setString(i, gender);
							//System.out.println("From addVahicalValues VehicalName setting values " + name + "  -->Col No" + i);


						}

						if (rsmd.getColumnName(i).equals("LOGIN_DATE")) {


							pstat.setDate(i, sqlDateLoginDate);
							//System.out.println("From addVahicalValues  VehicalFuelType setting values " + phoneNo + "  -->Col No" + i);


						}

						if (rsmd.getColumnName(i).equals("DIVISION")) {
							pstat.setString(i, division);
							//System.out.println("From addVahicalValues  VehicalFuelType setting values " + phoneNo + "  -->Col No" + i);


						}

						if (rsmd.getColumnName(i).equals("ADHAR_NO")) {
							pstat.setString(i, adharNo);
							//System.out.println("From addVahicalValues  VehicalFuelType setting values " + phoneNo + "  -->Col No" + i);

						}
						if (rsmd.getColumnName(i).equals("SHIFT")) {
							pstat.setString(i, shift);
							//System.out.println("From addVahicalValues  VehicalFuelType setting values " + phoneNo + "  -->Col No" + i);

						}

						if (rsmd.getColumnName(i).equals("REMARK")) {
							pstat.setString(i, remark);
							//System.out.println("From addVahicalValues  VehicalFuelType setting values " + phoneNo + "  -->Col No" + i);

						}

						if (rsmd.getColumnName(i).equals("MARKED")) {
							pstat.setString(i, markPOrA);
							//System.out.println("From addVahicalValues  VehicalFuelType setting values " + phoneNo + "  -->Col No" + i);

						}


						if (rsmd.getColumnName(i).equals("PAYMENT")) {
							pstat.setFloat(i, payment);
							//System.out.println("From addVahicalValues  VehicalFuelType setting values " + phoneNo + "  -->Col No" + i);

						}

             /*String strAttendanceDetailCreateQuery="CREATE TABLE attendance_detail_"+branch+"(ID INT NOT NULL " +
				", EMP_ID INT NOT NULL ," +
				" username VARCHAR(255), division VARCHAR(255), login_date VARCHAR(255),adhar_no VARCHAR(255),shift VARCHAR(255),marked VARCHAR(255),"
                        + "remark VARCHAR(255))";
              */

					}


					int insertVal = pstat.executeUpdate();
					//boolean insertVal=pstat.execute();

					System.out.println("row inserted");
					if (insertVal > 0) {
						System.out.println("Value from exUpdate--->" + insertVal);

						JOptionPane.showMessageDialog(null, userName + " log in " + loginDate);


					}
				}

			}catch (Exception e)

			{  e.printStackTrace();
				JOptionPane.showMessageDialog(null,e);
				//e.printStackTrace();

			}
			finally {

				try{
					result.close();
					stat.close();
					pstat.close();
				}
				catch(Exception e){

				}
			}

		}



		public int genEmpId(Dbob dbob,String tabName) {

			return dbob.getDbob().genUniId(dbob.getCon(), tabName);
		}

		public String getAmountDetail(Dbob dbob, String tabName, String colNameSum, String strKey, String[] colNames, String colVal) {

			return dbob.getDbob().getAmountDetail(dbob.getCon(), tabName, colNameSum, strKey, colNames, colVal);

		}


		public void addUserAdminValues(Dbob dbob, String user_tab, String username, String password, String admin, String admin_123, int i, int i1, int i2, String admin1, String adharNo) {
			dbob.getDbob().addUserAdminValues(dbob.getCon(),"user_tab", "username", "password","admin", "Admin_123",0,0,0,"Admin",adharNo);

		}
	}