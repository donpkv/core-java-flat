package dbaselogin;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abhishek Vaishnav
 */

//import net.ucanaccess.jdbc.*;



import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

//import com.healthmarketscience.jackcess.*;

public class Dbcon {


	private static Dbcon dbobj = null;


	//static String uaccessUrl = "jdbc:ucanaccess://";
	private static Splash splash;
	String user = "";
	String pass = "";
	//static String dbpath = "U:\\Techshiva\\materials\\projects\\java\\Construct\\automob.accdb";
	//static String dbpath = ".\\automob.accdb";


	private static Connection con;
	private static Statement stat;
	private static Statement oldStat;
	private static ResultSet result;
	private static ResultSet oldResult;
	private static PreparedStatement pstat;
	private static ResultSetMetaData rsmd;
	private static int genUniId;
	private static int genUniCode;
	private static int genFirstRecId;
	private int columnCount;
	private int colNoID;
	private int colNoTotal_Amount;
	private String colNameTotal_Amount;

	private int colNoOldTotal_Amount;
	private String colNameOldTotal_Amount;

	private int colNoPurchase_Date;
	private String colNamePurchase_Date;


	private int colNoStaffID;
	private String colNameStaff_ID;
	private int colNoStaff_Name;
	private String colNameStaff_Name;
	private int colNoStaffJoin_Date;
	private String colNameStaffJoin_Date;

	private int colNoPartyID;
	private String colNameParty_ID;
	private int colNoParty_Name;
	private String colNameParty_Name;
	private int colNoPartyJoin_Date;
	private String colNamePartyJoin_Date;
	private int colNoParty_Cash_Given;
	private String colNameParty_Cash_Given;


	private int colNoDOB;
	private int colNoFathersName;
	private int colNoMothersName;
	private int colNoAddress;
	private int colNoTotalPaid;
	private int colNoBalance;
	private int colNoRemarks;
	private int colNoDate;
	private int colNoReceipt;

	private int colNoSaleID;
	//private String colNameSale_ID;
	private int colNoSaleStaff_Name;
	private String colNameSaleStaff_Name;

	private int colNoSaleBalance_Cyl;
	private String colNameSaleBalance_Cyl;
	private int colNoSaleGiven_Amt;
	private String colNameSaleGiven_Amt;
	private int colNoSaleTotal_Amt;
	private String colNameSaleTotal_Amt;
	private int colNoSaleBalance_Amt;
	private String colNameSaleBalance_Amt;

	private int colNoSale_Date;
	private String colNameSale_Date;
	private int colNoSaleCash_Total;
	private String colNameSaleCash_Total;
	private int colNoSale_ID;
	private String colNameSale_ID;

	private int colNoSaleCash_Cheque;
	private String colNameSaleCash_Cheque;
	private int colNoSaleCheque_Amt;
	private String colNameSaleCheque_Amt;
	private int colNoSaleRemarks;
	private String colNameSaleRemarks;


	private int colNoSaleReportID;
	private String colNameSaleReport_ID;

	private int colNoSaleReportCurrent_Balance_Amount;
	private String colNameSaleReportCurrent_Balance_Amount;
	private int colNoSaleReportTotal_Amount;
	private String colNameSaleReportTotal_Amount;
	private int colNoSaleReportT_Date;
	private String colNameSaleReportT_Date;
	private int colNoSaleReportTotal_Cash;
	private String colNameSaleReportTotal_Cash;


	private int col_ID;
	private int col_vehical_name;
	private int col_fuel_type;
	private int col_model;
	private int col_brand;
	private int col_year;
	private int col_chasiID;
	private int col_price;
	private int col_engine_no;
	private int col_vehical_id;

	private String col_name_ID;
	private String col_name_vehical_name;
	private String col_name_fuel_type;
	private String col_name_model;
	private String col_name_brand;
	private String col_name_year;
	private String col_name_chasiID;
	private String col_name_price;
	private String col_name_engine_no;


	//private String cylDate;

	private SimpleDateFormat simpleDateFormat;
	private Date d;
	private int col_vehical_entry_date;
	private String col_name_vehical_entry_date;
	private int col_entry_date;
	private String entryDate;
	private int colNoSaleAvailVehicalCount;
	private int colNoSaleVehSellCount;
	private int colNoSaleBalance_Vehical;
	private int colNoSaleVehical_Category;
	private String colNameSaleVehical_Category;
	private String colNameSaleAvailVehicalCount;
	private String colNameSaleVehSellCount;
	private int colNoSaleReportCyl_Category;
	private String colNameSaleReportCyl_Category;
	private int colNoSaleReportCyl_Fill_Start_Qty;
	private String colNameSaleReportCyl_Fill_Start_Qty;
	private int colNoSaleReportCyl_Fill_Current_Qty;
	private String colNameSaleReportCyl_Fill_Current_Qty;
	private int colNoSaleReportCyl_Empty_Total_Balance;
	private String colNameSaleReportCyl_Empty_Total_Balance;
	private int colNoSaleStaffID;
	private String colNameSale_StaffID;
	private int colNoSaleCheque_ID;
	private String colNameSaleCheque_ID;
	private String colNameSaleBalance_Vehical;
	private int col_color;
	private int col_key_no;
	private String col_name_color;
	private String col_name_key_no;
	private int colNoSaleChesiID;
	private int colNoSaleEngine_No;
	private int colNoSaleColor;
	private int colNoSaleKey;
	private String colNameSaleChesiID;
	private String colNameSaleEngine_No;
	private String colNameSaleColor;
	private String colNameSaleKey;
	private int colNoSaleInvoiceNo;
	private String colNameSaleInvoiceNo;
	private int colNoSaleModel;
	private String colNameSaleModel;
	private int colNoSaleCustomerName;
	private String colNameSaleCustomerName;
	private int colNoSaleDiscountValue;
	private String colNameSalediscountValue;
	private int col_old_Balance;
	private int col_balance;
	private String col_name_old_Balance;
	private String col_name_balance;
	private int col_diesel;
	private int col_expenses;
	private int col_cashDeposit;
	private int col_orderOrBuyer;
	private int col_loader;
	private int col_amount;
	private int col_vivaran;
	private int col_from_to;
	private int col_conductor_name;
	private int col_driver_name;
	private int col_end_reading;
	private int col_start_reading;
	private int col_from;
	private int col_dd_driver_name;
	private int col_dd_address;
	private int col_dd_contact;
	private int col_dd_amount;
	private int col_dd_remark;
	private int col_dd_entry_date;
	private int col_dd_ID;
	private int col_driver_id;
	private int col_old_ExpVal;
	private int col_vd_entry_date;
	private int col_vd_remark;
	private int col_vd_vehical_chasis;
	private int col_vd_vehical_model;
	private int col_vd_vehical_no;
	private int col_vd_vehical_name;
	private int col_vd_ID;
	private int col_md_entry_date;
	private int col_md_ID;
	private int col_md_material_name;
	private int col_md_material_size;
	private int col_md_material_qty;
	private int col_md_material_price;
	private int col_md_remark;
	private int col_material_price;
	private int col_material_qty;
	private int col_material_name;
	private int col_material_id;
	private int col_vehical_no;
	private int col_bd_ID;
	private int col_bd_buyer_name;
	private int col_bd_phone_no;
	private int col_bd_address;
	private int col_bd_remark;
	private int col_bd_entry_date;
	private String col_name_material_size;
	private int col_gd_ID;
	private int col_gd_material_name;
	private String col_name_material_name;
	private int col_gd_material_code;
	private String col_name_material_code;
	private int col_gd_material_qty;
	private String col_name_material_qty;
	private int col_gd_material_unit;
	private String col_name_material_unit;
	private int col_gd_material_Price;
	private String col_name_material_Price;
	private int col_gd_material_discount;
	private String col_name_material_discount;
	private int col_gd_material_CGST_Rate;
	private String col_name_material_CGST_Rate;
	private int col_gd_material_CGST_Amount;
	private String col_name_material_CGST_Amount;
	private int col_gd_material_SGST_Rate;
	private String col_name_material_SGST_Rate;
	private int col_gd_material_SGST_Amount;
	private String col_name_material_SGST_Amount;
	private int col_gd_material_calc_Amount;
	private String col_name_material_calc_Amount;
	private int col_gd_entry_date;
	private String col_name_entry_date;
	private int col_quod_ID;
	private int col_quod_quo_name;
	private int col_quod_gst_no;
	private int col_quod_bnkacc_no;
	private int col_quod_terms_cond1;
	private int col_quod_terms_cond2;
	private int col_quod_terms_cond3;
	private int col_trans_ID;
	private int col_trans_name;
	private int col_trans_lr_no;
	private int col_trans_bnk_name;
	private int col_trans_bnk_acc_no;
	private int col_trans_ifsc_code;
	private int col_trans_agent;
	private int col_trans_tot_dagina;
	private int col_chklic_ID;
	private int col_chklic_date;
	private int col_chklic_pkey;
	private int col_chklic_f_key;
	private int col_chklic_lic_or_demo;
	private static ArrayList arrayList;
	private int col_gst_ID;
	private int col_gst_type_name;
	private int col_gst_rate;
	private int col_gds_ID;
	private int col_gds_name;
	private int col_gds_status;
	private int col_bd_gst_no;
    private int col_org_ID;
    private int col_org_name;
    private int col_org_tophead;
    private int col_org_auth_person;
    private int col_pd_ID;
    private int col_pd_buyer_name;
    private int col_pd_phone_no;
    private int col_pd_gst_no;
    private int col_pd_address;
    private int col_pd_remark;
    private int col_pd_entry_date;
	private int genSimpleOrdId;
	private int col_simbd_ID;
	private int col_simbd_buyer_name;
	private int col_simbd_phone_no;
	private int col_simbd_address;
	private int col_simbd_remark;
	private int col_simbd_entry_date;
	private int col_simgst_ID;
	private int col_simgst_type_name;
	private int col_simgst_rate;
	private int genUniLabId;
	private int genUniEmpId;
	private int genUniAdminId;

	private Dbcon() {

	}

	public static Dbcon getDbcon() {
		if (dbobj == null) {
			return new Dbcon();
		}

		return dbobj;
	}

	public static Connection getCon(String user, String keyPswd) {
		try {

/*
			String dbURL = "jdbc:derby:.\\dbsample.db;create=true;user="+user+";password="+keyPswd;

			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
                  con= DriverManager.getConnection(dbURL);
*/


			String dbURL = "jdbc:mysql://localhost:3306/datatable";
            String userName="root";
			String password="";

			Class.forName("com.mysql.jdbc.Driver").newInstance();
                  con= DriverManager.getConnection(dbURL,userName,password);



		/*		Class.forName("oracle.jdbc.driver.OracleDriver");
			    con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");

			JOptionPane.showMessageDialog(null,"Connected to ORACLE");
*/


			//splash= new Splash(con);
     			//createDB(con);

                  /*
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			CryptCodecOpener codec = new CryptCodecOpener();
			CryptCodecProvider cc = new CryptCodecProvider();

			File file = new File(strFileName);


			Database db = codec.open(file, keyPswd);


					con = DriverManager.getConnection(uaccessUrl + strFileName+";jackcessOpener=lga.CryptCodecOpener", "user", keyPswd);
*/


		} catch (Exception e) {
			System.out.println("DBConnection Error My Dear--->" + e);
		}

		return con;
	}
//private

	public void createDB(Connection con, String branch)
	{
		String retrnVal=null;
		String val=null;



		String strAttendanceDetailCreateQuery="CREATE TABLE attendance_detail_"+branch+"(ID INT NOT NULL " +
				", EMP_ID INT NOT NULL ," +
				" username VARCHAR(30000),gender VARCHAR(255), division VARCHAR(30000), login_date DATE NOT NULL,adhar_no VARCHAR(30000),shift VARCHAR(30000),marked VARCHAR(30000),"
                        + "payment decimal(12,2),remark VARCHAR(30000))";

		String strTotalAttendanceNPayDetailCreateQuery="CREATE TABLE total_attendance_pay_detail_"+branch+"(ID INT NOT NULL " +
				", EMP_ID INT NOT NULL ,username VARCHAR(30000)," +
				" shift VARCHAR(30000),payment decimal(12,2),pdays decimal(12,1), total_pay decimal(12,2), " +
				"ot decimal(12,2),ot_payment decimal(12,2),net_payment decimal(12,2),total_cr decimal(12,2),total_dr decimal(12,2),login_date DATE NOT NULL)";


		String strStaffDetailCreateQuery="CREATE TABLE staff_detail_"+branch+"(ID INT NOT NULL ," +
				" first_name VARCHAR(30000), last_name VARCHAR(30000), dob DATE NOT NULL,email VARCHAR(30000)," +
				"contact_no VARCHAR(30000), address VARCHAR(30000), dept VARCHAR(30000), image BLOB," +
				"salary decimal(12,2) ,gender VARCHAR(255),address2 VARCHAR(30000), post_code VARCHAR(30000),designation VARCHAR(30000),status VARCHAR(30000)," +
				"job_title VARCHAR(30000), apartment VARCHAR(30000), date_hired DATE NOT NULL,adhar_no VARCHAR(30000) NOT NULL CONSTRAINT ADH_NO_UK UNIQUE"
                        + ",shift VARCHAR(30000))";


		String strAdvPayDetailCreateQuery="CREATE TABLE advance_pay_detail_"+branch+"(ID INT NOT NULL " +
				",E_ID INT NOT NULL ," +
				" first_name VARCHAR(30000), last_name VARCHAR(30000),gender VARCHAR(255),dept VARCHAR(30000), basic decimal(12,2)," +
				"CREDIT decimal(12,2),DEBIT decimal(12,2),pay_date DATE NOT NULL,till_date DATE NOT NULL," +
				"created_by VARCHAR(30000),adhar_no VARCHAR(30000),cred_debt VARCHAR(30000),shift_v VARCHAR(30000),remark VARCHAR(30000))"; //salary VARCHAR(30000),




		String strAuditDetailCreateQuery="CREATE TABLE audit_tab_"+branch+"(emp_id VARCHAR(30000), date VARCHAR(30000), status VARCHAR(30000),adhar_no VARCHAR(30000))";

		String strAllowanceDetailCreateQuery="CREATE TABLE allowance_detail_"+branch+"(created_by VARCHAR(30000),emp_id INT," +
				"ot_hrs decimal(12,2),overtime decimal(12,2),medical decimal(12,2),bonus decimal(12,2),other decimal(12,2)," +
				"salary decimal(12,2),rate decimal(12,2),total_allowance decimal(12,2) ,firstname VARCHAR(30000) ,surname VARCHAR(30000),gender VARCHAR(255),adhar_no VARCHAR(30000)," +
				"shift VARCHAR(30000),entry_date DATE NOT NULL)";


		String strDeductionDetailCreateQuery="CREATE TABLE deduction_detail_"+branch+"(ID INT NOT NULL ," +
				"firstname VARCHAR(30000),surname VARCHAR(30000),gender VARCHAR(255)," +
				"salary decimal(12,2),deduction_amount decimal(12,2),deduction_reason VARCHAR(30000),emp_id VARCHAR(30000)," +
				"made_by VARCHAR(30000),adhar_no VARCHAR(30000),entry_date DATE NOT NULL)";


/*

		String strSimpleGstFlagCreateQuery="CREATE TABLE simple_gst_flag(ID INT ," +
				"GST_CAT VARCHAR(30000) , GST_RATE FLOAT)";

		String strGstFlagCreateQuery="CREATE TABLE gst_flag(ID INT ," +
				"GST_CAT VARCHAR(30000) , GST_RATE FLOAT)";


		String strSimpleGstDetailCreateQuery="CREATE TABLE simple_gst_detail(ID INT NOT NULL " +
				"CONSTRAINT GST_SIM_PK PRIMARY KEY," +
				" GST_TYPE VARCHAR(30000) NOT NULL CONSTRAINT G_SIM_T_UK UNIQUE, GST_RATE FLOAT)";

		String strGstDetailCreateQuery="CREATE TABLE gst_detail(ID INT NOT NULL " +
				"CONSTRAINT GST_PK PRIMARY KEY," +
				" GST_TYPE VARCHAR(30000) NOT NULL CONSTRAINT G_T_UK UNIQUE, GST_RATE FLOAT)";
*/




		Statement stat=null;
		try{
			arrayList =new ArrayList();


			arrayList.add(strAttendanceDetailCreateQuery);
			arrayList.add(strStaffDetailCreateQuery);
			arrayList.add(strAdvPayDetailCreateQuery);
			arrayList.add(strTotalAttendanceNPayDetailCreateQuery);
			arrayList.add(strAuditDetailCreateQuery);
			arrayList.add(strAllowanceDetailCreateQuery);
			arrayList.add(strDeductionDetailCreateQuery);

			Graphics2D g = (Graphics2D) splash.getGraphics();
			Iterator i= arrayList.iterator();

			int frame=0;

			int dbCount=0;
			while(i.hasNext())
			{
				frame++;
				val=String.valueOf(i.next());
				System.out.println("Query-->"+frame);

				//splash.renderSplashFrame(g, frame);
				try {
					Thread.sleep(80);
				}
				catch(InterruptedException e) {
				}
				if(val.startsWith("C"))
				{	try{
					//System.out.println("Create table called-->"+val);
					stat= con.createStatement();


					int count=stat.executeUpdate(val);

					System.out.println(++dbCount+"Processing..."+count);
				}
				catch(Exception e)
				{



					System.out.println(++dbCount+".......");
                      e.printStackTrace();

		/*			stat=con.createStatement();

					stat.executeUpdate(strQuery2);
					System.out.println("Rows created");
*/
				}
				}
				else
				{
					System.out.println("Create Statement spell error");


				}

				//con.close();
			}
		}catch (Exception e){
			e.printStackTrace();

		}



	}

     public void createDB(Connection con, Splash splash)
	{
		String retrnVal=null;
		String val=null;

		String strCheckLicenseDetailCreateQuery="CREATE TABLE check_license(ID INT NOT NULL " +
				"CONSTRAINT CHK_LIC_PK PRIMARY KEY," +
				" license_or_demo VARCHAR(30000) , date_value VARCHAR(30000), p_key VARCHAR(30000) ," +
				"f_key VARCHAR(30000))";

		String strCreateQueryAdminUIdPwd="CREATE TABLE bizme_admin(ID INT NOT NULL " +
				"CONSTRAINT PK_ADM_TBL PRIMARY KEY," +
				" USER_ID VARCHAR(30000) , PASSWORD VARCHAR(30000))";

		String strOrgDetailCreateQuery="CREATE TABLE org_detail(ID INT NOT NULL CONSTRAINT ORG_S_N_PK PRIMARY KEY," +
				"OrgName VARCHAR(30000), tophead VARCHAR(30000), authorised_person VARCHAR(30000), IMG_PATH VARCHAR(30000))";

		String strBranchDetailCreateQuery="CREATE TABLE branch_tab(ID INT NOT NULL " +
				"CONSTRAINT BRNCH_PK PRIMARY KEY, " +
				" branch_name VARCHAR(30000))";
		String strUserDetailCreateQuery="CREATE TABLE user_tab(ID INT NOT NULL " +
				"CONSTRAINT USR_PK PRIMARY KEY, EMP_ID INT NOT NULL ," +
				" username VARCHAR(30000), password VARCHAR(30000), division VARCHAR(30000),adhar_no VARCHAR(30000)"
                        + ",shift VARCHAR(30000))";

        Statement stat=null;
		try{
			arrayList =new ArrayList();


			arrayList.add(strBranchDetailCreateQuery);
			arrayList.add(strUserDetailCreateQuery);
			arrayList.add(strCreateQueryAdminUIdPwd);
			arrayList.add(strCheckLicenseDetailCreateQuery);
            arrayList.add(strOrgDetailCreateQuery);

			Graphics2D g = (Graphics2D) splash.getGraphics();
			Iterator i= arrayList.iterator();

			int frame=0;

			int dbCount=0;
			while(i.hasNext())
			{
				frame++;
				val=String.valueOf(i.next());
				//System.out.println("Query-->"+val);
				splash.renderSplashFrame(g, frame);
				try {
					Thread.sleep(80);
				}
				catch(InterruptedException e) {
				}
				if(val.startsWith("C"))
				{	try{
					//System.out.println("Create table called-->"+val);
					stat= con.createStatement();


					int count=stat.executeUpdate(val);

					System.out.println(++dbCount+"Processing..."+count);
				}
				catch(Exception e)
				{


					System.out.println(++dbCount+".......");

		/*			stat=con.createStatement();

					stat.executeUpdate(strQuery2);
					System.out.println("Rows created");
*/
				}
				}
				else
				{
					System.out.println("Create Statement spell error");


				}

				//con.close();
			}
		}catch (Exception e){
			e.printStackTrace();

		}



	}


	//bizme_admin

	public  boolean addUserAdminStaffDetail(LGAObj LObj, Dbob dbob,Connection conn, String tableName, String branch, int empId, String adharNo, String shift, String firstName, String lastName, String dob, String email, String telephone, String address, String dept, int salary, String gender, String address2, String postCode, String designation, String status, String jobTitle, String apartment, String doj,int vOoZ) {//

         try {

		Statement stat = conn.createStatement();
		ResultSet resultId = stat.executeQuery("select * from staff_detail_" + branch
				+" where adhar_no = '" + adharNo + "' OR id =" + empId + "");

		if (resultId.next()) {
			//JOptionPane.showMessageDialog(null, "Record Already Exist!!");
			//return Integer.parseInt(resultId.getString(1));
		} else {


			String sql = "insert into staff_detail_" + branch
					+ "(id,first_name,last_name,dob,email,"
					+ "contact_no,address,dept,"
					+ "image,salary,gender,address2,"
					+ "post_code, designation,status,job_title,apartment,date_hired,adhar_no,shift) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

		PreparedStatement	pst = conn.prepareStatement(sql);
			pst.setInt(1,empId );
			pst.setString(2, firstName);
			pst.setString(3, lastName);
			pst.setDate(4, LObj.getLGAObj().getSqlDateValue(dbob,LObj.getLGAObj().getDateValue(dbob,"")));
			pst.setString(5, email);
			pst.setString(6, telephone);
			pst.setString(7, address);
			pst.setString(8,dept);
			pst.setBytes(9, null);

			pst.setInt(10, salary);
			pst.setString(11, gender);
			pst.setString(12, address2);
			pst.setString(13, postCode);
			pst.setString(14, designation);
			pst.setString(15, status);
			pst.setString(16, jobTitle);
			pst.setString(17, apartment);
			pst.setDate(18, LObj.getLGAObj().getSqlDateValue(dbob,LObj.getLGAObj().getDateValue(dbob,"")));
			pst.setString(19, adharNo);
			pst.setString(20, shift);
			pst.execute();
			JOptionPane.showMessageDialog(null, "Data is saved successfully");
		}
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, e);
	}
		return false;
	}
	public  boolean addUserAdminValues(Connection con, String tableName, String user_id_col, String password_col, String userId, String pswdval, int uId, int vOoZ,int empId,String division, String adharNo) {
		int uniqId = 0;

		try {

			/*for (int idxVar = 0; idxVar < pos.length; idxVar++) {
				posValue = idxVar;
				pos[idxVar] = ++posValue;

				System.out.println("From DB addVahicalValues putting values" + pos[idxVar]);

			}*/
			//getTabColNames(tableName, rsmd, columnCount);


			if (vOoZ == 0) {

				//tableName = rsmd.getTableName(columnCount);

				//int[] pos = new int[columnCount];

				int posValue = 0;

				//System.out.println("From DB addVahicalValues column Count is " + (columnCount));


				if (tableName.equalsIgnoreCase("user_tab")) {


					//JOptionPane.showMessageDialog(null, "columnCount " + columnCount);


					//try {

					Statement stat = con.createStatement();
					ResultSet resultId = stat.executeQuery("select * from "+tableName+" where "+user_id_col+" ='" + userId + "' AND "+password_col+" ='" + pswdval + "'");

					if (resultId.next()) {

						//return Integer.parseInt(resultId.getString(1));

					} else {

						ResultSet result = stat.executeQuery("select * from " + tableName);

						ResultSetMetaData rsmd = result.getMetaData();

						int columnCount = rsmd.getColumnCount();

/*
							ID INT NOT NULL " +
							"CONSTRAINT PK_ADM_TBL PRIMARY KEY," +
									" user_id VARCHAR(30000) , password VARCHAR(30000)
*/

						PreparedStatement pstat = con.prepareStatement("insert into " + tableName + " values(?,?,?,?,?,?,?)");


						for (int i = 1; i <= columnCount; i++) {


							System.out.println("party_detail i value " + i);

							if (rsmd.getColumnName(i).equals("ID")) {
								uniqId = genUniAdminId(con, tableName);
								//uniqId = 1;
								pstat.setInt(i, uniqId);
								System.out.println("From addVahicalValues  ID setting values " + uniqId + "  -->Col No" + i);


							}

							if (rsmd.getColumnName(i).equals("EMP_ID")) {
								pstat.setInt(i, empId);
								System.out.println("From addVahicalValues  ID setting values " + uniqId + "  -->Col No" + i);


							}

							if (rsmd.getColumnName(i).equals("USERNAME")) {

								pstat.setString(i, userId);
								//System.out.println("From addVahicalValues VehicalName setting values " + name + "  -->Col No" + i);


							}

							if (rsmd.getColumnName(i).equals("PASSWORD")) {
								pstat.setString(i, pswdval);
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
								pstat.setString(i, "");
								//System.out.println("From addVahicalValues  VehicalFuelType setting values " + phoneNo + "  -->Col No" + i);

							}

						}


						int insertVal = pstat.executeUpdate();
						//boolean insertVal=pstat.execute();

						System.out.println("From DB addVahicalValues row inserted");
						if (insertVal > 0) {
							System.out.println("Value from exUpdate--->" + insertVal);



							JOptionPane.showMessageDialog(null, "Done!!");

							return true;
						}

					}
/*
					} catch (Exception e) {



					}
*/


				}
			}
			else
			{


				PreparedStatement pstat = con.prepareStatement("update " + tableName + " set "+user_id_col+" = ? ,"+password_col+"= ? ,DIVISION = ? where ID = ?");


				pstat.setString(1, userId);
				pstat.setString(2, pswdval);
				pstat.setString(3, division);

				pstat.setInt(4, uId);

				int insertVal = pstat.executeUpdate();
				if (insertVal > 0) {
					System.out.println("Value from exUpdate--->" + insertVal);
					//JOptionPane.showMessageDialog(null, "Updated!!");

					return true;
				}



			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return false;
	}


	public boolean addBranch(Connection con, String startBranch, String tabName, String colName, int id, int vOoZ) {
		int uniqId = 0;

		try {

			/*for (int idxVar = 0; idxVar < pos.length; idxVar++) {
				posValue = idxVar;
				pos[idxVar] = ++posValue;

				System.out.println("From DB addVahicalValues putting values" + pos[idxVar]);

			}*/
			//getTabColNames(tableName, rsmd, columnCount);


			if (vOoZ == 0) {

				//tableName = rsmd.getTableName(columnCount);

				//int[] pos = new int[columnCount];

				int posValue = 0;

				//System.out.println("From DB addVahicalValues column Count is " + (columnCount));




					//JOptionPane.showMessageDialog(null, "columnCount " + columnCount);


					//try {

					Statement stat = con.createStatement();
					ResultSet resultId = stat.executeQuery("select * from "+tabName+" where "+colName+" ='" + startBranch + "'");

					if (resultId.next()) {

						//return Integer.parseInt(resultId.getString(1));
						return false;

					} else {

						ResultSet result = stat.executeQuery("select * from " + tabName);

						ResultSetMetaData rsmd = result.getMetaData();

						int columnCount = rsmd.getColumnCount();

/*
							ID INT NOT NULL " +
							"CONSTRAINT PK_ADM_TBL PRIMARY KEY," +
									" user_id VARCHAR(30000) , password VARCHAR(30000)
*/

						PreparedStatement pstat = con.prepareStatement("insert into " + tabName + " values(?,?)");


						for (int i = 1; i <= columnCount; i++) {


							System.out.println("party_detail i value " + i);

							if (rsmd.getColumnName(i).equals("ID")) {
								uniqId = genUniId(con, tabName);
								//uniqId = 1;
								pstat.setInt(i, uniqId);
								System.out.println("From addVahicalValues  ID setting values " + uniqId + "  -->Col No" + i);


							}


							if (rsmd.getColumnName(i).equalsIgnoreCase(colName)) {

								pstat.setString(i, startBranch);
								//System.out.println("From addVahicalValues VehicalName setting values " + name + "  -->Col No" + i);


							}



						}


						int insertVal = pstat.executeUpdate();
						//boolean insertVal=pstat.execute();

						System.out.println("From DB addVahicalValues row inserted");
						if (insertVal > 0) {
							System.out.println("Value from exUpdate--->" + insertVal);

							   //JOptionPane.showMessageDialog(null, "Done!!");

							return true;
						}

					}
/*
					} catch (Exception e) {



					}
*/



			}
			else
			{


				PreparedStatement pstat = con.prepareStatement("update " + tabName + " set "+colName+" = ? where ID = ?");


				pstat.setString(1, startBranch);
				pstat.setInt(2, id);

				int insertVal = pstat.executeUpdate();
				if (insertVal > 0) {
					System.out.println("Value from exUpdate--->" + insertVal);
					//JOptionPane.showMessageDialog(null, "Updated!!");

					return true;
				}



			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return false;
	}


	public boolean addAdminValues(Connection con, String tableName, String user_id_col, String password_col, String userId, String pswdval, int uId,int vOoZ) {
		int uniqId = 0;

		try {

			/*for (int idxVar = 0; idxVar < pos.length; idxVar++) {
				posValue = idxVar;
				pos[idxVar] = ++posValue;

				System.out.println("From DB addVahicalValues putting values" + pos[idxVar]);

			}*/
			//getTabColNames(tableName, rsmd, columnCount);


			if (vOoZ == 0) {

				//tableName = rsmd.getTableName(columnCount);

				//int[] pos = new int[columnCount];

				int posValue = 0;

				//System.out.println("From DB addVahicalValues column Count is " + (columnCount));


				if (tableName.equalsIgnoreCase("bizme_admin") || tableName.equalsIgnoreCase("simple_bizme_admin")) {


					//JOptionPane.showMessageDialog(null, "columnCount " + columnCount);


					//try {

						Statement stat = con.createStatement();
						ResultSet resultId = stat.executeQuery("select * from "+tableName+" where "+user_id_col+" ='" + userId + "' AND "+password_col+" ='" + pswdval + "'");

						if (resultId.next()) {

							//return Integer.parseInt(resultId.getString(1));

						} else {

							ResultSet result = stat.executeQuery("select * from " + tableName);

							ResultSetMetaData rsmd = result.getMetaData();

							int columnCount = rsmd.getColumnCount();

/*
							ID INT NOT NULL " +
							"CONSTRAINT PK_ADM_TBL PRIMARY KEY," +
									" user_id VARCHAR(30000) , password VARCHAR(30000)
*/

							PreparedStatement pstat = con.prepareStatement("insert into " + tableName + " values(?,?,?)");


							for (int i = 1; i <= columnCount; i++) {


								System.out.println("party_detail i value " + i);

								if (rsmd.getColumnName(i).equals("ID")) {
									uniqId = genUniId(con, tableName);
									//uniqId = 1;
									pstat.setInt(i, uniqId);
									System.out.println("From addVahicalValues  ID setting values " + uniqId + "  -->Col No" + i);


								}


								if (rsmd.getColumnName(i).equals(user_id_col)) {

									pstat.setString(i, userId);
									//System.out.println("From addVahicalValues VehicalName setting values " + name + "  -->Col No" + i);


								}

								if (rsmd.getColumnName(i).equals(password_col)) {
									pstat.setString(i, pswdval);
									//System.out.println("From addVahicalValues  VehicalFuelType setting values " + phoneNo + "  -->Col No" + i);


								}


							}


							int insertVal = pstat.executeUpdate();
							//boolean insertVal=pstat.execute();

							System.out.println("From DB addVahicalValues row inserted");
							if (insertVal > 0) {
								System.out.println("Value from exUpdate--->" + insertVal);

								JOptionPane.showMessageDialog(null, "Done!!");

								return true;
							}

						}
/*
					} catch (Exception e) {



					}
*/


				}
			}
			else
			{


				PreparedStatement pstat = con.prepareStatement("update " + tableName + " set "+user_id_col+" = ? ,"+password_col+"= ? where ID = ?");


				pstat.setString(1, userId);
				pstat.setString(2, pswdval);
				pstat.setInt(3, uId);

				int insertVal = pstat.executeUpdate();
				if (insertVal > 0) {
					System.out.println("Value from exUpdate--->" + insertVal);
					//JOptionPane.showMessageDialog(null, "Updated!!");

					return true;
				}



			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return false;
	}
	public boolean getAdminV(Connection conobj, String tableName, String user_id_col, String password_col, String userId, String pswdval) {
		boolean flag=false;
		try {
			//System.out.println("getting from getAdminv");
		Statement	stat = conobj.createStatement();


		ResultSet result = stat.executeQuery("select * from "+tableName+" where "+user_id_col+" ='" + userId + "' AND "+password_col+" ='" + pswdval + "'");

			//System.out.println("getting user name and password");
			if (result.next()) {

				/*values = result.getString(1) + ":" + result.getString(2);

				System.out.println("From Admin-->" + values);
*/

				flag=true;

				return flag;
			}

		} catch (Exception ex) {
			System.out.println("Error From Admin-->" + ex);
		}
		return flag;
	}

	/*        public void addCylCategoryNames(Connection conobj,String txtCylCategory)
		{	String tableName="";

				try
			                {
					stat=conobj.createStatement();
                                        result=stat.executeQuery("select * from LGAPurchase");

                                        rsmd=result.getMetaData();

					columnCount=rsmd.getColumnCount();

					tableName=rsmd.getTableName(columnCount);

					int[] pos=new int[columnCount];

			              int posValue=0;

		                    System.out.println("From DB addCylCategoryNames column Count is "+columnCount);

				       for(int idxVar=0;idxVar<pos.length;idxVar++)
					{posValue=idxVar;
                                                                        pos[idxVar]=++posValue;

					      System.out.println("From DB addCylCategoryNames putting values"+pos[idxVar]);

				 	}
                                                                            getLGAPurchaseColNames(rsmd,columnCount);



		pstat=conobj.prepareStatement("insert into "+tableName+" values(?,?,?,?,?,?,?)");


                  System.out.println("From DB addCylCategoryNames txtCylCategory is "+txtCylCategory);

							    for(int idx=0;idx<pos.length;idx++)
								{
								if(pos[idx]!=colNoID && pos[idx]!=colNoCyl_Category  && pos[idx]!=colNoPurchase_Date)
								{

								pstat.setInt(pos[idx],0);
								System.out.println("values From addCylCategoryNames setting   -->Col No"+pos[idx]);


   								}

								 if(pos[idx]==colNoID)
								 {
								  int uniIdVal = genUniId(conobj,tableName);
								pstat.setInt(pos[idx],uniIdVal);
						System.out.println("From addCylCategoryNames   setting values "+uniIdVal+"  -->Col No"+pos[idx]);


									 }




								 if(pos[idx]==colNoCyl_Category)
									 {
								pstat.setString(pos[idx],txtCylCategory);

							System.out.println("From addCylCategoryNames  txtCylCategory setting values "+txtCylCategory+"  -->Col No"+pos[idx]);

									 }
								 if(pos[idx]==colNoPurchase_Date)
									 {
									String dateVal=	getDateVal(tableName);
								pstat.setString(pos[idx],dateVal);
							System.out.println("From addCylCategoryNames  Purchase_Date setting values "+dateVal+"  -->Col No"+pos[idx]);


									 }




								   }
                                                                      int insertVal=pstat.executeUpdate();
								System.out.println("From DB addCylCategoryNames row inserted");
                     						if(insertVal>0)
                    						 {
                      						System.out.println("Value from exUpdate--->"+insertVal);

								 addCylCategoryValuesToLGASalesReport(conobj,txtCylCategory) ;
                     						}








                            }
                	 catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"From addCylCategoryNames Error My Dear : "+ex);
				}





		               }

*/
	void addVehicalCategoryValuesToAutoPurchaseTotal(Connection conobj, int totalVehicalIn, int calcTotalVehicalOut, int totalAmount, int totalVehicalOutAmount, int id, int totalVehicalOut) {

		if (totalVehicalIn != 0 && totalAmount != 0) {


			try {


				pstat = conobj.prepareStatement("update auto_purchase_total set total_vehical_in = ? ,total_amount = ? where ID = ?");


				pstat.setInt(1, totalVehicalIn);

				System.out.println("updating values From addVehicalCategoryValuesToAutoPurchaseTotal Column totalCylIn Values " + totalVehicalIn);


				pstat.setInt(2, totalAmount);
				System.out.println("setting values From addVehicalCategoryValuesToAutoPurchaseTotal Column Total_Amount Values " + totalAmount);

				pstat.setInt(3, id);
				System.out.println("setting values From addVehicalCategoryValuesToAutoPurchaseTotal Column id Values " + id);

				int insertVal = pstat.executeUpdate();
				if (insertVal > 0) {
					System.out.println("Value from exUpdate--->" + insertVal);
					System.out.println("From DB addVehicalCategoryValuesToAutoPurchaseTotal totalCylIn row inserted");


				}


			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error  From DB addVehicalCategoryValuesToAutoPurchaseTotal TotalCylIn-->" + ex);
				System.out.println("Error  From DB addVehicalCategoryValuesToAutoPurchaseTotal TotalCylIn-->" + ex);

			}

		} else if (calcTotalVehicalOut != 0 && totalVehicalOut != 0 && totalVehicalOutAmount != 0) {
			try {


				pstat = conobj.prepareStatement("update auto_purchase_total set total_vehical_in = ?, total_vehical_out = ? ,total_amount = ? where ID = ?");


				String tName = "auto_purchase_total";
				String columnName = "total_vehical_in";
				String matchColum = "ID";
				int matchVal = 1;
				String colData = getColData(conobj, columnName, matchColum, matchVal, tName);
				int total_veh_In = Integer.parseInt(colData);


				String tName1 = "auto_purchase_total";
				String columnName1 = "total_amount";
				String matchColum1 = "ID";
				int matchVal1 = 1;
				String colData1 = getColData(conobj, columnName1, matchColum1, matchVal1, tName1);

				int total_amount = Integer.parseInt(colData1);


				int calcTotalVehIn = (total_veh_In - totalVehicalOut);

				pstat.setInt(1, calcTotalVehIn);

				System.out.println("updating values From addVehicalCategoryValuesToAutoPurchaseTotal Column totalCylOut Values " + calcTotalVehIn);


				pstat.setInt(2, calcTotalVehicalOut);

				System.out.println("updating values From addVehicalCategoryValuesToAutoPurchaseTotal Column totalCylOut Values " + calcTotalVehicalOut);


				int calcTotAmt = (total_amount - totalVehicalOutAmount);


				pstat.setInt(3, calcTotAmt);
				System.out.println("setting values From addCylCategoryValuesToLGAPurchaseTotal Column calcTotAmt Values " + calcTotAmt);


				pstat.setInt(4, id);
				System.out.println("setting values From addCylCategoryValuesToLGAPurchaseTotal Column id Values " + id);

				int insertVal = pstat.executeUpdate();
				if (insertVal > 0) {
					System.out.println("Value from exUpdate--->" + insertVal);
					System.out.println("From DB addCylCategoryValuesToLGAPurchaseTotal totalCylOut row inserted");


				}


			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error  From DB addCylCategoryValuesToLGAPurchaseTotal TotalCylOut -->" + ex);
				System.out.println("Error  From DB addCylCategoryValuesToLGAPurchaseTotal TotalCylOut-->" + ex);

			}


		}


	}

		/*	void  addCylCategoryValuesToLGASalesReport(Connection conobj,String txtCylCategory)
				{


					String tableName="";

				try
			                {
					stat=conobj.createStatement();
                                        result=stat.executeQuery("select * from LGASalesReport");

                                        rsmd=result.getMetaData();

					columnCount=rsmd.getColumnCount();

					tableName=rsmd.getTableName(columnCount);

					int[] pos=new int[columnCount];

			              int posValue=0;

		                    System.out.println("From DB addCylCategoryNames column Count is "+columnCount);

				       for(int idxVar=0;idxVar<pos.length;idxVar++)
					{posValue=idxVar;
                                                                        pos[idxVar]=++posValue;

					      System.out.println("From DB addCylCategoryNames putting values"+pos[idxVar]);

				 	}
                                                                            getLGASalesReportColNames(rsmd,columnCount);



		pstat=conobj.prepareStatement("insert into "+tableName+" values(?,?,?,?,?,?,?,?,?)");


							    for(int idx=0;idx<pos.length;idx++)
								{
								if(pos[idx]!=colNoSaleReportID && pos[idx]!=colNoSaleReportCyl_Category  && pos[idx]!=colNoSaleReportT_Date)
								{

								pstat.setInt(pos[idx],0);
								System.out.println("values From addCylCategoryValuesToLGASalesReport setting 0  -->Col No"+pos[idx]);


   								}


								if(pos[idx]==colNoSaleReportID)
								 {
								  int uniIdVal = genUniId(conobj,tableName);
								pstat.setInt(pos[idx],uniIdVal);
						System.out.println("From addCylCategoryValuesToLGASalesReport  SaleReport_ID setting values "+uniIdVal+"  -->Col No"+pos[idx]);


									 }



								 if(pos[idx]==colNoSaleReportCyl_Category)
									 {
								pstat.setString(pos[idx],txtCylCategory);

							System.out.println("From addCylCategoryValuesToLGASalesReport  Cyl_Category setting values "+txtCylCategory+"  -->Col No"+pos[idx]);

									 }
								 if(pos[idx]==colNoSaleReportT_Date)
									 {
									String dateVal="";
								pstat.setString(pos[idx],dateVal);
							System.out.println("From addCylCategoryValuesToLGASalesReport  T_Date setting values "+dateVal+"  -->Col No"+pos[idx]);


									 }




								   }
                                                                      int insertVal=pstat.executeUpdate();
								System.out.println("From DB addCylCategoryValuesToLGASalesReport row inserted");
                     						if(insertVal>0)
                    						 {
                      						System.out.println("Value from exUpdate--->"+insertVal);


                     						}








                            }
                	 catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"From addCylCategoryValuesToLGASalesReport Error My Dear : "+ex);
				}


			}

*/

	public String getCylCategoryRecords(Connection conobj, String cylCatVal, String tabName, String colName) {
		System.out.println("inside getCylCategoryRecords");

		String values = "";

		try {

			if (!(colName.equals("")) && !(cylCatVal.equals(""))) {


				System.out.println("getCylCategoryRecords tabName " + tabName + " colName : " + colName + " CatVal : " + cylCatVal);


				stat = conobj.createStatement();


				String qry = "select * from " + tabName + " where " + colName + " = '" + cylCatVal + "'";

				System.out.println("getCylCategoryRecords query===>" + qry);


				result = stat.executeQuery(qry);


				System.out.println("!!!getCylCategoryRecords executing query===>" + qry + " and getting result " + (result != null));

				rsmd = result.getMetaData();

				System.out.println("!!!getCylCategoryRecords getting RSMD===>" + (rsmd != null));

				columnCount = rsmd.getColumnCount();

				System.out.println("!!!getCylCategoryRecords getting Colcount===>" + columnCount);

//System.out.println("!!!getCylCategoryRecords checking if result.next() is true or false it is ===>"+(result.next()));


				while (result.next()) {


					System.out.println("Inside while Fetching Records");

					for (int i = 1; i <= columnCount; i++) {


						values += "--" + result.getString(i);

						System.out.println("Fetching Records : " + values);


					}


				}

			} else {


				stat = conobj.createStatement();


				result = stat.executeQuery("select * from " + tabName);

				rsmd = result.getMetaData();


				int columnCount = rsmd.getColumnCount();


				while (result.next()) {


					//System.out.println("Fetching Records : "+result.getString());

					for (int i = 1; i <= columnCount; i++) {


						values += "--" + result.getString(i);

						System.out.println("Fetching Records : " + values);


					}


				}


			}


		} catch (Exception ex) {
			System.out.println("Error from  getCylCategoryRecords : " + ex);
		}


		return values;


	}


	public String getDetail(Connection conobj, String colVal, String tabName, String colName, String ordByCol, String gstFlagsVal, String strKey, String finalGender, String finalIsChildVal) {
		System.out.println("inside getCylCategoryRecords");

		String values = "";


		try {

			//if (!(colName.equals("")) && !(colVal.equals(""))) {


				System.out.println("getCylCategoryRecords tabName " + tabName + " colName : " + colName + " CatVal : " + colVal);


			Statement	stat = conobj.createStatement();
				String qry = "";
				 if (strKey.equals("combotestgroup")){

					 if(finalGender.length()>0)
					 {

						 if(finalIsChildVal.length()>0) {
							 if(finalGender.equalsIgnoreCase("Male")) {
								 if (colName.equals("test_group_id")) {
									 //AND search_key,TEST_TYPE Like '%cgst all%' order by



									 qry = "select id, test_name , default_value , units , options , norm_val_male_child , status , test_note , test_group_id ,test_group , search_key,TEST_TYPE from " + tabName + " where " + colName + " = " + colVal + " AND status ='Active' order by id";// + ordByCol;

								 } else {
									 //qry = "select ID, DESCRIPTION_OF_GOODS , HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  CGST_RATE ,CGST_AMOUNT , SGST_RATE , SGST_AMOUNT ,AMOUNT  ,search_key,TEST_TYPE  from " + tabName + " where " + colName + " Like '%" + cylCatVal + "%' AND search_key,TEST_TYPE Like '%cgst all%' order by " + ordByCol;
									 qry = "select id, test_name , default_value , units , options , norm_val_male_child , status , test_note , test_group_id , test_group ,search_key,TEST_TYPE from " + tabName + " where " + colName + " = '" + colVal + "' AND status ='Active' order by id";// + ordByCol;

								 }
							 }
							 else {
								 if (colName.equals("test_group_id")) {
									 //AND search_key,TEST_TYPE Like '%cgst all%' order by
									 qry = "select id, test_name , default_value , units , options ,norm_val_female_child , status , test_note , test_group_id , test_group ,search_key,TEST_TYPE from " + tabName + " where " + colName + " = " + colVal + " AND status ='Active' order by id";// + ordByCol;

								 } else {
									 //qry = "select ID, DESCRIPTION_OF_GOODS , HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  CGST_RATE ,CGST_AMOUNT , SGST_RATE , SGST_AMOUNT ,AMOUNT  ,search_key,TEST_TYPE  from " + tabName + " where " + colName + " Like '%" + cylCatVal + "%' AND search_key,TEST_TYPE Like '%cgst all%' order by " + ordByCol;
									 qry = "select id, test_name , default_value , units , options ,norm_val_female_child , status , test_note , test_group_id , test_group ,search_key,TEST_TYPE from " + tabName + " where " + colName + " = '" + colVal + "' AND status ='Active' order by id";// + ordByCol;

								 }
							 }
						 }
						 else {

							 if(finalGender.equalsIgnoreCase("Male")) {

								 if (colName.equals("test_group_id")) {
									 //AND search_key,TEST_TYPE Like '%cgst all%' order by
									 qry = "select id, test_name , default_value , units , options ,norm_val_male , status , test_note , test_group_id , test_group ,search_key,TEST_TYPE from " + tabName + " where " + colName + " = " + colVal + " AND status ='Active' order by id";// + ordByCol;

								 } else {
									 //qry = "select ID, DESCRIPTION_OF_GOODS , HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  CGST_RATE ,CGST_AMOUNT , SGST_RATE , SGST_AMOUNT ,AMOUNT  ,search_key,TEST_TYPE  from " + tabName + " where " + colName + " Like '%" + cylCatVal + "%' AND search_key,TEST_TYPE Like '%cgst all%' order by " + ordByCol;
									 qry = "select id, test_name , default_value , units , options ,norm_val_male , status , test_note , test_group_id , test_group ,search_key,TEST_TYPE from " + tabName + " where " + colName + " = '" + colVal + "' AND status ='Active' order by id";// + ordByCol;

								 }

							 }
							 else
							 {

								 if (colName.equals("test_group_id")) {
									 //AND search_key,TEST_TYPE Like '%cgst all%' order by
									 qry = "select id, test_name , default_value , units , options ,norm_val_female , status , test_note , test_group_id , test_group ,search_key,TEST_TYPE from " + tabName + " where " + colName + " = " + colVal + " AND status ='Active' order by id";// + ordByCol;

								 } else {
									 //qry = "select ID, DESCRIPTION_OF_GOODS , HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  CGST_RATE ,CGST_AMOUNT , SGST_RATE , SGST_AMOUNT ,AMOUNT  ,search_key,TEST_TYPE  from " + tabName + " where " + colName + " Like '%" + cylCatVal + "%' AND search_key,TEST_TYPE Like '%cgst all%' order by " + ordByCol;
									 qry = "select id, test_name , default_value , units , options ,norm_val_female , status , test_note , test_group_id , test_group ,search_key,TEST_TYPE from " + tabName + " where " + colName + " = '" + colVal + "' AND status ='Active' order by id";// + ordByCol;

								 }

							 }

						 }
					 }
					 else {
						 if (colName.equals("test_group_id")) {
							 //AND search_key,TEST_TYPE Like '%cgst all%' order by
							 qry = "select id, test_name , default_value , units , options ,norm_val_male " +
									 ", norm_val_female , norm_val_male_child ,norm_val_female_child , status , test_note , test_group_id , test_group ,search_key,TEST_TYPE from " + tabName + " where " + colName + " = " + colVal + " order by " + ordByCol;

						 } else {
							 //qry = "select ID, DESCRIPTION_OF_GOODS , HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  CGST_RATE ,CGST_AMOUNT , SGST_RATE , SGST_AMOUNT ,AMOUNT  ,search_key,TEST_TYPE  from " + tabName + " where " + colName + " Like '%" + cylCatVal + "%' AND search_key,TEST_TYPE Like '%cgst all%' order by " + ordByCol;
							 qry = "select id, test_name , default_value , units , options ,norm_val_male " +
									 ", norm_val_female , norm_val_male_child ,norm_val_female_child , status , test_note , test_group_id , test_group ,search_key,TEST_TYPE from " + tabName + " where " + colName + " = '" + colVal + "' order by " + ordByCol;

						 }
					 }
				 }//combodoctor combopatient combosamplecollectionbranch
				 else if (strKey.equals("comboPatientTestReport")){
					 if (colName.equals("patient_id")) {
						 //AND search_key,TEST_TYPE Like '%cgst all%' order by
						 qry = "select ID, LAB_ID ,TEST_GROUP,TEST ,RESULT , CONDITION ,UNITS ,NORM_VALUE ,COLLECT_DATE , COLLECT_TIME ,REPORT_DATE ,REPORT_TIME" +
								 ",TEST_GROUP_ID, PATIENT_ID,PATIENT_NAME ,GENDER ,AGE , PHONE_NO ,ADDRESS ,REMARK ,CHILD_ADULT ,REF_DOCTOR , METHOD , TEST_REMARKS , search_key,TEST_TYPE,RESFLAG from " + tabName + " where " + colName + " = " + colVal + " AND RESFLAG = 0 order by test_group_id" ;//+ ordByCol;

					 } else {
						 qry = "select ID, LAB_ID ,TEST_GROUP,TEST ,RESULT ,CONDITION ,UNITS ,NORM_VALUE ,COLLECT_DATE , COLLECT_TIME ,REPORT_DATE ,REPORT_TIME " +
								 ",TEST_GROUP_ID, PATIENT_ID,PATIENT_NAME ,GENDER ,AGE,PHONE_NO ,ADDRESS ,REMARK ,CHILD_ADULT ,REF_DOCTOR , METHOD , TEST_REMARKS, search_key,TEST_TYPE,RESFLAG from " + tabName + " where " + colName + " = '" + colVal + "' AND RESFLAG = 0 order by test_group_id";// + ordByCol;

					 }


				 }
				 else if (strKey.equals("comboLabIdTestReport")){
					 if (colName.equals("lab_id")) {
						 qry = "select ID, LAB_ID ,TEST_GROUP,TEST ,RESULT ,CONDITION ,UNITS ,NORM_VALUE ,COLLECT_DATE , COLLECT_TIME ,REPORT_DATE ,REPORT_TIME" +
								 ",TEST_GROUP_ID, PATIENT_ID,PATIENT_NAME ,GENDER ,AGE,PHONE_NO ,ADDRESS ,REMARK ,CHILD_ADULT ,REF_DOCTOR , METHOD , TEST_REMARKS, search_key,TEST_TYPE,RESFLAG from " + tabName + " where " + colName + " = " + colVal + " AND RESFLAG = 0 order by test_group_id";// + ordByCol;

					 } else {
						 qry = "select ID, LAB_ID ,TEST_GROUP,TEST ,RESULT ,CONDITION ,UNITS ,NORM_VALUE ,COLLECT_DATE , COLLECT_TIME ,REPORT_DATE ,REPORT_TIME " +
								 ",TEST_GROUP_ID, PATIENT_ID,PATIENT_NAME ,GENDER ,AGE,PHONE_NO ,ADDRESS ,REMARK ,CHILD_ADULT ,REF_DOCTOR ,METHOD , TEST_REMARKS, search_key,TEST_TYPE,RESFLAG from " + tabName + " where " + colName + " = '" + colVal + "' AND RESFLAG = 0 order by test_group_id";// + ordByCol;

					 }
				 }
				 else if (strKey.equals("comboPatientPosNegTestReport")){
					 if (colName.equals("patient_id")) {

						 qry = "select ID, LAB_ID ,TEST_GROUP,TEST,DEFAULT_VALUE,OPTIONS ,TEST_TYPE,COLLECT_DATE , COLLECT_TIME ,REPORT_DATE ,REPORT_TIME" +
								 ",TEST_GROUP_ID, PATIENT_ID,PATIENT_NAME ,METHOD , TEST_REMARKS, RESFLAG,SEARCH_KEY from " + tabName + " where " + colName + " = " + colVal + " AND RESFLAG = 0 order by test_group_id";



					 } else {
						 qry = "select ID, LAB_ID ,TEST_GROUP,TEST,DEFAULT_VALUE,OPTIONS ,TEST_TYPE,COLLECT_DATE , COLLECT_TIME ,REPORT_DATE ,REPORT_TIME" +
								 ",TEST_GROUP_ID, PATIENT_ID,PATIENT_NAME ,METHOD , TEST_REMARKS, RESFLAG,SEARCH_KEY from " + tabName + " where " + colName + " = '" + colVal + "' AND RESFLAG = 0 order by test_group_id";

					 }
				 }
				 else if (strKey.equals("comboLabIdPosNegTestReport")){
					 if (colName.equals("lab_id")) {

						 qry = "select ID, LAB_ID ,TEST_GROUP,TEST,DEFAULT_VALUE,OPTIONS ,TEST_TYPE,COLLECT_DATE , COLLECT_TIME ,REPORT_DATE ,REPORT_TIME" +
								 ",TEST_GROUP_ID, PATIENT_ID,PATIENT_NAME ,METHOD , TEST_REMARKS, RESFLAG,SEARCH_KEY from " + tabName + " where " + colName + " = " + colVal + " AND RESFLAG = 0 order by test_group_id";



					 } else {
						 qry = "select ID, LAB_ID ,TEST_GROUP,TEST,DEFAULT_VALUE,OPTIONS ,TEST_TYPE,COLLECT_DATE , COLLECT_TIME ,REPORT_DATE ,REPORT_TIME" +
								 ",TEST_GROUP_ID, PATIENT_ID,PATIENT_NAME ,METHOD , TEST_REMARKS, RESFLAG,SEARCH_KEY from " + tabName + " where " + colName + " = '" + colVal + "' AND RESFLAG = 0 order by test_group_id";

					 }
				 }
				 else if (strKey.equals("comboLabIdTestReportUpdated") || strKey.equals("comboPatientTestReportUpdated")){
					 if (colName.equals("patient_id") || colName.equals("lab_id")) {
						 qry = "select ID, LAB_ID ,TEST_GROUP,TEST ,RESULT ,CONDITION ,UNITS ,NORM_VALUE ,COLLECT_DATE , COLLECT_TIME ,REPORT_DATE ,REPORT_TIME" +
								 ",TEST_GROUP_ID, PATIENT_ID,PATIENT_NAME ,GENDER ,AGE,PHONE_NO ,ADDRESS ,REMARK ,CHILD_ADULT ,REF_DOCTOR , METHOD , TEST_REMARKS, search_key,TEST_TYPE,RESFLAG from " + tabName + " where " + colName + " = " + colVal + " AND RESFLAG != 0 order by test_group_id";// + ordByCol;

					 } else {
						 qry = "select ID, LAB_ID ,TEST_GROUP,TEST ,RESULT ,CONDITION ,UNITS ,NORM_VALUE ,COLLECT_DATE , COLLECT_TIME ,REPORT_DATE ,REPORT_TIME " +
								 ",TEST_GROUP_ID, PATIENT_ID,PATIENT_NAME ,GENDER ,AGE,PHONE_NO ,ADDRESS ,REMARK ,CHILD_ADULT ,REF_DOCTOR ,METHOD , TEST_REMARKS, search_key,TEST_TYPE,RESFLAG from " + tabName + " where " + colName + " = '" + colVal + "' AND RESFLAG != 0 order by test_group_id";// + ordByCol;

					 }
				 }


				 else if (strKey.equals("comboPatientTestReceipt")){
					 String colnames = "LAB_ID , PATIENT_ID , PATIENT_NAME ,DOCTOR_NAME ,TYPE ,AGE, GENDER ,CHILD_ADULT,TEST_GROUP ,MOBILE_NO ,ADDRESS,EMAIL_ID,FEES,TOTAL_FEES ,DISCOUNT ,PAYABLE ,PAID ,BALANCE ,COLLECT_DATE ,COLLECT_TIME " +
							 ",REPORT_DATE ,REPORT_TIME ,SEARCH_KEY,TEST_GROUP_ID";

					 if (colName.equals("patient_id")) {
						//AND SEARCH_KEY Like '%cgst all%' order by



						qry = "select "+colnames+" from " + tabName + " where " + colName + " = " + colVal + " order by " + ordByCol;

					} else {
						//qry = "select ID, DESCRIPTION_OF_GOODS , HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  CGST_RATE ,CGST_AMOUNT , SGST_RATE , SGST_AMOUNT ,AMOUNT  ,SEARCH_KEY  from " + tabName + " where " + colName + " Like '%" + cylCatVal + "%' AND SEARCH_KEY Like '%cgst all%' order by " + ordByCol;
						qry = "select "+colnames+" from " + tabName + " where " + colName + " = '" + colVal + "' order by " + ordByCol;

					}
				}
				 else if (strKey.equals("comboLabIdTestReceipt")){

					 String colnames = "LAB_ID , PATIENT_ID , PATIENT_NAME ,DOCTOR_NAME ,TYPE ,AGE, GENDER ,CHILD_ADULT,TEST_GROUP ,MOBILE_NO ,ADDRESS,EMAIL_ID,FEES,TOTAL_FEES ,DISCOUNT ,PAYABLE ,PAID ,BALANCE ,COLLECT_DATE ,COLLECT_TIME " +
							 ",REPORT_DATE ,REPORT_TIME ,SEARCH_KEY,TEST_GROUP_ID";

					 if (colName.equals("lab_id")) {
						 //AND SEARCH_KEY Like '%cgst all%' order by
						 qry = "select "+colnames+" from " + tabName + " where " + colName + " = " + colVal + " order by " + ordByCol;

					 } else {
						 //qry = "select ID, DESCRIPTION_OF_GOODS , HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  CGST_RATE ,CGST_AMOUNT , SGST_RATE , SGST_AMOUNT ,AMOUNT  ,SEARCH_KEY  from " + tabName + " where " + colName + " Like '%" + cylCatVal + "%' AND SEARCH_KEY Like '%cgst all%' order by " + ordByCol;
						 qry = "select "+colnames+" from " + tabName + " where " + colName + " = '" + colVal + "' order by " + ordByCol;

					 }
				 }
				 else if (strKey.equals("radioButtonYearWise") || strKey.equals("radioButtonTotal") || strKey.equals("radioButtonDateWise")){

					 //JOptionPane.showMessageDialog(null,strKey);

					 if (colVal.contains(",")) {
						 //AND SEARCH_KEY Like '%cgst all%' order by
						String frmNToDate[] = colVal.split(",");

                        String fromDate = frmNToDate[0];
                         String toDate = frmNToDate[1];
						 if (strKey.equals("radioButtonYearWise")) {

							 String[] frmDateArr= fromDate.split("/");
							 int frmDateVal= Integer.parseInt(frmDateArr[2]);

							 qry = "select LAB_ID , PATIENT_ID , PATIENT_NAME ,DOCTOR_NAME ,TYPE ,AGE,GENDER ,CHILD_ADULT ,TEST_GROUP ,MOBILE_NO ,FEES ,TOTAL_FEES ,DISCOUNT ,PAYABLE ,PAID ,BALANCE ,COLLECT_DATE ,COLLECT_TIME " +
									 ",REPORT_DATE ,REPORT_TIME ,SEARCH_KEY,TEST_GROUP_ID from " + tabName + " WHERE YEAR(COLLECT_DATE) " +
									 "= " + frmDateVal + "" + " order by " + ordByCol;
						 }else {

							 String frmDat = getDate(fromDate).toString();
							 String toDat = getDate(toDate).toString();

							 qry = "select LAB_ID , PATIENT_ID , PATIENT_NAME ,DOCTOR_NAME ,TYPE ,AGE,GENDER ,CHILD_ADULT ,TEST_GROUP ,MOBILE_NO ,FEES ,TOTAL_FEES ,DISCOUNT ,PAYABLE ,PAID ,BALANCE ,COLLECT_DATE ,COLLECT_TIME " +
									 ",REPORT_DATE ,REPORT_TIME ,SEARCH_KEY,TEST_GROUP_ID from " + tabName + " WHERE COLLECT_DATE BETWEEN '" + frmDat + "' AND '" + toDat + "' " + " order by " + ordByCol;

						 }

						 //JOptionPane.showMessageDialog(null,strKey+" "+qry);

					 } else {
						 //qry = "select ID, DESCRIPTION_OF_GOODS , HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  CGST_RATE ,CGST_AMOUNT , SGST_RATE , SGST_AMOUNT ,AMOUNT  ,SEARCH_KEY  from " + tabName + " where " + colName + " Like '%" + cylCatVal + "%' AND SEARCH_KEY Like '%cgst all%' order by " + ordByCol;
						 qry = "select LAB_ID , PATIENT_ID , PATIENT_NAME ,DOCTOR_NAME ,TYPE ,AGE,GENDER ,CHILD_ADULT ,TEST_GROUP ,MOBILE_NO ,FEES ,TOTAL_FEES ,DISCOUNT ,PAYABLE ,PAID ,BALANCE ,COLLECT_DATE ,COLLECT_TIME " +
								 ",REPORT_DATE ,REPORT_TIME ,SEARCH_KEY,TEST_GROUP_ID from " + tabName ;// + "' order by " + ordByCol;

						 //JOptionPane.showMessageDialog(null,strKey+" "+qry);

					 }
				 }
				 else if (strKey.equals("comboIncomeTestGroupTotal") || strKey.equals("comboIncomeTestGroupYearWise")
                        || strKey.equals("comboIncomeTestGroupDateWise")){
                     if (colVal.contains(",")) {
                         //AND SEARCH_KEY Like '%cgst all%' order by
                         String frmNToDate[] = colVal.split(",");

                         String value = frmNToDate[0];
                         String fromDate = frmNToDate[1];
                         String toDate = frmNToDate[2];
                         if (strKey.equals("comboIncomeTestGroupYearWise")) {

                             String[] frmDateArr= fromDate.split("/");
                             int frmDateVal= Integer.parseInt(frmDateArr[2]);

                             qry = "select LAB_ID , PATIENT_ID , PATIENT_NAME ,DOCTOR_NAME ,TYPE ,AGE,GENDER ,CHILD_ADULT ,TEST_GROUP ,MOBILE_NO ,FEES ,TOTAL_FEES ,DISCOUNT ,PAYABLE ,PAID ,BALANCE ,COLLECT_DATE ,COLLECT_TIME " +
                                     ",REPORT_DATE ,REPORT_TIME ,SEARCH_KEY,TEST_GROUP_ID from " + tabName + " WHERE "+ colName+" = '"+value+ "' AND YEAR(COLLECT_DATE) " +
                                     "= " + frmDateVal + "" + " order by " + ordByCol;
                         }else {

                             String frmDat = getDate(fromDate).toString();
                             String toDat = getDate(toDate).toString();

                             qry = "select LAB_ID , PATIENT_ID , PATIENT_NAME ,DOCTOR_NAME ,TYPE ,AGE,GENDER ,CHILD_ADULT ,TEST_GROUP ,MOBILE_NO ,FEES ,TOTAL_FEES ,DISCOUNT ,PAYABLE ,PAID ,BALANCE ,COLLECT_DATE ,COLLECT_TIME " +
                                     ",REPORT_DATE ,REPORT_TIME ,SEARCH_KEY,TEST_GROUP_ID from " + tabName + " WHERE "+ colName+" = '"+value+ "' AND COLLECT_DATE BETWEEN '" + frmDat + "' AND '" + toDat + "' " + " order by " + ordByCol;

                         }

                     } else {
                         //qry = "select ID, DESCRIPTION_OF_GOODS , HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  CGST_RATE ,CGST_AMOUNT , SGST_RATE , SGST_AMOUNT ,AMOUNT  ,SEARCH_KEY  from " + tabName + " where " + colName + " Like '%" + cylCatVal + "%' AND SEARCH_KEY Like '%cgst all%' order by " + ordByCol;
                         qry = "select LAB_ID , PATIENT_ID , PATIENT_NAME ,DOCTOR_NAME ,TYPE ,AGE,GENDER ,CHILD_ADULT ,TEST_GROUP ,MOBILE_NO ,FEES ,TOTAL_FEES ,DISCOUNT ,PAYABLE ,PAID ,BALANCE ,COLLECT_DATE ,COLLECT_TIME " +
                                 ",REPORT_DATE ,REPORT_TIME ,SEARCH_KEY,TEST_GROUP_ID from " + tabName + " WHERE "+ colName+" = '"+colVal+ "'";// + "' order by " + ordByCol;

                     }
                 }
                 else if (strKey.length()>0)
				{

					//JOptionPane.showMessageDialog(null,"Finally "+qry);
					if (colName.equals("ID")) {
						qry = "select * from " + tabName + " where " + colName + " = " + colVal + "";
					}
					else
					{
						qry = "select * from " + tabName + " where " + colName + " = '" + colVal + "'";
					}


				}
				System.out.println("getCylCategoryRecords query===>" + qry);




				ResultSet result = stat.executeQuery(qry);


				System.out.println("!!!getCylCategoryRecords executing query===>" + qry + " and getting result " + (result != null));

				ResultSetMetaData rsmd = result.getMetaData();

				System.out.println("!!!getCylCategoryRecords getting RSMD===>" + (rsmd != null));

				int columnCount = rsmd.getColumnCount();


				values= getGstTypeValues(result,columnCount);



               return values+"--"+columnCount;

//			}
/*
			else {


			Statement	stat = conobj.createStatement();


			ResultSet	result = stat.executeQuery("select * from " + tabName);

				ResultSetMetaData rsmd = result.getMetaData();


				int columnCount = rsmd.getColumnCount();


				while (result.next()) {


					//System.out.println("Fetching Records : "+result.getString());

					for (int i = 1; i <= columnCount; i++) {


						values += "--" + result.getString(i);

						System.out.println("Fetching Records : " + values);


					}


				}


			}
*/


		} catch (Exception ex) {
			System.out.println("Error from  getCylCategoryRecords : " + ex);
		}


		return values;


	}

	private String getGstTypeValues(ResultSet result,  int columnCount) throws SQLException {
		String values="";
		int rowCount=0;

		System.out.println("!!!getCylCategoryRecords getting Colcount===>" + columnCount);

		while (result.next()) {


			System.out.println("Inside while Fetching Records");

			for (int i = 1; i <= columnCount; i++) {

					values+= "--" + result.getString(i);

				System.out.println("Fetching Records : " + values);


			}

			rowCount++;
		}

		return values+";"+rowCount;
	}


	public String getRowColCount(Connection conobj, String cylCatVal, String tabName, String colName) {
		int rowCount = 0, columnCount = 0;


		String values = "";
		try {

			if (!(colName.equals("")) && !(cylCatVal.equals(""))) {

			  Statement	stat = conobj.createStatement();

				System.out.println("getRowColCount tabName " + tabName + " colName : " + colName + " CatVal : " + cylCatVal);

				String qry = "";
				if (colName.equals("ID")) {


					qry = "select * from " + tabName + " where " + colName + " = " + cylCatVal + "";
				}
				else
				{
					qry = "select * from " + tabName + " where " + colName + " = '" + cylCatVal + "'";

				}
				System.out.println("getRowColCount query===>" + qry);
			   ResultSet	result = stat.executeQuery(qry);
				System.out.println("!!!getRowColCount executing query===>" + qry + " and getting result " + (result != null));

			ResultSetMetaData	rsmd = result.getMetaData();

				System.out.println("!!!getRowColCount getting RSMD===>" + (rsmd != null));

				columnCount = rsmd.getColumnCount();

				System.out.println("!!!getRowColCount getting Colcount===>" + columnCount);


//System.out.println("!!!getRowColCount checking if result.next() is true or false it is ===>"+(result.next()));


				while (result.next()) {
					System.out.println("inside while getRowColCount");
					++rowCount;


				}

				if (rowCount > 0 && columnCount > 0) {
					return rowCount + ":" + columnCount;


				} else {

					System.out.println(" from RowColCount : Rows & Columns not found ");


				}


			} else {


				stat = conobj.createStatement();


				result = stat.executeQuery("select * from " + tabName);

				rsmd = result.getMetaData();


				columnCount = rsmd.getColumnCount();


				while (result.next()) {
					System.out.println("From getRowColCount");
					++rowCount;


				}

				if (rowCount > 0 && columnCount > 0) {
					return rowCount + ":" + columnCount;


				} else {

					System.out.println(" from RowColCount : Rows & Columns not found ");


				}


			}

		} catch (Exception ex) {
			System.out.println("Error from  getRowColCount : " + ex);
		}


		return rowCount + ":" + columnCount;
	}
	public String getColumnNames(Connection conobj, String tabName) {

		String value = "";
		try {
			stat = conobj.createStatement();


			result = stat.executeQuery("select * from " + tabName);

			rsmd = result.getMetaData();

			int colCount = rsmd.getColumnCount();


			for (int i = 1; i <= colCount; i++) {


				value += rsmd.getColumnName(i) + ":";
				System.out.println("From  getCylPurchaseCatColNames : getting column names : " + value);

			}


		} catch (Exception ex) {
			System.out.println("Error from  getCylPurchaseCatColNames : " + ex);
		}

		return value;


	}


	public String getGoodsColumnNames(Connection conobj, String tabName, String strKey,String finalGender, String finalIsChildVal) {

		String value = "";
		try {
			Statement	stat = conobj.createStatement();

			String qry = "";

			if (strKey.equals("combotestgroup")){

				if(finalGender.length()>0)
				{

					if(finalIsChildVal.length()>0) {
						if(finalGender.equalsIgnoreCase("Male")) {
							//qry = "select ID, DESCRIPTION_OF_GOODS , HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  CGST_RATE ,CGST_AMOUNT , SGST_RATE , SGST_AMOUNT ,AMOUNT  ,search_key,TEST_TYPE  from " + tabName + " where " + colName + " Like '%" + cylCatVal + "%' AND search_key,TEST_TYPE Like '%cgst all%' order by " + ordByCol;
							qry = "select id, test_name , default_value , units , options , norm_val_male_child , status , test_note , test_group_id , test_group ,search_key,TEST_TYPE from " + tabName ;
						}
						else {
							qry = "select id, test_name , default_value , units , options ,norm_val_female_child , status , test_note , test_group_id , test_group ,search_key,TEST_TYPE from " + tabName ;


						}
					}
					else {

						if(finalGender.equalsIgnoreCase("Male")) {

							//qry = "select ID, DESCRIPTION_OF_GOODS , HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  CGST_RATE ,CGST_AMOUNT , SGST_RATE , SGST_AMOUNT ,AMOUNT  ,search_key,TEST_TYPE  from " + tabName + " where " + colName + " Like '%" + cylCatVal + "%' AND search_key,TEST_TYPE Like '%cgst all%' order by " + ordByCol;
							qry = "select id, test_name , default_value , units , options ,norm_val_male , status , test_note , test_group_id , test_group ,search_key,TEST_TYPE from " + tabName ;



						}
						else
						{

							//qry = "select ID, DESCRIPTION_OF_GOODS , HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  CGST_RATE ,CGST_AMOUNT , SGST_RATE , SGST_AMOUNT ,AMOUNT  ,search_key,TEST_TYPE  from " + tabName + " where " + colName + " Like '%" + cylCatVal + "%' AND search_key,TEST_TYPE Like '%cgst all%' order by " + ordByCol;
							qry = "select id, test_name , default_value , units , options ,norm_val_female , status , test_note , test_group_id , test_group ,search_key,TEST_TYPE from " + tabName ;


						}

					}
				}
				else {
					//qry = "select ID, DESCRIPTION_OF_GOODS , HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  CGST_RATE ,CGST_AMOUNT , SGST_RATE , SGST_AMOUNT ,AMOUNT  ,search_key,TEST_TYPE  from " + tabName + " where " + colName + " Like '%" + cylCatVal + "%' AND search_key,TEST_TYPE Like '%cgst all%' order by " + ordByCol;
					qry = "select id, test_name , default_value , units , options ,norm_val_male " +
							", norm_val_female , norm_val_male_child ,norm_val_female_child , status , test_note , test_group_id , test_group ,search_key,TEST_TYPE from " + tabName ;

				}
			}
			else if (strKey.equals("comboPatientTestReport") || strKey.equals("comboPatientTestReportUpdated")
					|| strKey.equals("searchReport") || strKey.equals("searchReportUpdated")
					|| strKey.equals("comboLabIdTestReport") || strKey.equals("comboLabIdTestReportUpdated")){
					//qry = "select ID, DESCRIPTION_OF_GOODS , HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  CGST_RATE ,CGST_AMOUNT , SGST_RATE , SGST_AMOUNT ,AMOUNT  ,SEARCH_KEY  from " + tabName + " where " + colName + " Like '%" + cylCatVal + "%' AND SEARCH_KEY Like '%cgst all%' order by " + ordByCol;

				String colnames = "ID, LAB_ID ,TEST_GROUP, TEST ,RESULT ,CONDITION ,UNITS ,NORM_VALUE ,COLLECT_DATE , COLLECT_TIME ,REPORT_DATE ,REPORT_TIME" +
						",TEST_GROUP_ID, PATIENT_ID,PATIENT_NAME ,GENDER ,AGE,PHONE_NO ,ADDRESS ,REMARK ,CHILD_ADULT ,REF_DOCTOR , METHOD , TEST_REMARKS, SEARCH_KEY,TEST_TYPE ";


					qry = "select "+colnames+" from " + tabName ;
			}
			else if (strKey.equals("comboLabIdTestReport")){
					//AND SEARCH_KEY Like '%cgst all%' order by
					qry = "select ID, LAB_ID ,TEST_GROUP,TEST ,RESULT ,CONDITION ,UNITS ,NORM_VALUE ,COLLECT_DATE , COLLECT_TIME ,REPORT_DATE ,REPORT_TIME" +
							",TEST_GROUP_ID, PATIENT_ID, PATIENT_NAME ,GENDER ,AGE,PHONE_NO ,ADDRESS ,REMARK ,CHILD_ADULT ,REF_DOCTOR , METHOD , TEST_REMARKS, SEARCH_KEY,TEST_TYPE  from " + tabName ;


           		}
			else if (strKey.equals("comboPatientPosNegTestReport") || strKey.equals("comboLabIdPosNegTestReport")){
					qry = "select ID, LAB_ID ,TEST_GROUP,TEST,DEFAULT_VALUE,OPTIONS ,TEST_TYPE,COLLECT_DATE , COLLECT_TIME ,REPORT_DATE ,REPORT_TIME" +
							",TEST_GROUP_ID, PATIENT_ID,PATIENT_NAME ,METHOD , TEST_REMARKS, RESFLAG,SEARCH_KEY from "+ tabName ;


                  }

			else if (strKey.equals("comboPatientTestReceipt") || strKey.equals("searchReceipt") || strKey.equals("comboLabIdTestReceipt")){

				qry = "select LAB_ID , PATIENT_ID , PATIENT_NAME ,DOCTOR_NAME ,TYPE ,AGE, GENDER ,CHILD_ADULT,TEST_GROUP ,MOBILE_NO ,ADDRESS,EMAIL_ID,FEES ,TOTAL_FEES ,DISCOUNT ,PAYABLE ,PAID ,BALANCE ,COLLECT_DATE ,COLLECT_TIME " +
							",REPORT_DATE ,REPORT_TIME ,SEARCH_KEY,TEST_GROUP_ID from " + tabName;

			}
		/*	else if (strKey.equals("comboLabIdTestReceipt")){

				qry = "select LAB_ID , PATIENT_ID , PATIENT_NAME ,DOCTOR_NAME ,TYPE ,AGE, GENDER ,CHILD_ADULT,TEST_GROUP ,MOBILE_NO ,ADDRESS,EMAIL_ID,FEES ,TOTAL_FEES ,DISCOUNT ,PAYABLE ,PAID ,BALANCE ,COLLECT_DATE ,COLLECT_TIME " +
						",REPORT_DATE ,REPORT_TIME ,SEARCH_KEY,TEST_GROUP_ID from " + tabName;


			}*/
			else if (strKey.equals("radioButtonYearWise") || strKey.equals("radioButtonTotal") || strKey.equals("radioButtonDateWise")){

					qry = "select  LAB_ID , PATIENT_ID , PATIENT_NAME ,DOCTOR_NAME ,TYPE ,AGE,GENDER ,CHILD_ADULT ,TEST_GROUP ,MOBILE_NO ,FEES ,TOTAL_FEES ,DISCOUNT ,PAYABLE ,PAID ,BALANCE ,COLLECT_DATE ,COLLECT_TIME " +
							",REPORT_DATE ,REPORT_TIME ,SEARCH_KEY,TEST_GROUP_ID from " + tabName ;// + "' order by " + ordByCol;


			}
			else if (strKey.equals("comboIncomeTestGroupTotal") || strKey.equals("comboIncomeTestGroupYearWise")
					|| strKey.equals("comboIncomeTestGroupDateWise")
					||strKey.equals("searchIncomeReportTotal") || strKey.equals("searchIncomeReportYearWise")
					|| strKey.equals("searchIncomeReportDateWise"))
			{
				qry = "select  LAB_ID , PATIENT_ID , PATIENT_NAME ,DOCTOR_NAME ,TYPE ,AGE,GENDER ,CHILD_ADULT ,TEST_GROUP ,MOBILE_NO ,FEES ,TOTAL_FEES ,DISCOUNT ,PAYABLE ,PAID ,BALANCE ,COLLECT_DATE ,COLLECT_TIME " +
						",REPORT_DATE ,REPORT_TIME ,SEARCH_KEY,TEST_GROUP_ID from " + tabName ;// + "' order by " + ordByCol;


			}
			else if (strKey.length()>0)
			{

				qry = "select * from " + tabName ;



			}




			ResultSet	result = stat.executeQuery(qry);

			ResultSetMetaData	rsmd = result.getMetaData();

			int colCount = rsmd.getColumnCount();


			for (int i = 1; i <= colCount; i++) {


				value += rsmd.getColumnName(i) + ":";
				System.out.println("From  getCylPurchaseCatColNames : getting column names : " + value);

			}


		} catch (Exception ex) {
			System.out.println("Error from  getCylPurchaseCatColNames : " + ex);
		}

		return value;


	}



	public String getGoodsColumnNames(Connection conobj, String tabName, String gstFlagsVal, String strKey) {

		String value = "";
		try {
		Statement	stat = conobj.createStatement();

			String qry = "";

			if (strKey.equals("order") || strKey.equals("ordreceipt") || strKey.equals("delorder"))
			{


				switch (gstFlagsVal) {
					case "stategst": {
						String colnames = "ID,DESCRIPTION_OF_GOODS, HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  IGST_RATE  ,IGST_AMOUNT  ,AMOUNT  ,ORDER_ID , PARTY_NAME , QUOTATION_NAME, SEARCH_KEY ,TRANSPORT_NAME ,SUPPLIER_NAME";
						String searchKeyOrdby = " AND SEARCH_KEY Like '%igst all%' order by ID";
						qry = "select " + colnames + "  from " + tabName ;


						break;
					}
					case "localgst": {
						String colnames = "ID,DESCRIPTION_OF_GOODS, HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  CGST_RATE ,CGST_AMOUNT , SGST_RATE , SGST_AMOUNT ,AMOUNT  ,ORDER_ID , PARTY_NAME , QUOTATION_NAME,SEARCH_KEY,TRANSPORT_NAME ,SUPPLIER_NAME";
						String searchKeyOrdby = " AND SEARCH_KEY Like '%cgst all%' order by ID";

						qry = "select " + colnames + "  from " + tabName ;

						break;
					}
					case "normalgst": {
						String colnames = "ID,DESCRIPTION_OF_GOODS, HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  NORM_GST_RATE  ,NORM_GST_AMOUNT  ,AMOUNT,ORDER_ID , PARTY_NAME , QUOTATION_NAME  ,SEARCH_KEY,SUPPLIER_NAME";
						String searchKeyOrdby = " AND SEARCH_KEY Like '%normal gst all%' order by ID";
						qry = "select " + colnames + "  from " + tabName ;
						break;
					}
				}

			}
			else if (strKey.equals("receipt") || strKey.equals("genReceipt"))
			{


				switch (gstFlagsVal) {
					case "stategst": {
						String colnames = "ID,DESCRIPTION_OF_GOODS, HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  IGST_RATE  ,IGST_AMOUNT  ,AMOUNT  ,ORDER_ID , PARTY_NAME , QUOTATION_NAME, CHEQUE_OR_CASH ,RECEIVED_AMOUNT ,TOTAL_QTY ,TOTAL_AMOUNT ,BALANCE_QTY ,BALANCE_AMOUNT,SEARCH_KEY,SUPPLIER_NAME";
						String searchKeyOrdby = " AND SEARCH_KEY Like '%igst all%' order by ID";
						qry = "select " + colnames + "  from " + tabName ;
						break;
					}
					case "localgst": {
						String colnames = "ID,DESCRIPTION_OF_GOODS, HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  CGST_RATE ,CGST_AMOUNT , SGST_RATE , SGST_AMOUNT ,AMOUNT  ,ORDER_ID , PARTY_NAME , QUOTATION_NAME,CHEQUE_OR_CASH ,RECEIVED_AMOUNT ,TOTAL_QTY ,TOTAL_AMOUNT ,BALANCE_QTY ,BALANCE_AMOUNT,SEARCH_KEY,SUPPLIER_NAME";
						String searchKeyOrdby = " AND SEARCH_KEY Like '%cgst all%' order by ID";
						qry = "select " + colnames + "  from " + tabName ;
						break;
					}
					case "normalgst": {
						String colnames = "ID,DESCRIPTION_OF_GOODS, HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  NORM_GST_RATE  ,NORM_GST_AMOUNT  ,AMOUNT,ORDER_ID , PARTY_NAME , QUOTATION_NAME,CHEQUE_OR_CASH ,RECEIVED_AMOUNT ,TOTAL_QTY ,TOTAL_AMOUNT ,BALANCE_QTY ,BALANCE_AMOUNT  ,SEARCH_KEY,SUPPLIER_NAME";
						String searchKeyOrdby = " AND SEARCH_KEY Like '%normal gst all%' order by ID";
						qry = "select " + colnames + "  from " + tabName ;
						break;
					}
				}

			}
			else if (strKey.equals("stock") || strKey.equals("delstock")){
				if (gstFlagsVal.equals("stategst")) {
					qry = "select ID, DESCRIPTION_OF_GOODS , HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  IGST_RATE  ,IGST_AMOUNT  ,AMOUNT  ,SEARCH_KEY from " + tabName;

				} else if (gstFlagsVal.equals("localgst")) {
					qry = "select ID, DESCRIPTION_OF_GOODS , HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  CGST_RATE ,CGST_AMOUNT , SGST_RATE , SGST_AMOUNT ,AMOUNT  ,SEARCH_KEY from " + tabName;
				} else if (gstFlagsVal.equals("normalgst")) {
					qry = "select ID, DESCRIPTION_OF_GOODS , HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  NORM_GST_RATE  ,NORM_GST_AMOUNT  ,AMOUNT  ,SEARCH_KEY from " + tabName ;
				}
			}

			else if (strKey.length()>0)
			{

					qry = "select * from " + tabName ;



			}




		ResultSet	result = stat.executeQuery(qry);

		ResultSetMetaData	rsmd = result.getMetaData();

			int colCount = rsmd.getColumnCount();


			for (int i = 1; i <= colCount; i++) {


				value += rsmd.getColumnName(i) + ":";
				System.out.println("From  getCylPurchaseCatColNames : getting column names : " + value);

			}


		} catch (Exception ex) {
			System.out.println("Error from  getCylPurchaseCatColNames : " + ex);
		}

		return value;


	}

	public void addStaffNames(Connection conobj, String StaffName) {
		String tableName = "";
		String StaffJoin_Date = "";
		try {
			stat = conobj.createStatement();
			result = stat.executeQuery("select * from LGAStaff");

			rsmd = result.getMetaData();

			columnCount = rsmd.getColumnCount();

			tableName = rsmd.getTableName(columnCount);

			int[] pos = new int[columnCount];

			int posValue = 0;

			System.out.println("From DB addStaffNames column Count is " + columnCount);

			for (int idxVar = 0; idxVar < pos.length; idxVar++) {
				posValue = idxVar;
				pos[idxVar] = ++posValue;

				System.out.println("From DB addStaffNames putting values" + pos[idxVar]);

			}
			//  getLGAStaffColNames(rsmd,columnCount);


			pstat = conobj.prepareStatement("insert into " + tableName + " values(?,?,?)");


			for (int idx = 0; idx < pos.length; idx++) {


				if (pos[idx] == colNoStaffID) {
					String uniQID = "";//genLGAStaffUniId(conobj, tableName);
					pstat.setString(pos[idx], uniQID);
					System.out.println("From addStaffNames  StaffID setting values " + uniQID + "  -->Col No" + pos[idx]);


				}


				if (pos[idx] == colNoStaff_Name) {
					pstat.setString(pos[idx], StaffName);
					System.out.println("From addStaffNames  StaffName setting values " + StaffName + "  -->Col No" + pos[idx]);


				}

				if (pos[idx] == colNoStaffJoin_Date) {
					StaffJoin_Date = getDateVal(tableName);
					pstat.setString(pos[idx], StaffJoin_Date);
					System.out.println("From addStaffNames  StaffJoinDate setting values " + StaffJoin_Date + "  -->Col No" + pos[idx]);


				}


			}
			int insertVal = pstat.executeUpdate();
			System.out.println("From DB addStaffNames row inserted");
			if (insertVal > 0) {
				System.out.println("Value from exUpdate--->" + insertVal);


			}


		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "From addStaffNames Error My Dear : " + ex);
		}


	}

	public void addPartyNames(Connection conobj, String partyName, String tabName) {
		String tableName = "";
		String PartyJoin_Date = "";
		try {
			stat = conobj.createStatement();
			result = stat.executeQuery("select * from " + tabName);

			rsmd = result.getMetaData();

			columnCount = rsmd.getColumnCount();

			tableName = rsmd.getTableName(columnCount);

			int[] pos = new int[columnCount];

			int posValue = 0;

			System.out.println("From DB addPartyNames column Count is " + columnCount);

			for (int idxVar = 0; idxVar < pos.length; idxVar++) {
				posValue = idxVar;
				pos[idxVar] = ++posValue;

				System.out.println("From DB addPartyNames putting values" + pos[idxVar]);

			}
			//                                            getLGAPartyColNames(rsmd,columnCount);


			pstat = conobj.prepareStatement("insert into " + tableName + " values(?,?,?,?)");


			for (int idx = 0; idx < pos.length; idx++) {


				if (pos[idx] == colNoPartyID) {
					int uniQID = genUniId(conobj, tableName);
					pstat.setInt(pos[idx], uniQID);
					System.out.println("From addPartyNames  PartyID setting values " + uniQID + "  -->Col No" + pos[idx]);


				}


				if (pos[idx] == colNoParty_Name) {
					pstat.setString(pos[idx], partyName);
					System.out.println("From addPartyNames PartyName setting values " + partyName + "  -->Col No" + pos[idx]);


				}

				if (pos[idx] == colNoPartyJoin_Date) {
					PartyJoin_Date = getDateVal(tableName);
					pstat.setString(pos[idx], PartyJoin_Date);
					System.out.println("From addPartyNames  PartyJoinDate setting values " + PartyJoin_Date + "  -->Col No" + pos[idx]);


				}

				if (pos[idx] == colNoParty_Cash_Given) {

					pstat.setInt(pos[idx], 0);
					System.out.println("From addPartyNames PartyName setting values 0  -->Col No" + pos[idx]);


				}


			}
			int insertVal = pstat.executeUpdate();
			System.out.println("From DB addPartyNames row inserted");
			if (insertVal > 0) {
				System.out.println("Value from exUpdate--->" + insertVal);


			}


		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "From addPartyNames Error My Dear : " + ex);
		}


	}


	public String addVehicalCategoryValues(Connection conobj, String vehcatid, String VehicalCatVal, String StaffId, String StaffName, String VehicalAvailableCount, String VehicalSellCount, String GivenAmt, int discountValue, String cheqCash, String ChequeNumber, String Model, String chasisNo, String price, String engineNo, String color, String key, String customerName, String remarks) {
		String uniqID = "";
		int vehicalBalanceCnt = 0;
		int totalAmount = 0;
		int balanceAmtVal = 0;
		String vehicalCatValue = "";
		String saleDateVal = "";
		int totalCash = 0;
		int ChequeAmt = 0;
		int calcAmt = 0;
		int vehicalRate = 0;
		int calcVehicalAvailRate = 0;

		int VehAvailCnt = Integer.parseInt(VehicalAvailableCount);
		int VehSellCnt = Integer.parseInt(VehicalSellCount);

		String Col_Name1 = "price", match_Col1 = "ID", Table_Name1 = "vehical_detail";
		String match_Value1 = vehcatid;

		String strVehicalRate = getColData(conobj, Col_Name1, match_Col1, match_Value1, Table_Name1);
		vehicalRate = Integer.parseInt(strVehicalRate);

		calcVehicalAvailRate = (vehicalRate * VehAvailCnt);

		int givenAmt = Integer.parseInt(GivenAmt);

		String tableName = "";


			/*	String ColName="total_amt", matchCol="ID",TableName="vehical_detail";
						String matchValue=vehcatid;

				 String strTotalamt = getColData(conobj,ColName,matchCol,matchValue,TableName);
								totalAmount = Integer.parseInt(strTotalamt);
                          */


		try {
			stat = conobj.createStatement();
			result = stat.executeQuery("select * from auto_sales");

			rsmd = result.getMetaData();

			columnCount = rsmd.getColumnCount();
			tableName = rsmd.getTableName(columnCount);

			System.out.println("Table Name :" + tableName);

			int[] pos = new int[columnCount];

			int posValue = 0;

			System.out.println("From DB addVehicalCategoryValues column Count is " + columnCount);

			for (int idxVar = 0; idxVar < pos.length; idxVar++) {
				posValue = idxVar;
				pos[idxVar] = ++posValue;

				System.out.println("From DB addVehicalCategoryValues putting values" + pos[idxVar]);

			}


			getLGASalesColNames(rsmd, columnCount);


			pstat = conobj.prepareStatement("insert into auto_sales values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");


			vehicalRate = vehicalRate - discountValue;
			int balanceAmt = (vehicalRate - givenAmt);


			if (cheqCash.equals("Cheque") && !(remarks.equals("")))

			{

				for (int idx = 0; idx < pos.length; idx++) {
					if (pos[idx] == colNoSale_ID) {

						int uniID = genUniId(conobj, tableName);
						pstat.setString(pos[idx], "" + uniID);

						System.out.println("From addVehicalCategoryValues Sale ID setting values " + vehcatid + "-->Col No" + pos[idx]);

					}

					if (pos[idx] == colNoSaleID) {
						pstat.setInt(pos[idx], Integer.parseInt(vehcatid));
						System.out.println("From addSalesCylCategoryValues SaleID setting values " + vehcatid + "-->Col No" + pos[idx]);

					}

					if (pos[idx] == colNoSaleStaffID) {
						pstat.setString(pos[idx], StaffId);

						System.out.println("From addVehicalCategoryValues SaleStaff_Name setting values " + StaffId + "-->Col No" + pos[idx]);

					}


					if (pos[idx] == colNoSaleStaff_Name) {
						pstat.setString(pos[idx], StaffName);

						System.out.println("From addVehicalCategoryValues SaleStaff_Name setting values " + StaffName + "-->Col No" + pos[idx]);

					}


					if (pos[idx] == colNoSaleAvailVehicalCount) {
						//	pstat.setInt(pos[idx],Integer.parseInt(VehicalAvailableCount));
						pstat.setInt(pos[idx], 0);

						System.out.println("From addVehicalCategoryValues colNoSaleAvailVehicalCount setting values " + VehicalAvailableCount + "-->Col No" + pos[idx]);


					}

					if (pos[idx] == colNoSaleVehSellCount) {
						pstat.setInt(pos[idx], Integer.parseInt(VehicalSellCount));
						System.out.println("From addVehicalCategoryValues colNoSaleVehSellCount setting values " + VehicalSellCount + "-->Col No" + pos[idx]);


					}

					if (pos[idx] == colNoSaleBalance_Vehical) {

						//	 vehicalBalanceCnt = (VehAvailCnt -VehSellCnt);
						//	pstat.setInt(pos[idx],vehicalBalanceCnt);

						pstat.setInt(pos[idx], vehicalBalanceCnt);

						System.out.println("From addVehicalCategoryValues vehicalBalanceCnt setting values " + vehicalBalanceCnt + "-->Col No" + pos[idx]);

					}
					if (pos[idx] == colNoSaleGiven_Amt) {

						pstat.setInt(pos[idx], givenAmt);
						System.out.println("From addVehicalCategoryValues SaleGiven_Amt setting values " + givenAmt + "-->Col No" + pos[idx]);


					}

					if (pos[idx] == colNoSaleCash_Cheque) {

						pstat.setString(pos[idx], cheqCash);
						System.out.println("From addVehicalCategoryValues SaleCash_Cheque setting values " + cheqCash + "-->Col No" + pos[idx]);


					}
					if (pos[idx] == colNoSaleCheque_ID) {
						//  calcAmt=(ChequeAmt-discountValue);
						pstat.setString(pos[idx], ChequeNumber);
						System.out.println("From addSalesCylCategoryValues SaleCheque_Amt setting values " + ChequeNumber + "-->Col No" + pos[idx]);


					}


					if (pos[idx] == colNoSaleModel) {
						//  calcAmt=(ChequeAmt-discountValue);
						pstat.setString(pos[idx], Model);
						System.out.println("From addSalesCylCategoryValues SaleCheque_Amt setting values " + Model + "-->Col No" + pos[idx]);


					}

					if (pos[idx] == colNoSaleChesiID) {
						//  calcAmt=(ChequeAmt-discountValue);
						pstat.setString(pos[idx], chasisNo);
						System.out.println("From addSalesCylCategoryValues SaleCheque_Amt setting values " + chasisNo + "-->Col No" + pos[idx]);


					}
					if (pos[idx] == colNoSaleEngine_No) {
						//  calcAmt=(ChequeAmt-discountValue);
						pstat.setString(pos[idx], engineNo);
						System.out.println("From addSalesCylCategoryValues SaleCheque_Amt setting values " + engineNo + "-->Col No" + pos[idx]);


					}
					if (pos[idx] == colNoSaleColor) {
						//  calcAmt=(ChequeAmt-discountValue);
						pstat.setString(pos[idx], color);
						System.out.println("From addSalesCylCategoryValues SaleCheque_Amt setting values " + color + "-->Col No" + pos[idx]);


					}
					if (pos[idx] == colNoSaleKey) {
						//  calcAmt=(ChequeAmt-discountValue);
						pstat.setString(pos[idx], key);
						System.out.println("From addSalesCylCategoryValues SaleCheque_Amt setting values " + key + "-->Col No" + pos[idx]);


					}

					if (pos[idx] == colNoSaleRemarks) {

						pstat.setString(pos[idx], remarks);
						System.out.println("From addSalesCylCategoryValues SaleRemarks setting values " + remarks + "-->Col No" + pos[idx]);


					}
					if (pos[idx] == colNoSaleTotal_Amt) {


						pstat.setInt(pos[idx], vehicalRate);

						System.out.println("From addSalesCylCategoryValues SaleTotal_Amt setting values " + vehicalRate + "-->Col No" + pos[idx]);

					}
					if (pos[idx] == colNoSaleBalance_Amt) {

						pstat.setInt(pos[idx], balanceAmt);
						balanceAmtVal = balanceAmt;
						System.out.println("From addSalesCylCategoryValues SaleBalance_Amt setting values " + balanceAmtVal + "-->Col No" + pos[idx]);

					}
					if (pos[idx] == colNoSaleVehical_Category) {
						pstat.setString(pos[idx], VehicalCatVal);

						System.out.println("From addSalesCylCategoryValues SaleCyl_Category setting values " + VehicalCatVal + "-->Col No" + pos[idx]);

					}
					if (pos[idx] == colNoSale_Date) {
						saleDateVal = getDateVal(tableName);
						pstat.setString(pos[idx], saleDateVal);

						System.out.println(" From addSalesCylCategoryValues Sale_Date setting value " + saleDateVal + " -->Col No" + pos[idx]);

					}

					if (pos[idx] == colNoSaleInvoiceNo) {

						int uniID = genUniId(conobj, tableName);


						pstat.setString(pos[idx], "CB/" + uniID + "/" + vehcatid + "/" +
								StaffId + "/" + StaffName.substring(0, 1).toUpperCase());

						System.out.println("From addVehicalCategoryValues Sale ID setting values " + "" + uniID + "/" + vehcatid + "/" +
								StaffId + "/" + StaffName.substring(0, 1) + "-->Col No" + pos[idx]);


					}

					if (pos[idx] == colNoSaleCustomerName) {
						pstat.setString(pos[idx], customerName);

						System.out.println(" From addSalesCylCategoryValues customerName setting value " + customerName + " -->Col No" + pos[idx]);

					}


					if (pos[idx] == colNoSaleDiscountValue) {
						pstat.setString(pos[idx], discountValue + "");

						System.out.println(" From addSalesCylCategoryValues customerName setting value " + customerName + " -->Col No" + pos[idx]);

					}


								/*if(pos[idx]==colNoSaleCash_Total)
									 {
								totalCash = getTotalCyl(conobj,"Given_Amt","Staff_Name",CylStaffName,tableName);
								pstat.setInt(pos[idx],(totalCash+givenAmt));

								System.out.println(" From addSalesCylCategoryValues Sale_Date setting value "+saleDateVal+" -->Col No"+pos[idx]);

									 }
                                                                   */


				}


			} else {


				for (int idx = 0; idx < pos.length; idx++) {
					if (pos[idx] == colNoSale_ID) {

						int uniID = genUniId(conobj, tableName);
						pstat.setString(pos[idx], "" + uniID);

						System.out.println("From addVehicalCategoryValues Sale ID setting values " + uniID + "-->Col No" + pos[idx]);

					}

					if (pos[idx] == colNoSaleID) {
						pstat.setInt(pos[idx], Integer.parseInt(vehcatid));
						System.out.println("From addSalesCylCategoryValues SaleID setting values " + vehcatid + "-->Col No" + pos[idx]);

					}

					if (pos[idx] == colNoSaleStaffID) {
						pstat.setString(pos[idx], StaffId);

						System.out.println("From addVehicalCategoryValues colNoSaleStaffID setting values " + StaffId + "-->Col No" + pos[idx]);

					}


					if (pos[idx] == colNoSaleStaff_Name) {
						pstat.setString(pos[idx], StaffName);

						System.out.println("From addVehicalCategoryValues SaleStaff_Name setting values " + StaffName + "-->Col No" + pos[idx]);

					}


					if (pos[idx] == colNoSaleAvailVehicalCount) {
						//	pstat.setInt(pos[idx],Integer.parseInt(VehicalAvailableCount));
						pstat.setInt(pos[idx], 0);

						System.out.println("From addVehicalCategoryValues colNoSaleAvailVehicalCount setting values " + VehicalAvailableCount + "-->Col No" + pos[idx]);


					}

					if (pos[idx] == colNoSaleVehSellCount) {
						pstat.setInt(pos[idx], Integer.parseInt(VehicalSellCount));
						System.out.println("From addVehicalCategoryValues colNoSaleVehSellCount setting values " + VehicalSellCount + "-->Col No" + pos[idx]);


					}

					if (pos[idx] == colNoSaleBalance_Vehical) {

						//	 vehicalBalanceCnt = (VehAvailCnt -VehSellCnt);
						//	pstat.setInt(pos[idx],vehicalBalanceCnt);

						pstat.setInt(pos[idx], vehicalBalanceCnt);

						System.out.println("From addVehicalCategoryValues vehicalBalanceCnt setting values " + vehicalBalanceCnt + "-->Col No" + pos[idx]);

					}
					if (pos[idx] == colNoSaleGiven_Amt) {

						pstat.setInt(pos[idx], givenAmt);
						System.out.println("From addVehicalCategoryValues SaleGiven_Amt setting values " + givenAmt + "-->Col No" + pos[idx]);


					}

					if (pos[idx] == colNoSaleCash_Cheque) {

						pstat.setString(pos[idx], cheqCash);
						System.out.println("From addVehicalCategoryValues SaleCash_Cheque setting values " + cheqCash + "-->Col No" + pos[idx]);


					}
					if (pos[idx] == colNoSaleCheque_ID) {
						//  calcAmt=(ChequeAmt-discountValue);
						pstat.setString(pos[idx], ChequeNumber);
						System.out.println("From addSalesCylCategoryValues ChequeNumber setting values " + ChequeNumber + "-->Col No" + pos[idx]);


					}

					if (pos[idx] == colNoSaleModel) {
						//  calcAmt=(ChequeAmt-discountValue);
						pstat.setString(pos[idx], Model);
						System.out.println("From addSalesCylCategoryValues Model setting values " + Model + "-->Col No" + pos[idx]);


					}


					if (pos[idx] == colNoSaleChesiID) {
						//  calcAmt=(ChequeAmt-discountValue);
						pstat.setString(pos[idx], chasisNo);
						System.out.println("From addSalesCylCategoryValues chasisNo setting values " + chasisNo + "-->Col No" + pos[idx]);


					}
					if (pos[idx] == colNoSaleEngine_No) {
						//  calcAmt=(ChequeAmt-discountValue);
						pstat.setString(pos[idx], engineNo);
						System.out.println("From addSalesCylCategoryValues engineNo setting values " + engineNo + "-->Col No" + pos[idx]);


					}
					if (pos[idx] == colNoSaleColor) {
						//  calcAmt=(ChequeAmt-discountValue);
						pstat.setString(pos[idx], color);
						System.out.println("From addSalesCylCategoryValues color setting values " + color + "-->Col No" + pos[idx]);


					}
					if (pos[idx] == colNoSaleKey) {
						//  calcAmt=(ChequeAmt-discountValue);
						pstat.setString(pos[idx], key);
						System.out.println("From addSalesCylCategoryValues key setting values " + key + "-->Col No" + pos[idx]);


					}

					if (pos[idx] == colNoSaleRemarks) {

						pstat.setString(pos[idx], remarks);
						System.out.println("From addSalesCylCategoryValues SaleRemarks setting values " + remarks + "-->Col No" + pos[idx]);


					}
					if (pos[idx] == colNoSaleTotal_Amt) {


						pstat.setInt(pos[idx], vehicalRate);

						System.out.println("From addSalesCylCategoryValues SaleTotal_Amt setting values " + totalAmount + "-->Col No" + pos[idx]);

					}
					if (pos[idx] == colNoSaleBalance_Amt) {

						pstat.setInt(pos[idx], balanceAmt);
						balanceAmtVal = balanceAmt;
						System.out.println("From addSalesCylCategoryValues SaleBalance_Amt setting values " + balanceAmtVal + "-->Col No" + pos[idx]);

					}
					if (pos[idx] == colNoSaleVehical_Category) {
						pstat.setString(pos[idx], VehicalCatVal);

						System.out.println("From addSalesCylCategoryValues VehicalCatVal setting values " + VehicalCatVal + "-->Col No" + pos[idx]);

					}
					if (pos[idx] == colNoSale_Date) {
						saleDateVal = getDateVal(tableName);
						pstat.setString(pos[idx], saleDateVal);

						System.out.println(" From addSalesCylCategoryValues Sale_Date setting value " + saleDateVal + " -->Col No" + pos[idx]);

					}

					if (pos[idx] == colNoSaleInvoiceNo) {

						int uniID = genUniId(conobj, tableName);


						pstat.setString(pos[idx], "CB/" + uniID + "/" + vehcatid + "/" +
								StaffId + "/" + StaffName.substring(0, 1).toUpperCase());

						System.out.println("From addVehicalCategoryValues Sale colNoSaleInvoiceNo setting values " + "" + uniID + "/" + vehcatid + "/" +
								StaffId + "/" + StaffName.substring(0, 1) + "-->Col No" + pos[idx]);


					}


					if (pos[idx] == colNoSaleCustomerName) {
						pstat.setString(pos[idx], customerName);

						System.out.println(" From addSalesCylCategoryValues customerName setting value " + customerName + " -->Col No" + pos[idx]);

					}

					if (pos[idx] == colNoSaleDiscountValue) {
						pstat.setString(pos[idx], discountValue + "");

						System.out.println(" From addSalesCylCategoryValues customerName setting value " + customerName + " -->Col No" + pos[idx]);

					}


								/*if(pos[idx]==colNoSaleCash_Total)
									 {
								totalCash = getTotalCyl(conobj,"Given_Amt","Staff_Name",CylStaffName,tableName);
								pstat.setInt(pos[idx],(totalCash+givenAmt));

								System.out.println(" From addSalesCylCategoryValues Sale_Date setting value "+saleDateVal+" -->Col No"+pos[idx]);

									 }
                                                                   */


				}

								/*if(pos[idx]==colNoSaleCash_Total)
									 {
								totalCash = getTotalCyl(conobj,"Given_Amt","Staff_Name",CylStaffName,tableName);
								pstat.setInt(pos[idx],(totalCash+givenAmt));

								System.out.println(" From addSalesCylCategoryValues Sale_Date setting value "+saleDateVal+" -->Col No"+pos[idx]);

									 }
                                                                   */


			}

			int insertVal = pstat.executeUpdate();

			if (insertVal > 0) {
				System.out.println("From DB addSalesVehicalCategoryValues Value from exUpdate--->" + insertVal);
				System.out.println("From DB addSalesVehicalCategoryValues row inserted");

							/*	System.out.println("From DB addSalesVehicalCategoryValues Value from exUpdate--->"+insertVal);
								System.out.println("From DB addSalesVehicalCategoryValues row inserted");
								int totVehicalOut=0;

								String tName1="auto_purchase_total";
										String columnName1="total_vehical_out";
										String matchColum1="ID";
										int matchVal1=1;
										String colData1=getColData(conobj,columnName1,matchColum1,matchVal1,tName1);
										if(colData1!=null)
										{
										System.out.println("Caught!!!!!!!!!!!!!!!!!!!!!");
								                totVehicalOut=Integer.parseInt(colData1);

					 					addVehicalCategoryValuesToAutoPurchaseTotal(conobj,0,(totVehicalOut+VehAvailCnt),0,calcVehicalAvailRate,1,VehAvailCnt);
										}
										else
										{
										//totCylOut=VehAvailCnt;

										addVehicalCategoryValuesToAutoPurchaseTotal(conobj,0,VehAvailCnt,0,calcVehicalAvailRate,1,totVehicalOut);
										}






								String tName="main_bank";
										String columnName="total_amount";
										String matchColum="ID";
										int matchVal=1;
										String colData=getColData(conobj,columnName,matchColum,matchVal,tName);
										if(colData!=null)
										{
										System.out.println("Caught!!!!!!!!!!!!!!!!!!!!!");
								int totCash=Integer.parseInt(colData);
										System.out.println("2nd Caught!!!!!!!!!!!!!!!!!!!!!");
					 					updateTotalCashToMainBank(conobj,(totCash+givenAmt));
										}
										else
										{
										updateTotalCashToMainBank(conobj,(givenAmt));
										}

										String tName_S="LGASales";
										String columnName_S="Given_Amt";
										String matchColum_S="";
										String matchVal_S="";
										int totCash=Integer.parseInt(getColData(conobj,columnName_S,matchColum_S,matchVal_S,tName_S));
					 					//insertCashToBank(conobj,"Cash_Bank",totCash,0);


								updateBalToLGAPurchase(conobj,balanceAmtVal,VehicalCatVal);

								updateCylCategoryReportValues(conobj,vehcatid,VehicalCatVal,VehAvailCnt,VehSellCnt,totalAmount,givenAmt);


                         					System.out.println("returning values to SaleEntry");


							     return uniqID+":"+vehicalBalanceCnt+":"+totalAmount+":"+balanceAmtVal+":"+VehicalCatVal+":"+saleDateVal;
                     					 */
			}


		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "From addSalesCylCategoryValues Error My Dear : " + ex);
		}

		return "";//uniqID+":"+vehicalBalanceCnt+":"+totalAmount+":"+balanceAmtVal+":"+VehicalCatVal+":"+saleDateVal;

	}


/*		public void updateSalesCylCategoryValues(Connection conobj,String IDStaffReport,String ColNamesStaffReport,String ColValuesStaffReport)
				{
					   int id =Integer.parseInt(IDStaffReport);


						if(ColNamesStaffReport.equals("Given_Amt"))
						{
							int val=Integer.parseInt(ColValuesStaffReport);


										String tName="LGA_MainBank";
										String columnName="Total_Amount";
										String matchColum="ID";
										int matchVal=1;
										int totCash=Integer.parseInt(getColData(conobj,columnName,matchColum,matchVal,tName));
					 					updateTotalCashToMainBank(conobj,(totCash+val));



						}
					try
			                {

				                         int value=Integer.parseInt(ColValuesStaffReport);


		pstat=conobj.prepareStatement("update LGASales set "+ColNamesStaffReport+" = ? where ID = ?" );





								pstat.setInt(1,value);

								System.out.println("updating values From updateSalesCylCategoryValues Column Values "+ColValuesStaffReport);


								pstat.setInt(2,id);
								System.out.println("setting values From updateSalesCylCategoryValues ID Staff Report   "+IDStaffReport);



                                                                      int insertVal=pstat.executeUpdate();
								System.out.println("From DB updateSalesCylCategoryValues row inserted");
                     						if(insertVal>0)
                    						 {
                      						System.out.println("Value from exUpdate--->"+insertVal);


                     						}








                            }
                	 catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"From updateSalesCylCategoryValues  Error My Dear : "+ex);
					try{
				pstat=conobj.prepareStatement("update LGASales set "+ColNamesStaffReport+" = ? where ID = ?" );

					pstat.setString( 1,ColValuesStaffReport);

								System.out.println("updating values From updateSalesCylCategoryValues Column Values "+ColValuesStaffReport);


								pstat.setInt(2,id);
								System.out.println("setting values From updateSalesCylCategoryValues ID Staff Report   "+id);



                                                                      int insertVal=pstat.executeUpdate();
								System.out.println("From DB updateSalesCylCategoryValues row inserted");
                     						if(insertVal>0)
                    						 {
                      						System.out.println("Value from exUpdate--->"+insertVal);


                     						}

					  } catch(Exception exec)
						{ JOptionPane.showMessageDialog(null,"From Inner-->updateSalesCylCategoryValues  Error My Dear : "+ex);	}

				}




				}
*/

	void updateTotalCashToMainBank(Connection conobj, int givenAmt) {

		try {


			pstat = conobj.prepareStatement("update LGA_MainBank set Total_Amount = ? , M_Date = ? where ID = ?");


			int totalCashValue = givenAmt;

			pstat.setInt(1, totalCashValue);

			System.out.println("updating values From updateTotalCashToLGAMainBank total Cash Value--->" + totalCashValue);

			String mdate = getDateVal("LGA_MainBank");

			pstat.setString(2, mdate);
			System.out.println("setting values From updateTotalCashToLGAMainBank  M_Date--->" + mdate);

			int id = 1;
			pstat.setInt(3, id);
			System.out.println("setting values From updateTotalCashToLGAMainBank  id--->" + id);

			int insertVal = pstat.executeUpdate();

			if (insertVal > 0) {
				System.out.println("From DB updateTotalCashToLGAMainBank row inserted");
				System.out.println("Value from exUpdate--->" + insertVal);


			}


		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "From updateTotalCashToLGAMainBank Error My Dear : " + ex);
		}


	}


	void updateBalToLGAPurchase(Connection conobj, int balanceAmtVal, String cylCatVal) {

		try {


			pstat = conobj.prepareStatement("update LGAPurchase set Total_Amount = ? where Cyl_Category = ?");


			pstat.setInt(1, balanceAmtVal);

			System.out.println("updating values From updateBalToLGAPurchase balanceAmt  ");


			pstat.setString(2, cylCatVal);
			System.out.println("setting values From updateBalToLGAPurchase  Cylinder Category Name   ");


			int insertVal = pstat.executeUpdate();
			System.out.println("From DB updateBalToLGAPurchase row inserted");
			if (insertVal > 0) {
				System.out.println("Value from exUpdate--->" + insertVal);


			}


		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "From updateBalToLGAPurchase Error My Dear : " + ex);
		}


	}

	/*	        public String updatePartyValues(Connection conobj,String BankPartyVal,String tabName,String colName,String setColValue,String txtCash)
				{
					int  cashSum=0;
					int valDeduction=0;
					try
			                {

						int cashGiven=Integer.parseInt(txtCash);


		pstat=conobj.prepareStatement("update "+tabName+" set "+setColValue+" = ? where "+colName+" = ?" );

		String ColName=setColValue,matchCol=colName,matchValue=BankPartyVal,TableName=tabName;
				       String strCasch=getColData(conobj,ColName,matchCol,matchValue,TableName);
   						int intCash=Integer.parseInt(strCasch);
						cashSum=(cashGiven+intCash);
								pstat.setInt(1,cashSum);

								System.out.println("updating values From updatePartyValues Cash given is "+cashSum);


								pstat.setString(2,BankPartyVal);
								System.out.println("setting values From updatePartyValues  Bank Party is "+BankPartyVal);



                                                                      int insertVal=pstat.executeUpdate();
								if(insertVal>0)
                    						 {
									System.out.println("From DB updatePartyValues row inserted");

										String tName="LGA_MainBank";
										String columnName="Total_Amount";
										String matchColum="ID";
										int matchVal=1;
										int totCash=Integer.parseInt(getColData(conobj,columnName,matchColum,matchVal,tName));
					 					valDeduction=(totCash-cashGiven);
										updateTotalCashToLGAMainBank(conobj,(valDeduction));
										//insertCashToBank(conobj,"Cash_Bank",totCash,cashGiven);

                      						System.out.println("Value from exUpdate--->"+insertVal);


                     						}








                            }
                	 catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"From updatePartyValues Error My Dear : "+ex);
				}








				return ""+valDeduction;

				}



				int getUniId(Connection conobj,String TableName)
                      		{

                       int unid=0;
                         try
               		 {
                 stat=conobj.createStatement();

                result=stat.executeQuery("SELECT   max("+TableName+".ID) FROM "+TableName);
                 		if(result.next())
                 			{

                      		 int idValue=  result.getInt(1);
				unid = idValue;
                       		System.out.println("from getUniId idValue--->"+idValue);

                               		                 			}

               			 }
                 		catch(Exception ex){System.out.println("From getUniId-->"+ex);


                 		}



                         return unid;
           	}

*/
	void updateCylCategoryReportValues(Connection conobj, String vehcatid, String vehicalCatVal, int VehAvailCnt, int VehSellCnt, int totalAmount, int givenAmt) {


		int Vehical_avail_Start_Qty = 0;
		int cylEmpty = 0;
		int totCash = 0;
		String tableName = "";

		try {
			stat = conobj.createStatement();
			result = stat.executeQuery("select * from LGASalesReport");

			rsmd = result.getMetaData();

			columnCount = rsmd.getColumnCount();
			tableName = rsmd.getTableName(columnCount);

			System.out.println("Table Name :" + tableName);

			int[] pos = new int[columnCount];

			int posValue = 0;

			System.out.println("From DB updateCylCategoryReportValues column Count is " + columnCount);


			getLGASalesReportColNames(rsmd, columnCount);

			String updQ = "update " + tableName + " set " + colNameSaleReportCyl_Fill_Start_Qty + " = ?," + colNameSaleReportCyl_Fill_Current_Qty + " = ?," + colNameSaleReportCyl_Empty_Total_Balance + " = ? ," + colNameSaleReportTotal_Cash + " = ? ," + colNameSaleReportCurrent_Balance_Amount + " = ?," + colNameSaleReportTotal_Amount + " = ?," + colNameSaleReportT_Date + " = ?  where " + colNameSaleReportCyl_Category + " = ? ";

			pstat = conobj.prepareStatement(updQ);

			System.out.println("Table Name :" + tableName + "Query---->" + updQ);


			String ColName1 = "vehical_qty", matchCol1 = "ID", TableName1 = "vehical_detail";
			String matchValue1 = vehcatid;

			String strCyl_Fill_Start_Qty = getColData(conobj, ColName1, matchCol1, matchValue1, TableName1);
			Vehical_avail_Start_Qty = Integer.parseInt(strCyl_Fill_Start_Qty);

			pstat.setInt(1, Vehical_avail_Start_Qty);
			System.out.println("From updateCylCategoryReportValues Cyl_Fill_Start_Qty setting values " + Vehical_avail_Start_Qty);


			int cylCurrentQty = (Vehical_avail_Start_Qty - getTotalCyl(conobj, "vehical_available", "ID", vehcatid, "auto_sales"));
			pstat.setInt(2, cylCurrentQty);
			System.out.println("From updateCylCategoryReportValues SaleCyl_CurrentQty setting values " + cylCurrentQty);


			//funCallforCylEmpty;

			cylEmpty = getTotalCyl(conobj, "vehical_sell", "ID", vehcatid, "auto_sales");

			pstat.setInt(3, cylEmpty);

			System.out.println("From updateCylCategoryReportValues TotalEmptyCyl setting values " + cylEmpty);

			totCash = getTotalCyl(conobj, "given_amt", "ID", vehcatid, "auto_sales");
			pstat.setInt(4, totCash);

			System.out.println("From updateCylCategoryReportValues TotalCash setting values " + totCash);


			int balAmt = totalAmount - givenAmt;
			pstat.setInt(5, balAmt);

			System.out.println("From updateCylCategoryReportValues balanceAmount setting values " + balAmt);


			//use it		String ColName="Old_Total_Amount", matchCol="Cyl_Category",TableName="LGAPurchase";
			//use it	String matchValue=cylCatVal;

			//use it           String stroldTotalAmount = getColData(conobj,ColName,matchCol,matchValue,TableName);
			int oldTotalAmount = 0;//use itInteger.parseInt(stroldTotalAmount);


			pstat.setInt(6, oldTotalAmount);

			System.out.println("From updateCylCategoryReportValues TotalAmount setting values " + oldTotalAmount);
			String rdate = getDateVal(tableName);

			pstat.setString(7, rdate);
			System.out.println("From updateCylCategoryReportValues ReportDate setting values " + rdate);


			pstat.setString(8, vehicalCatVal);

			System.out.println("From updateCylCategoryReportValues cylCategoryVal setting values " + vehicalCatVal);

			int insertVal = pstat.executeUpdate();


			if (insertVal > 0) {
				System.out.println("From DB updateCylCategoryReportValues row inserted");

				System.out.println("Value from exUpdate--->" + insertVal);


			}


		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "From updateCylCategoryReportValues Error My Dear : " + ex);
		}


	}


	public int getTotalCyl(Connection conobj, String colName, String matchCol, String cylCatVal, String tabName) {
		int values = 0;

		try {

			if (cylCatVal != "") {


				stat = conobj.createStatement();


				result = stat.executeQuery("select " + colName + " from " + tabName + " where " + matchCol + "='" + cylCatVal + "'");

				rsmd = result.getMetaData();


				int columnCount = rsmd.getColumnCount();


				while (result.next()) {


					values += result.getInt(1);

					System.out.println("from getTotalCyl Fetching Records from Table " + rsmd.getTableName(columnCount) + " Values : " + values);


				}

			}

		} catch (Exception ex) {
			System.out.println("Error from  getTotalCyl : " + ex);
		}


		return values;
	}


	/*	 public  int getTotalCash(Connection conobj,String colName,String tabName)
			    {
				 int values=0;

					 try
               				 {






                				 stat=conobj.createStatement();


                                                 result=stat.executeQuery("select "+colName+" from "+tabName);

                                                 rsmd=result.getMetaData();









                                                int  columnCount=rsmd.getColumnCount();


                                                while(result.next())
						{





							values+=result.getInt(1);

							System.out.println("from getTotalCash Fetching Records from Table "+rsmd.getTableName(columnCount)+" Values : "+values);








						}



                			}
                 			catch(Exception ex){
						System.out.println("Error from  getTotalCash : "+ex);
							   }










				    return values;







			    }


		    public void  insertCashToBank(Connection conobj,String tabName,int totalCash,int cashFromUpdPartyValues)
				{
				   String tableName = "";
				   String CashDate = "";
				   int actualCash = 0;
				   int t_cash = 0;
				try
			                {
					stat=conobj.createStatement();
                                        result=stat.executeQuery("select * from "+tabName);

                                        rsmd=result.getMetaData();

					columnCount=rsmd.getColumnCount();

					tableName=rsmd.getTableName(columnCount);

					int[] pos=new int[columnCount];

			              int posValue=0;

		                    System.out.println("From DB addPartyNames column Count is "+columnCount);

				       for(int idxVar=0;idxVar<pos.length;idxVar++)
					{posValue=idxVar;
                                                                        pos[idxVar]=++posValue;

					      System.out.println("From DB addPartyNames putting values"+pos[idxVar]);

				 	}
                                                                            getTabColNames(rsmd,columnCount);



		pstat=conobj.prepareStatement("insert into "+tableName+" values(?,?,?)");

						    if(cashFromUpdPartyValues>0)
						    {
							    for(int idx=0;idx<pos.length;idx++)
								{


								 if(pos[idx]==colNoBankID)
									 {
									int uniQID=genUniId(conobj,tableName);
								pstat.setInt(pos[idx],uniQID);
						System.out.println("From insertCashToBank  PartyID setting values "+uniQID+"  -->Col No"+pos[idx]);


									 }




								 if(pos[idx]==colNoBank_Total_Cash_Available)
									 {

									t_cash = (totalCash-cashFromUpdPartyValues);
								pstat.setInt(pos[idx],t_cash);
								System.out.println("From insertCashToBank Total_Cash_Available setting values "+t_cash+"  -->Col No"+pos[idx]);


									 }

								 if(pos[idx]==colNoBank_Cash_Date)
								 	{
								  CashDate= getDateVal(tableName);
								pstat.setString(pos[idx], CashDate);
								System.out.println("From insertCashToBank  Cash_Date setting values "+CashDate+"  -->Col No"+pos[idx]);


									 }

						                }

							}

							else if(cashFromUpdPartyValues==0)
							{
								  for(int idx=0;idx<pos.length;idx++)
								{


								 if(pos[idx]==colNoBankID)
									 {
									int uniQID=genUniId(conobj,tableName);
								pstat.setInt(pos[idx],uniQID);
						System.out.println("From insertCashToBank  PartyID setting values "+uniQID+"  -->Col No"+pos[idx]);


									 }




								 if(pos[idx]==colNoBank_Total_Cash_Available)
									 {
								pstat.setInt(pos[idx],(totalCash));
								System.out.println("From insertCashToBank Total_Cash_Available setting values "+totalCash+"  -->Col No"+pos[idx]);


									 }

								 if(pos[idx]==colNoBank_Cash_Date)
								 	{
								  CashDate= getDateVal(tableName);
								pstat.setString(pos[idx], CashDate);
								System.out.println("From insertCashToBank  Cash_Date setting values "+CashDate+"  -->Col No"+pos[idx]);


									 }

						                }



							}
                                                                      int insertVal=pstat.executeUpdate();
								System.out.println("From DB insertCashToBank row inserted");
                     						if(insertVal>0)
                    						 {
                      						System.out.println("Value from exUpdate--->"+insertVal);


                     						}








                            }
                	 catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"From insertCashToBank Error My Dear : "+ex);
				}







				}


	    public void updateCylCategoryValues(Connection conobj,String cylCatVal,String CylRate,String CylQty,int vOoZ)
				{




	if(vOoZ==0)
		{


					try
			                {

		int cRate=Integer.parseInt(CylRate);
		int cQty=Integer.parseInt(CylQty);



		pstat=conobj.prepareStatement("update LGAPurchase set "+colNameCyl_Rate+" = ?,"+colNameCyl_Qty+" = ?,"+colNameTotal_Amount+" = ?,"+colNameOldTotal_Amount+" = ? where "+colNameCyl_Category+"=?" );




								pstat.setInt(1,cRate);

								System.out.println("updating values From addCylCategoryNames Rate  ");






								pstat.setInt(2,cQty);

								System.out.println("updating values From addCylCategoryNames  Cylinder Category Quantity  ");


								int totAmt = (cQty*cRate);

								pstat.setInt(3,totAmt);
								pstat.setInt(4,totAmt);

								pstat.setString(5,cylCatVal);
								System.out.println("setting values From addCylCategoryNames  Cylinder Category Name   ");



                                                                      int insertVal=pstat.executeUpdate();
								System.out.println("From DB addCylCategoryNames row inserted");
                     						if(insertVal>0)
                    						 {
                      						System.out.println("Value from exUpdate--->"+insertVal);
									String tName="LGAPurchaseTotal";
										String columnName="Total_Cyl_In";
										String matchColum="ID";
										int matchVal=1;
										String colData=getColData(conobj,columnName,matchColum,matchVal,tName);

									String tName1="LGAPurchaseTotal";
										String columnName1="Total_Amount";
										String matchColum1="ID";
										int matchVal1=1;
										String colData1=getColData(conobj,columnName1,matchColum1,matchVal1,tName1);




										if(colData!=null && colData1!=null)
										{
										System.out.println("Caught!!!!!!!!!!!!!!!!!!!!!");
								int totCylIn=Integer.parseInt(colData);
								 int totAmountfrmPurchase=Integer.parseInt(colData1);
					 					addCylCategoryValuesToLGAPurchaseTotal(conobj,(totCylIn+cQty),0,(totAmountfrmPurchase+totAmt),0,1,0);
										}
										else
										{
										addCylCategoryValuesToLGAPurchaseTotal(conobj,(cQty),0,totAmt,0,1,0);
										}

                         					}








                            }
                	 catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"From addCylCategoryNames Error My Dear : "+ex);
				}
		  }
		else if(vOoZ==1)
		 {

			updateCylCategoryV1(conobj,cylCatVal,CylRate,CylQty);

		 }

				}



		      void updateCylCategoryV1(Connection conobj,String cylCatVal,String CylRate,String CylQty)
				{





			try
			                {


					     int cRate=Integer.parseInt(CylRate);
					     int cQty=Integer.parseInt(CylQty);

		pstat=conobj.prepareStatement("update LGAPurchase set "+colNameCyl_Rate+" = ?,"+colNameCyl_Qty+" = ?,"+colNameTotal_Amount+" = ?,"+colNameOldTotal_Amount+" = ? where "+colNameCyl_Category+"=?" );




								pstat.setInt(1,cRate);

								System.out.println("updating values From updateCylCategoryV1 Rate  ");






								pstat.setInt(2,cQty);

								System.out.println("updating values From updateCylCategoryV1  Cylinder Category Quantity  ");


								int totAmt = (cQty*cRate);

								pstat.setInt(3,totAmt);
								pstat.setInt(4,totAmt);

								pstat.setString(5,cylCatVal);
								System.out.println("setting values From updateCylCategoryV1  Cylinder Category Name   ");



                                                                      int insertVal=pstat.executeUpdate();
								System.out.println("From DB updateCylCategoryV1 row inserted");
                     						if(insertVal>0)
                    						 {
                      						System.out.println("Value from exUpdate--->"+insertVal);
							         }








                            }
                	 catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"From addCylCategoryNames Error My Dear : "+ex);
				}






				}




	void getLGAStaffColNames(ResultSetMetaData rsmd,int ColCount)
		{
			 try
               					 {

                 				for(int i=1;i<=ColCount;i++)
                 					{
					        	if(rsmd.getColumnName(i).equals("ID"))
								{

								colNoStaffID=i;
								colNameStaff_ID=rsmd.getColumnName(i);
				System.out.println("values From getLGAPurchaseColNames-->Col No "+colNoStaffID+" Col Name :"+colNameStaff_ID);
								}

                                                        if(rsmd.getColumnName(i).equals("Staff_Name"))
								{

								colNoStaff_Name=i;
								colNameStaff_Name=rsmd.getColumnName(i);
				System.out.println("values From getLGAStaffColNames    -->Col No "+colNoStaff_Name+" Col Name :"+colNameStaff_Name);
								}
							 if(rsmd.getColumnName(i).equals("Staff_Join_Date"))
								{
								colNoStaffJoin_Date=i;
								colNameStaffJoin_Date=rsmd.getColumnName(i);
				System.out.println("values From getLGAStaffColNames    -->Col No "+colNoStaffJoin_Date+" Col Name :"+colNameStaffJoin_Date);
								}

							                 					}

                				}
                 				catch(Exception ex){System.out.println("Error from getLGAStaffColNames : "+ex);}





		}


	void getLGAPartyColNames(ResultSetMetaData rsmd,int ColCount)
		{
			 try
               					 {

                 				for(int i=1;i<=ColCount;i++)
                 					{
					        	if(rsmd.getColumnName(i).equals("ID"))
								{

								colNoPartyID=i;
								colNameParty_ID=rsmd.getColumnName(i);
				System.out.println("values From getLGAPurchaseColNames-->Col No "+colNoPartyID+" Col Name :"+colNameParty_ID);
								}

                                                        if(rsmd.getColumnName(i).equals("Party_Name"))
								{

								colNoParty_Name=i;
								colNameParty_Name=rsmd.getColumnName(i);
				System.out.println("values From getLGAStaffColNames    -->Col No "+colNoParty_Name+" Col Name :"+colNameParty_Name);
								}
							       if(rsmd.getColumnName(i).equals("Cash_Given"))
								{

								colNoParty_Cash_Given=i;
								colNameParty_Cash_Given=rsmd.getColumnName(i);
				System.out.println("values From getLGAStaffColNames    -->Col No "+colNoParty_Cash_Given+" Col Name :"+colNameParty_Cash_Given);
								}

							 if(rsmd.getColumnName(i).equals("Party_Join_Date"))
								{
								colNoPartyJoin_Date=i;
								colNamePartyJoin_Date=rsmd.getColumnName(i);
				System.out.println("values From getLGAStaffColNames    -->Col No "+colNoPartyJoin_Date+" Col Name :"+colNamePartyJoin_Date);
								}

							                 					}

                				}
                 				catch(Exception ex){System.out.println("Error from getLGAPartyColNames : "+ex);}





		}

*/
	void getTabColNames(String tableName, ResultSetMetaData rsmd, int ColCount) {


		try {

//			System.out.println("Inside getTabColNames" + tableName + "and ColCount is -->" + ColCount);


			if (tableName.equals("INVENTORY_DETAIL")) {


				for (int i = 1; i <= ColCount; i++) {

					//System.out.println("colnames====> " + rsmd.getColumnName(i));


					if (rsmd.getColumnName(i).equals("ID")) {

						col_driver_id = i;
						col_name_ID = rsmd.getColumnName(i);
						//	System.out.println("values From getLGABankColNames-->Col No " + col_ID + " Col Name :" + col_name_ID);
					}


					if (rsmd.getColumnName(i).equals("VEHICAL_ID")) {

						col_vehical_id = i;
						col_name_vehical_name = rsmd.getColumnName(i);
						//	System.out.println("values From getLGABankColNames    -->Col No " + col_driver_name + " Col Name :" + col_name_vehical_name);
					}
					if (rsmd.getColumnName(i).equals("VEHICAL_NAME")) {
						col_vehical_name = i;
						col_name_fuel_type = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames    -->Col No " + col_conductor_name + " Col Name :" + col_name_fuel_type);
					}
					if (rsmd.getColumnName(i).equals("VEHICAL_NO")) {
						col_vehical_no = i;
						col_name_model = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames    -->Col No " + col_model + " Col Name :" + col_name_model);


					}

					if (rsmd.getColumnName(i).equals("MATERIAL_ID")) {
						col_material_id = i;
						col_name_brand = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames    -->Col No " + col_brand + " Col Name :" + col_name_brand);


					}


					if (rsmd.getColumnName(i).equals("MATERIAL_NAME")) {
						col_material_name = i;
						col_name_brand = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames    -->Col No " + col_brand + " Col Name :" + col_name_brand);


					}


					if (rsmd.getColumnName(i).equals("MATERIAL_QTY")) {
						col_material_qty = i;
						col_name_year = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames    -->Col No " + col_year + " Col Name :" + col_name_year);


					}
					if (rsmd.getColumnName(i).equals("MATERIAL_PRICE")) {
						col_material_price = i;
						col_name_chasiID = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames    -->Col No " + col_chasiID + " Col Name :" + col_name_chasiID);


					}


					if (rsmd.getColumnName(i).equals("ID")) {

						col_ID = i;
						col_name_ID = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames-->Col No " + col_ID + " Col Name :" + col_name_ID);
					}
					if (rsmd.getColumnName(i).equals("ID")) {

						col_driver_id = i;
						col_name_ID = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames-->Col No " + col_ID + " Col Name :" + col_name_ID);
					}


					if (rsmd.getColumnName(i).equals("DRIVER_NAME")) {

						col_driver_name = i;
						col_name_vehical_name = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames    -->Col No " + col_driver_name + " Col Name :" + col_name_vehical_name);
					}
					if (rsmd.getColumnName(i).equals("CONDUCTOR_NAME")) {
						col_conductor_name = i;
						col_name_fuel_type = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames    -->Col No " + col_conductor_name + " Col Name :" + col_name_fuel_type);
					}
					if (rsmd.getColumnName(i).equals("FROM_TO")) {
						col_from_to = i;
						col_name_model = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames    -->Col No " + col_model + " Col Name :" + col_name_model);


					}


					if (rsmd.getColumnName(i).equals("VIVARAN")) {
						col_vivaran = i;
						col_name_brand = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames    -->Col No " + col_brand + " Col Name :" + col_name_brand);


					}


					if (rsmd.getColumnName(i).equals("AMOUNT")) {
						col_amount = i;
						col_name_year = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames    -->Col No " + col_year + " Col Name :" + col_name_year);


					}
					if (rsmd.getColumnName(i).equals("LOADER")) {
						col_loader = i;
						col_name_chasiID = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames    -->Col No " + col_chasiID + " Col Name :" + col_name_chasiID);


					}


					if (rsmd.getColumnName(i).equals("ORDER_BUYER")) {
						col_orderOrBuyer = i;
						col_name_price = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames    -->Col No " + col_price + " Col Name :" + col_name_price);


					}


					if (rsmd.getColumnName(i).equals("CASH_DEPOSIT")) {
						col_cashDeposit = i;
						col_name_engine_no = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames    -->Col No " + col_engine_no + " Col Name :" + col_name_engine_no);


					}


					if (rsmd.getColumnName(i).equals("VEH_ENTRY_DATE")) {
						col_vehical_entry_date = i;
						col_name_vehical_entry_date = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames    -->Col No " + col_vehical_entry_date + " Col Name :" + col_name_vehical_entry_date);


					}


					if (rsmd.getColumnName(i).equals("OLD_EXPENSES")) {
						col_old_ExpVal = i;
						col_name_color = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames    -->Col No " + col_color + " Col Name :" + col_name_color);


					}

					if (rsmd.getColumnName(i).equals("AMOUNT_GIVEN")) {
						col_expenses = i;
						col_name_color = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames    -->Col No " + col_color + " Col Name :" + col_name_color);


					}

					if (rsmd.getColumnName(i).equals("DIESEL")) {
						col_diesel = i;
						col_name_key_no = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames    -->Col No " + col_key_no + " Col Name :" + col_name_key_no);


					}
					if (rsmd.getColumnName(i).equals("FROM")) {
						col_from = i;
						col_name_key_no = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames    -->Col No " + col_key_no + " Col Name :" + col_name_key_no);


					}

					if (rsmd.getColumnName(i).equals("START_READING")) {
						col_start_reading = i;
						col_name_key_no = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames    -->Col No " + col_key_no + " Col Name :" + col_name_key_no);


					}
					if (rsmd.getColumnName(i).equals("END_READING")) {
						col_end_reading = i;
						col_name_key_no = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames    -->Col No " + col_key_no + " Col Name :" + col_name_key_no);


					}


					if (rsmd.getColumnName(i).equals("OLD_BALANCE")) {
						col_old_Balance = i;
						col_name_old_Balance = rsmd.getColumnName(i);
						//	System.out.println("values From getLGABankColNames    -->Col No " + col_old_Balance + " Col Name :" + col_name_old_Balance);


					}


					if (rsmd.getColumnName(i).equals("BALANCE")) {
						col_balance = i;
						col_name_balance = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames    -->Col No " + col_balance + " Col Name :" + col_name_balance);


					}

				}

			} else if (tableName.equals("DRIVER_DETAIL")) {

				//System.out.println("If succeed Table Name====> " + tableName + "and ColCount is -->" + ColCount);

				for (int i = 1; i <= ColCount; i++) {

					//	System.out.println("colnames====> " + rsmd.getColumnName(i));

					if (rsmd.getColumnName(i).equals("ID")) {

						col_dd_ID = i;
						col_name_ID = rsmd.getColumnName(i);
						//	System.out.println("values From getLGABankColNames-->Col No " + col_ID + " Col Name :" + col_name_ID);
					}


					if (rsmd.getColumnName(i).equals("DRIVER_NAME")) {

						col_dd_driver_name = i;
						col_name_vehical_name = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames    -->Col No " + col_dd_driver_name + " Col Name :" + col_name_vehical_name);
					}
					if (rsmd.getColumnName(i).equals("ADDRESS")) {
						col_dd_address = i;
						col_name_fuel_type = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames    -->Col No " + col_dd_address + " Col Name :" + col_name_fuel_type);
					}
					if (rsmd.getColumnName(i).equals("CONTACT_NO")) {
						col_dd_contact = i;
						col_name_model = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames    -->Col No " + col_model + " Col Name :" + col_name_model);


					}


					if (rsmd.getColumnName(i).equals("AMOUNT_GIVEN")) {
						col_dd_amount = i;
						col_name_year = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames    -->Col No " + col_year + " Col Name :" + col_name_year);


					}
					if (rsmd.getColumnName(i).equals("REMARK")) {
						col_dd_remark = i;
						col_name_chasiID = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames    -->Col No " + col_chasiID + " Col Name :" + col_name_chasiID);


					}

					if (rsmd.getColumnName(i).equals("ENTRY_DATE")) {

						col_dd_entry_date = i;
						col_name_chasiID = rsmd.getColumnName(i);
						//System.out.println("values From getLGABankColNames    -->Col No " + col_dd_entry_date + " Col Name :" + col_name_chasiID);

					}


				}

			}
			else if (tableName.equals("CHECK_LICENSE"))
			{

//				System.out.println("If succeed Table Name====> " + tableName + "and ColCount is -->" + ColCount);

				for (int i = 1; i <= ColCount; i++) {

//					System.out.println("colnames====> " + rsmd.getColumnName(i));

					if (rsmd.getColumnName(i).equals("ID")) {

						col_chklic_ID = i;
//						System.out.println("values From getLGABankColNames-->Col No " + col_ID + " Col Name :" + col_name_ID);
					}


					if (rsmd.getColumnName(i).equals("LICENSE_OR_DEMO")) {

						col_chklic_lic_or_demo = i;
					}
					if (rsmd.getColumnName(i).equalsIgnoreCase("date_value")) {
						col_chklic_date = i;
					}
					if (rsmd.getColumnName(i).equalsIgnoreCase("p_key")) {
						col_chklic_pkey = i;

					}


					if (rsmd.getColumnName(i).equalsIgnoreCase("f_key")) {
						col_chklic_f_key = i;


					}


				}


			}

			else if (tableName.equals("VEHICAL_DETAIL")) {

				System.out.println("If succeed Table Name====> " + tableName + "and ColCount is -->" + ColCount);

				for (int i = 1; i <= ColCount; i++) {

					System.out.println("colnames====> " + rsmd.getColumnName(i));

					if (rsmd.getColumnName(i).equals("ID")) {

						col_vd_ID = i;
						col_name_ID = rsmd.getColumnName(i);
						System.out.println("values From getLGABankColNames-->Col No " + col_ID + " Col Name :" + col_name_ID);
					}


					if (rsmd.getColumnName(i).equals("VEHICAL_NAME")) {

						col_vd_vehical_name = i;
						col_name_vehical_name = rsmd.getColumnName(i);
						System.out.println("values From getLGABankColNames    -->Col No " + col_vd_vehical_name + " Col Name :" + col_name_vehical_name);
					}
					if (rsmd.getColumnName(i).equals("VEHICAL_NO")) {
						col_vd_vehical_no = i;
						col_name_fuel_type = rsmd.getColumnName(i);
						System.out.println("values From getLGABankColNames    -->Col No " + col_fuel_type + " Col Name :" + col_name_fuel_type);
					}
					if (rsmd.getColumnName(i).equals("VEHICAL_MODEL")) {
						col_vd_vehical_model = i;
						col_name_model = rsmd.getColumnName(i);
						System.out.println("values From getLGABankColNames    -->Col No " + col_model + " Col Name :" + col_name_model);


					}


					if (rsmd.getColumnName(i).equals("VEHICAL_CHASIS")) {
						col_vd_vehical_chasis = i;
						col_name_year = rsmd.getColumnName(i);
						System.out.println("values From getLGABankColNames    -->Col No " + col_year + " Col Name :" + col_name_year);


					}
					if (rsmd.getColumnName(i).equals("REMARK")) {
						col_vd_remark = i;
						col_name_chasiID = rsmd.getColumnName(i);
						System.out.println("values From getLGABankColNames    -->Col No " + col_chasiID + " Col Name :" + col_name_chasiID);


					}

					if (rsmd.getColumnName(i).equals("ENTRY_DATE")) {

						col_vd_entry_date = i;
						col_name_chasiID = rsmd.getColumnName(i);
						System.out.println("values From getLGABankColNames    -->Col No " + col_dd_entry_date + " Col Name :" + col_name_chasiID);

					}


				}


			} else if (tableName.equals("MATERIAL_DETAIL")) {

//				System.out.println("If succeed Table Name====> " + tableName + "and ColCount is -->" + ColCount);

				for (int i = 1; i <= ColCount; i++) {

					System.out.println("colnames====> " + rsmd.getColumnName(i));

					if (rsmd.getColumnName(i).equals("ID")) {

						col_md_ID = i;
						col_name_ID = rsmd.getColumnName(i);
//						System.out.println("values From getLGABankColNames-->Col No " + col_ID + " Col Name :" + col_name_ID);
					}


					if (rsmd.getColumnName(i).equals("MATERIAL_NAME")) {

						col_md_material_name = i;
						col_name_vehical_name = rsmd.getColumnName(i);
//						System.out.println("values From getLGABankColNames    -->Col No " + col_md_material_name + " Col Name :" + col_name_vehical_name);
					}
					if (rsmd.getColumnName(i).equals("MATERIAL_SIZE")) {

						col_md_material_size = i;
						col_name_material_size = rsmd.getColumnName(i);
//						System.out.println("values From getLGABankColNames    -->Col No " + col_md_material_size + " Col Name :" + col_name_material_size);
					}

					if (rsmd.getColumnName(i).equals("MATERIAL_QTY")) {
						col_md_material_qty = i;
						col_name_fuel_type = rsmd.getColumnName(i);
						System.out.println("values From getLGABankColNames    -->Col No " + col_fuel_type + " Col Name :" + col_name_fuel_type);
					}
					if (rsmd.getColumnName(i).equals("MATERIAL_PRICE")) {
						col_md_material_price = i;
						col_name_model = rsmd.getColumnName(i);
						System.out.println("values From getLGABankColNames    -->Col No " + col_model + " Col Name :" + col_name_model);


					}


					if (rsmd.getColumnName(i).equals("REMARK")) {
						col_md_remark = i;
						col_name_chasiID = rsmd.getColumnName(i);
						System.out.println("values From getLGABankColNames    -->Col No " + col_chasiID + " Col Name :" + col_name_chasiID);


					}

					if (rsmd.getColumnName(i).equals("ENTRY_DATE")) {

						col_md_entry_date = i;
						col_name_chasiID = rsmd.getColumnName(i);
						System.out.println("values From getLGABankColNames    -->Col No " + col_dd_entry_date + " Col Name :" + col_name_chasiID);

					}


				}


			}
            else if(tableName.equalsIgnoreCase("org_detail"))

            {

                System.out.println("If succeed Table Name====> " + tableName + "and ColCount is -->" + ColCount);

                for (int i = 1; i <= ColCount; i++) {

                    System.out.println("colnames====> " + rsmd.getColumnName(i));

                    if (rsmd.getColumnName(i).equals("ID")) {

                        col_org_ID = i;
                    }


                    if (rsmd.getColumnName(i).equals("OrgName")) {

                        col_org_name = i;
                    }
                    if (rsmd.getColumnName(i).equals("tophead")) {

                        col_org_tophead = i;
                    }
                    if (rsmd.getColumnName(i).equals("authorised_person")) {

                        col_org_auth_person = i;
                    }

                }


            }
			//SIMPLE_BUYER_DETAIL , simple_order_detail , simple_gst_detail ,simple_goods_detail

			else if(tableName.equalsIgnoreCase("SIMPLE_GST_DETAIL"))
			{

				System.out.println("If succeed Table Name====> " + tableName + "and ColCount is -->" + ColCount);

				for (int i = 1; i <= ColCount; i++) {

					System.out.println("colnames====> " + rsmd.getColumnName(i));

					if (rsmd.getColumnName(i).equals("ID")) {

						col_simgst_ID = i;
					}


					if (rsmd.getColumnName(i).equals("GST_TYPE")) {

						col_simgst_type_name = i;
					}
					if (rsmd.getColumnName(i).equals("GST_RATE")) {

						col_simgst_rate = i;
					}


				}


			}

			else if(tableName.equalsIgnoreCase("GST_DETAIL"))
			{

				System.out.println("If succeed Table Name====> " + tableName + "and ColCount is -->" + ColCount);

				for (int i = 1; i <= ColCount; i++) {

					System.out.println("colnames====> " + rsmd.getColumnName(i));

					if (rsmd.getColumnName(i).equals("ID")) {

						col_gst_ID = i;
					}


					if (rsmd.getColumnName(i).equals("GST_TYPE")) {

						col_gst_type_name = i;
					}
					if (rsmd.getColumnName(i).equals("GST_RATE")) {

						col_gst_rate = i;
					}


				}


			}
			else if (tableName.equalsIgnoreCase("GOODS_NAMES")) {

//				System.out.println("If succeed Table Name====> " + tableName + "and ColCount is -->" + ColCount);

				for (int i = 1; i <= ColCount; i++) {

					System.out.println("colnames====> " + rsmd.getColumnName(i));

					if (rsmd.getColumnName(i).equals("ID")) {

						col_gds_ID = i;
					}


					if (rsmd.getColumnName(i).equals("DESCRIPTION_OF_GOODS")) {

						col_gds_name = i;
					}
					if (rsmd.getColumnName(i).equals("STATUS")) {

						col_gds_status = i;
					}
				}
			}
			else if (tableName.equals("GOODS_DETAIL"))
			{}
			else if (tableName.equals("BUYER_DETAIL")) {

//				System.out.println("If succeed Table Name====> " + tableName + "and ColCount is -->" + ColCount);

				for (int i = 1; i <= ColCount; i++) {

					System.out.println("colnames====> " + rsmd.getColumnName(i));

					if (rsmd.getColumnName(i).equals("ID")) {

						col_bd_ID = i;
						col_name_ID = rsmd.getColumnName(i);
//						System.out.println("values From getLGABankColNames-->Col No " + col_bd_ID + " Col Name :" + col_name_ID);
					}


					if (rsmd.getColumnName(i).equals("BUYER_NAME")) {

						col_bd_buyer_name = i;
//						System.out.println("values From getLGABankColNames    -->Col No " + col_bd_buyer_name + " Col Name :" + col_name_vehical_name);
					}
					if (rsmd.getColumnName(i).equals("PHONE_NO")) {
						col_bd_phone_no = i;
//						System.out.println("values From getLGABankColNames    -->Col No " + col_bd_phone_no + " Col Name :" + col_name_fuel_type);
					}
					if (rsmd.getColumnName(i).equals("ADDRESS")) {
						col_bd_address = i;
//						System.out.println("values From getLGABankColNames    -->Col No " + col_bd_address + " Col Name :" + col_name_model);


					}


					if (rsmd.getColumnName(i).equals("REMARK")) {
						col_bd_remark = i;
//						System.out.println("values From getLGABankColNames    -->Col No " + col_bd_remark + " Col Name :" + col_name_chasiID);


					}

					if (rsmd.getColumnName(i).equals("ENTRY_DATE")) {

						col_bd_entry_date = i;
//						System.out.println("values From getLGABankColNames    -->Col No " + col_bd_entry_date + " Col Name :" + col_name_chasiID);

					}


				}


			}
			else if (tableName.equals("SIMPLE_BUYER_DETAIL")) {

//				System.out.println("If succeed Table Name====> " + tableName + "and ColCount is -->" + ColCount);

				for (int i = 1; i <= ColCount; i++) {

					System.out.println("colnames====> " + rsmd.getColumnName(i));

					if (rsmd.getColumnName(i).equals("ID")) {

						col_simbd_ID = i;
						col_name_ID = rsmd.getColumnName(i);
//						System.out.println("values From getLGABankColNames-->Col No " + col_bd_ID + " Col Name :" + col_name_ID);
					}


					if (rsmd.getColumnName(i).equals("BUYER_NAME")) {

						col_simbd_buyer_name = i;
//						System.out.println("values From getLGABankColNames    -->Col No " + col_bd_buyer_name + " Col Name :" + col_name_vehical_name);
					}
					if (rsmd.getColumnName(i).equals("PHONE_NO")) {
						col_simbd_phone_no = i;
//						System.out.println("values From getLGABankColNames    -->Col No " + col_bd_phone_no + " Col Name :" + col_name_fuel_type);
					}
					if (rsmd.getColumnName(i).equals("ADDRESS")) {
						col_simbd_address = i;
//						System.out.println("values From getLGABankColNames    -->Col No " + col_bd_address + " Col Name :" + col_name_model);


					}


					if (rsmd.getColumnName(i).equals("REMARK")) {
						col_simbd_remark = i;
//						System.out.println("values From getLGABankColNames    -->Col No " + col_bd_remark + " Col Name :" + col_name_chasiID);


					}

					if (rsmd.getColumnName(i).equals("ENTRY_DATE")) {

						col_simbd_entry_date = i;
//						System.out.println("values From getLGABankColNames    -->Col No " + col_bd_entry_date + " Col Name :" + col_name_chasiID);

					}


				}


			}
			else if (tableName.equals("PARTY_DETAIL")) {

//				System.out.println("If succeed Table Name====> " + tableName + "and ColCount is -->" + ColCount);

				for (int i = 1; i <= ColCount; i++) {

					System.out.println("colnames====> " + rsmd.getColumnName(i));

					if (rsmd.getColumnName(i).equals("ID")) {

						col_pd_ID = i;
//						System.out.println("values From getLGABankColNames-->Col No " + col_bd_ID + " Col Name :" + col_name_ID);
					}


					if (rsmd.getColumnName(i).equals("BUYER_NAME")) {

                        col_pd_buyer_name = i;
//						System.out.println("values From getLGABankColNames    -->Col No " + col_bd_buyer_name + " Col Name :" + col_name_vehical_name);
					}
					if (rsmd.getColumnName(i).equals("PHONE_NO")) {
                        col_pd_phone_no = i;
//						System.out.println("values From getLGABankColNames    -->Col No " + col_bd_phone_no + " Col Name :" + col_name_fuel_type);
					}
					if (rsmd.getColumnName(i).equals("GST_NO")) {
                        col_pd_gst_no= i;
//						System.out.println("values From getLGABankColNames    -->Col No " + col_bd_phone_no + " Col Name :" + col_name_fuel_type);
					}
					if (rsmd.getColumnName(i).equals("ADDRESS")) {
                        col_pd_address = i;
//						System.out.println("values From getLGABankColNames    -->Col No " + col_bd_address + " Col Name :" + col_name_model);


					}


					if (rsmd.getColumnName(i).equals("REMARK")) {
                        col_pd_remark = i;
//						System.out.println("values From getLGABankColNames    -->Col No " + col_bd_remark + " Col Name :" + col_name_chasiID);


					}

					if (rsmd.getColumnName(i).equals("ENTRY_DATE")) {

                        col_pd_entry_date = i;
//						System.out.println("values From getLGABankColNames    -->Col No " + col_bd_entry_date + " Col Name :" + col_name_chasiID);

					}


				}

			}
			else if(tableName.equals("TRANSPORT_DETAIL"))
			{

//				System.out.println("If succeed Table Name====> " + tableName + "and ColCount is -->" + ColCount);

				for (int i = 1; i <= ColCount; i++) {


					System.out.println("colnames====> " + rsmd.getColumnName(i));

					if (rsmd.getColumnName(i).equals("ID")) {

						col_trans_ID = i;
					}
//transportName, lrNo, bankName, bankAccNo, ifscCode, agent, totalDagina

					if (rsmd.getColumnName(i).equals("TRANSPORT_NAME")) {

						col_trans_name = i;
					}
					if (rsmd.getColumnName(i).equals("LR_NO")) {
						col_trans_lr_no = i;
					}
					if (rsmd.getColumnName(i).equals("BANK_NAME")) {
						col_trans_bnk_name = i;
					}
					if (rsmd.getColumnName(i).equals("BANK_ACC_NO")) {
						col_trans_bnk_acc_no = i;
					}
					if (rsmd.getColumnName(i).equals("IFSC_CODE")) {
						col_trans_ifsc_code = i;
					}
					if (rsmd.getColumnName(i).equals("AGENT")) {
						col_trans_agent = i;
					}
					if (rsmd.getColumnName(i).equals("TOTAL_DAGINA")) {
						col_trans_tot_dagina = i;
					}


/*
					if (rsmd.getColumnName(i).equals("REMARK")) {
						col_bd_remark = i;
						col_name_chasiID = rsmd.getColumnName(i);
						System.out.println("values From getLGABankColNames    -->Col No " + col_bd_remark + " Col Name :" + col_name_chasiID);


					}
*/



				}


			}
			else if(tableName.equals("QUOTATION_DETAIL"))
			{

//				System.out.println("If succeed Table Name====> " + tableName + "and ColCount is -->" + ColCount);

				for (int i = 1; i <= ColCount; i++) {

//					System.out.println("colnames====> " + rsmd.getColumnName(i));

					if (rsmd.getColumnName(i).equals("ID")) {

						col_quod_ID = i;
					}


					if (rsmd.getColumnName(i).equals("QUOTATION_NAME")) {

						col_quod_quo_name = i;
					}
					if (rsmd.getColumnName(i).equals("GST_NO")) {
						col_quod_gst_no = i;
					}
					if (rsmd.getColumnName(i).equals("BNKACC_NO")) {
						col_quod_bnkacc_no = i;
					}
					if (rsmd.getColumnName(i).equals("TERMS_COND1")) {
						col_quod_terms_cond1 = i;
					}
					if (rsmd.getColumnName(i).equals("TERMS_COND2")) {
						col_quod_terms_cond2 = i;
					}
					if (rsmd.getColumnName(i).equals("TERMS_COND3")) {
						col_quod_terms_cond3 = i;
					}

/*
					if (rsmd.getColumnName(i).equals("REMARK")) {
						col_bd_remark = i;
						col_name_chasiID = rsmd.getColumnName(i);
						System.out.println("values From getLGABankColNames    -->Col No " + col_bd_remark + " Col Name :" + col_name_chasiID);


					}
*/



				}


			}

		} catch (Exception ex) {
			System.out.println("Error from getLGABankColNames : " + ex);
		}


	}


	/* void getLGAPurchaseColNames(ResultSetMetaData rsmd,int ColCount)
				{

               				 try
               					 {


                                                     System.out.println("values From getLGAPurchaseColNames-->ColCount "+ColCount);

                 				for(int i=1;i<=ColCount;i++)
                 					{
					        	if(rsmd.getColumnName(i).equals("ID"))
								{

								colNoID=i;
								colNameCyl_ID=rsmd.getColumnName(i);
				System.out.println("values From getLGAPurchaseColNames-->Col No "+colNoID+" Col Name :"+colNameCyl_ID);
								}

        			System.out.println("values From getLGAPurchaseColNames-->for loop i "+i+" Col Name -->"+rsmd.getColumnName(i));

                                                        if(rsmd.getColumnName(i).equals("CYL_CATEGORY"))
								{

								colNoCyl_Category=i;
								colNameCyl_Category=rsmd.getColumnName(i);
				System.out.println("values From getLGAPurchaseColNames    -->Col No "+colNoCyl_Category+" Col Name :"+colNameCyl_Category);
								}
							if(rsmd.getColumnName(i).equals("CYL_RATE"))
								{


								colNoCyl_Rate=i;
								colNameCyl_Rate=rsmd.getColumnName(i);
				System.out.println("values From getLGAPurchaseColNames    -->Col No "+colNoCyl_Rate+" Col Name :"+colNameCyl_Rate);



								}
							if(rsmd.getColumnName(i).equals("CYL_QTY"))
								{

								colNoCyl_Qty=i;
								colNameCyl_Qty=rsmd.getColumnName(i);
				System.out.println("values From getLGAPurchaseColNames    -->Col No "+colNoCyl_Qty+" Col Name :"+colNameCyl_Qty);


								}
							if(rsmd.getColumnName(i).equals("TOTAL_AMOUNT"))
								{
								colNoTotal_Amount=i;
								colNameTotal_Amount=rsmd.getColumnName(i);
				System.out.println("values From getLGAPurchaseColNames    -->Col No "+colNoTotal_Amount+" Col Name :"+colNameTotal_Amount);


								}
							if(rsmd.getColumnName(i).equals("OLD_TOTAL_AMOUNT"))
								{
								colNoOldTotal_Amount=i;
								colNameOldTotal_Amount=rsmd.getColumnName(i);
				System.out.println("values From getLGAPurchaseColNames    -->Col No "+colNoOldTotal_Amount+" Col Name :"+colNameOldTotal_Amount);

								}
							if(rsmd.getColumnName(i).equals("PURCHASE_DATE"))
								{

								colNoPurchase_Date=i;
								colNamePurchase_Date=rsmd.getColumnName(i);
				System.out.println("values From getLGAPurchaseColNames    -->Col No "+colNoTotal_Amount+" Col Name :"+colNameTotal_Amount);


								}

                 					}

                				}
                 				catch(Exception ex){System.out.println("Error from getLGAPurchaseColNames : "+ex);}



				}

		*/
	void getLGASalesColNames(ResultSetMetaData rsmd, int ColCount) {

		try {

			for (int i = 1; i <= ColCount; i++) {
//System.out.println("values From getLGASalesColNames-->Col No "+i+" <----is ---->"+rsmd.getColumnName(i));


				if (rsmd.getColumnName(i).equals("ID")) {

					colNoSale_ID = i;
					colNameSale_ID = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesColNames-->Col No " + colNoSale_ID + " Col Name :" + colNameSale_ID);
				}
				if (rsmd.getColumnName(i).equals("ID")) {

					colNoSaleID = i;
					colNameSale_ID = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesColNames-->Col No " + colNoSaleID + " Col Name :" + colNameSale_ID);
				}

				if (rsmd.getColumnName(i).equals("STAFF_ID")) {

					colNoSaleStaffID = i;
					colNameSale_StaffID = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesColNames-->Col No " + colNoSaleStaffID + " Col Name :" + colNameSale_StaffID);
				}

				if (rsmd.getColumnName(i).equals("STAFF_NAME")) {

					colNoSaleStaff_Name = i;
					colNameSaleStaff_Name = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesColNames    -->Col No " + colNoSaleStaff_Name + " Col Name :" + colNameSaleStaff_Name);
				}
				if (rsmd.getColumnName(i).equals("VEHICAL_AVAILABLE")) {


					colNoSaleAvailVehicalCount = i;
					colNameSaleAvailVehicalCount = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesColNames    -->Col No " + colNoSaleAvailVehicalCount + " Col Name :" + colNameSaleAvailVehicalCount);


				}
				if (rsmd.getColumnName(i).equals("VEHICAL_SELL")) {

					colNoSaleVehSellCount = i;
					colNameSaleVehSellCount = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesColNames    -->Col No " + colNoSaleVehSellCount + " Col Name :" + colNameSaleVehSellCount);


				}
				if (rsmd.getColumnName(i).equals("BALANCE_VEHICAL")) {

					colNoSaleBalance_Vehical = i;
					colNameSaleBalance_Vehical = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesColNames    -->Col No " + colNoSaleBalance_Vehical + " Col Name :" + colNameSaleBalance_Vehical);


				}
				if (rsmd.getColumnName(i).equals("GIVEN_AMT")) {

					colNoSaleGiven_Amt = i;
					colNameSaleGiven_Amt = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesColNames    -->Col No " + colNoSaleGiven_Amt + " Col Name :" + colNameSaleGiven_Amt);


				}
				if (rsmd.getColumnName(i).equals("CASH_CHEQUE")) {

					colNoSaleCash_Cheque = i;
					colNameSaleCash_Cheque = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesColNames    -->Col No " + colNoSaleCash_Cheque + " Col Name :" + colNameSaleCash_Cheque);

				}

				if (rsmd.getColumnName(i).equals("CHEQUE_ID")) {

					colNoSaleCheque_ID = i;
					colNameSaleCheque_ID = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesColNames    -->Col No " + colNoSaleCheque_ID + " Col Name :" + colNameSaleCheque_ID);


				}
				if (rsmd.getColumnName(i).equals("REMARKS")) {

					colNoSaleRemarks = i;
					colNameSaleRemarks = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesColNames    -->Col No " + colNoSaleRemarks + " Col Name :" + colNameSaleRemarks);


				}
				if (rsmd.getColumnName(i).equals("TOTAL_AMT")) {

					colNoSaleTotal_Amt = i;
					colNameSaleTotal_Amt = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesColNames    -->Col No " + colNoSaleTotal_Amt + " Col Name :" + colNameSaleTotal_Amt);


				}
				if (rsmd.getColumnName(i).equals("BALANCE_AMT")) {

					colNoSaleBalance_Amt = i;
					colNameSaleBalance_Amt = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesColNames    -->Col No " + colNoSaleBalance_Amt + " Col Name :" + colNameSaleBalance_Amt);


				}
				if (rsmd.getColumnName(i).equals("VEHICAL_CATEGORY")) {

					colNoSaleVehical_Category = i;
					colNameSaleVehical_Category = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesColNames    -->Col No " + colNoSaleVehical_Category + " Col Name :" + colNameSaleVehical_Category);


				}
				if (rsmd.getColumnName(i).equals("SALE_DATE")) {

					colNoSale_Date = i;
					colNameSale_Date = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesColNames    -->Col No " + colNoSale_Date + " Col Name :" + colNameSale_Date);


				}

				if (rsmd.getColumnName(i).equals("MODEL")) {

					colNoSaleModel = i;
					colNameSaleModel = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesColNames    -->Col No " + colNoSaleModel + " Col Name :" + colNameSaleModel);


				}
				if (rsmd.getColumnName(i).equals("CHASIID")) {

					colNoSaleChesiID = i;
					colNameSaleChesiID = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesColNames    -->Col No " + colNoSaleChesiID + " Col Name :" + colNameSaleChesiID);


				}
				if (rsmd.getColumnName(i).equals("ENGINE_NO")) {

					colNoSaleEngine_No = i;
					colNameSaleEngine_No = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesColNames    -->Col No " + colNoSaleEngine_No + " Col Name :" + colNameSaleEngine_No);


				}
				if (rsmd.getColumnName(i).equals("COLOR")) {

					colNoSaleColor = i;
					colNameSaleColor = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesColNames    -->Col No " + colNoSaleColor + " Col Name :" + colNameSaleColor);


				}
				if (rsmd.getColumnName(i).equals("KEY")) {

					colNoSaleKey = i;
					colNameSaleKey = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesColNames    -->Col No " + colNoSaleKey + " Col Name :" + colNameSaleKey);


				}

				if (rsmd.getColumnName(i).equals("INVOICE_NO")) {

					colNoSaleInvoiceNo = i;
					colNameSaleInvoiceNo = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesColNames    -->Col No " + colNoSaleInvoiceNo + " Col Name :" + colNameSaleInvoiceNo);


				}


				if (rsmd.getColumnName(i).equals("CUSTOMER_NAME")) {

					colNoSaleCustomerName = i;
					colNameSaleCustomerName = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesColNames    -->Col No " + colNoSaleCustomerName + " Col Name :" + colNameSaleCustomerName);


				}

				if (rsmd.getColumnName(i).equals("DISCOUNT")) {

					colNoSaleDiscountValue = i;
					colNameSalediscountValue = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesColNames    -->Col No " + colNoSaleDiscountValue + " Col Name :" + colNameSalediscountValue);


				}

                        /*	----------------------------------------------------------
                                                        if(rsmd.getColumnName(i).equals("ID"))
								{
                                                                int val = i;
								colNoSale_ID=++val;
								colNameSale_ID=rsmd.getColumnName(i);
				System.out.println("values From getLGASalesColNames-->Col No "+colNoSaleID+" Col Name :"+colNameSale_ID);
								}
					        	if(rsmd.getColumnName(i).equals("ID"))
								{
                                                                int val = i;
								colNoSaleID=++val;
								colNameSale_ID=rsmd.getColumnName(i);
				System.out.println("values From getLGASalesColNames-->Col No "+colNoSaleID+" Col Name :"+colNameSale_ID);
								}

                                                        	if(rsmd.getColumnName(i).equals("STAFF_ID"))
								{
                                                                int val = i;
								colNoSaleStaffID=++val;
								colNameSale_StaffID=rsmd.getColumnName(i);
				System.out.println("values From getLGASalesColNames-->Col No "+colNoSaleID+" Col Name :"+colNameSale_ID);
								}

                                                        if(rsmd.getColumnName(i).equals("STAFF_NAME"))
								{
                                                                int val = i;
								colNoSaleStaff_Name=++val;
								colNameSaleStaff_Name=rsmd.getColumnName(i);
				System.out.println("values From getLGASalesColNames    -->Col No "+colNoSaleStaff_Name+" Col Name :"+colNameSaleStaff_Name);
								}
							if(rsmd.getColumnName(i).equals("VEHICAL_AVAILABLE"))
								{
								int val = i;

								colNoSaleAvailVehicalCount=++val;
								colNameSaleAvailVehicalCount=rsmd.getColumnName(i);
				System.out.println("values From getLGASalesColNames    -->Col No "+colNoSaleAvailVehicalCount+" Col Name :"+colNameSaleAvailVehicalCount);



								}
							if(rsmd.getColumnName(i).equals("VEHICAL_SELL"))
								{
									int val = i;
								colNoSaleVehSellCount=++val;
								colNameSaleVehSellCount=rsmd.getColumnName(i);
				System.out.println("values From getLGASalesColNames    -->Col No "+colNoSaleVehSellCount+" Col Name :"+colNameSaleVehSellCount);


								}
							if(rsmd.getColumnName(i).equals("BALANCE_VEHICAL"))
								{
									int val = i;
								colNoSaleBalance_Vehical=++val;
								colNameSaleBalance_Vehical=rsmd.getColumnName(i);
				System.out.println("values From getLGASalesColNames    -->Col No "+colNoSaleBalance_Cyl+" Col Name :"+colNameSaleBalance_Cyl);


								}
							if(rsmd.getColumnName(i).equals("GIVEN_AMT"))
								{
									int val = i;
								colNoSaleGiven_Amt=++val;
								colNameSaleGiven_Amt=rsmd.getColumnName(i);
				System.out.println("values From getLGASalesColNames    -->Col No "+colNoSaleGiven_Amt+" Col Name :"+colNameSaleGiven_Amt);


								}
							if(rsmd.getColumnName(i).equals("CASH_CHEQUE"))
								{
									int val = i;
								colNoSaleCash_Cheque=++val;
								colNameSaleCash_Cheque=rsmd.getColumnName(i);
				System.out.println("values From getLGASalesColNames   -->Col No "+colNoSaleCash_Cheque+" Col Name :"+colNameSaleCash_Cheque);

								}

                                                        if(rsmd.getColumnName(i).equals("CHEQUE_ID"))
								{
									int val = i;
								colNoSaleCheque_ID=++val;
								colNameSaleCheque_ID=rsmd.getColumnName(i);
				System.out.println("values From getLGASalesColNames    -->Col No "+colNoSaleCheque_Amt+" Col Name :"+colNameSaleCheque_Amt);


								}
							if(rsmd.getColumnName(i).equals("REMARKS"))
								{
									int val = i;
								colNoSaleRemarks=++val;
								colNameSaleRemarks=rsmd.getColumnName(i);
				System.out.println("values From getLGASalesColNames    -->Col No "+colNoSaleRemarks+" Col Name :"+colNameSaleRemarks);


								}
							if(rsmd.getColumnName(i).equals("TOTAL_AMT"))
								{
									int val = i;
								colNoSaleTotal_Amt=++val;
								colNameSaleTotal_Amt=rsmd.getColumnName(i);
				System.out.println("values From getLGASalesColNames    -->Col No "+colNoSaleTotal_Amt+" Col Name :"+colNameSaleTotal_Amt);


								}
							if(rsmd.getColumnName(i).equals("BALANCE_AMT"))
								{
									int val = i;
								colNoSaleBalance_Amt=++val;
								colNameSaleBalance_Amt=rsmd.getColumnName(i);
				System.out.println("values From getLGASalesColNames    -->Col No "+colNoSaleBalance_Amt+" Col Name :"+colNameSaleBalance_Amt);


								}
							if(rsmd.getColumnName(i).equals("VEHICAL_CATEGORY"))
								{
									int val = i;
								colNoSaleVehical_Category=++val;
								colNameSaleVehical_Category=rsmd.getColumnName(i);
				System.out.println("values From getLGASalesColNames    -->Col No "+colNoSaleVehical_Category+" Col Name :"+colNameSaleVehical_Category);


								}
							if(rsmd.getColumnName(i).equals("SALE_DATE"))
								{
									int val = i;
								colNoSale_Date=++val;
								colNameSale_Date=rsmd.getColumnName(i);
				System.out.println("values From getLGASalesColNames    -->Col No "+colNoSale_Date+" Col Name :"+colNameSale_Date);


								}


                                                        }*/

			}

		} catch (Exception ex) {
			System.out.println("Error from getLGASalesColNames : " + ex);
		}


	}


	void getLGASalesReportColNames(ResultSetMetaData rsmd, int ColCount) {


		try {

			for (int i = 1; i <= ColCount; i++) {
				if (rsmd.getColumnName(i).equals("ID")) {

					colNoSaleReportID = i;
					colNameSaleReport_ID = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesReportColNames-->Col No " + colNoSaleReportID + " Col Name :" + colNameSaleReport_ID);
				}

				if (rsmd.getColumnName(i).equals("Cyl_Category")) {

					colNoSaleReportCyl_Category = i;
					colNameSaleReportCyl_Category = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesReportColNames    -->Col No " + colNoSaleReportCyl_Category + " Col Name :" + colNameSaleReportCyl_Category);
				}
				if (rsmd.getColumnName(i).equals("Cyl_Fill_Start_Qty")) {


					colNoSaleReportCyl_Fill_Start_Qty = i;
					colNameSaleReportCyl_Fill_Start_Qty = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesReportColNames    -->Col No " + colNoSaleReportCyl_Fill_Start_Qty + " Col Name :" + colNameSaleReportCyl_Fill_Start_Qty);


				}
				if (rsmd.getColumnName(i).equals("Cyl_Fill_Current_Qty")) {

					colNoSaleReportCyl_Fill_Current_Qty = i;
					colNameSaleReportCyl_Fill_Current_Qty = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesReportColNames    -->Col No " + colNoSaleReportCyl_Fill_Current_Qty + " Col Name :" + colNameSaleReportCyl_Fill_Current_Qty);


				}
				if (rsmd.getColumnName(i).equals("Cyl_Empty_Total_Balance")) {

					colNoSaleReportCyl_Empty_Total_Balance = i;
					colNameSaleReportCyl_Empty_Total_Balance = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesReportColNames    -->Col No " + colNoSaleReportCyl_Empty_Total_Balance + " Col Name :" + colNameSaleReportCyl_Empty_Total_Balance);


				}

				if (rsmd.getColumnName(i).equals("Total_Cash")) {

					colNoSaleReportTotal_Cash = i;
					colNameSaleReportTotal_Cash = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesReportColNames    -->Col No " + colNoSaleReportTotal_Cash + " Col Name :" + colNameSaleReportTotal_Cash);


				}

				if (rsmd.getColumnName(i).equals("Current_Balance_Amount")) {

					colNoSaleReportCurrent_Balance_Amount = i;
					colNameSaleReportCurrent_Balance_Amount = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesReportColNames    -->Col No " + colNoSaleReportCurrent_Balance_Amount + " Col Name :" + colNameSaleReportCurrent_Balance_Amount);


				}
				if (rsmd.getColumnName(i).equals("Total_Amount")) {

					colNoSaleReportTotal_Amount = i;
					colNameSaleReportTotal_Amount = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesReportColNames    -->Col No " + colNoSaleReportTotal_Amount + " Col Name :" + colNameSaleReportTotal_Amount);


				}
				if (rsmd.getColumnName(i).equals("T_Date")) {

					colNoSaleReportT_Date = i;
					colNameSaleReportT_Date = rsmd.getColumnName(i);
					System.out.println("values From getLGASalesReportColNames    -->Col No " + colNoSaleReportT_Date + " Col Name :" + colNameSaleReportT_Date);


				}

			}

		} catch (Exception ex) {
			System.out.println("Error from getLGASalesReportColNames : " + ex);
		}


	}


	String genLGAStaffUniId(Connection conobj, String tableName, String strSimpleOrderId) {
		String unid = "";

		String ColName = "OrgName", matchCol = "ID", TableName = "org_detail";
		int matchValue = 1;

		//String lgaName = getColData(conobj, ColName, matchCol, matchValue, TableName);
		try {
			String orgName = "ord";

			if(strSimpleOrderId.length()>0) {


			int ordIdVal=	Integer.parseInt(strSimpleOrderId);

			        if(ordIdVal>0 && ordIdVal<=9)
					{
						unid = orgName + "/" +"0"+strSimpleOrderId;

					}else if(ordIdVal>0)
					{
						unid = orgName + "/" + strSimpleOrderId;

					}
					else
					{
						JOptionPane.showMessageDialog(null, "Order Number must be greater than 0", "Simple Order", 1);


						return "NoOrd" ;


					}

				System.out.println("Generating ID--->" + unid);

				Statement stat = conobj.createStatement();


				//String qury="SELECT max(CAST(SUBSTR(ORDER_ID,LOCATE('/',ORDER_ID)+1))AS INT) FROM " + tableName;
				String qury = "SELECT * FROM " +tableName+" where ORDER_ID='"+unid+"'";
				ResultSet result = stat.executeQuery(qury);
				if (result.next()) {


					JOptionPane.showMessageDialog(null, "Same Order Number Exist, Order Not Generated!!!", "Simple Order", 1);


					return "NoOrd" ;
				}





			}
			else
			{



				Statement stat = conobj.createStatement();


				//String qury="SELECT max(CAST(SUBSTR(ORDER_ID,LOCATE('/',ORDER_ID)+1))AS INT) FROM " + tableName;
				String qury = "SELECT MAX(DISTINCT ORDER_ID) FROM " + tableName;
				ResultSet result = stat.executeQuery(qury);
				if (result.next()) {

					String idValue = result.getString(1);
					System.out.println("from genLGAStaffUniId last idValue--->" + idValue);

					if (idValue != null) {

						if (idValue.contains("/")) {

							String[] vals = idValue.split("/");
							int val = Integer.parseInt(vals[1]);
							unid = orgName + "/" + (++val);
						}
					} else {

						unid = orgName + "/" + (++genSimpleOrdId);


					}

					//unid = orgName + "/" + (++idValue);


					System.out.println("Generated ID--->" + unid);


				} else {

					JOptionPane.showMessageDialog(null, "No Order id  found", "Error", 1);


				}


			}

		} catch (Exception ex) {
			System.out.println("From genSimpleOrderUniId-->" + ex);

		}


		return unid;


	}
	String genReceiptUniId(Connection conobj, String tableName, String strSimpleOrderId) {
		String unid = "";

		String ColName = "OrgName", matchCol = "ID", TableName = "org_detail";
		int matchValue = 1;

		//String lgaName = getColData(conobj, ColName, matchCol, matchValue, TableName);
		try {
			String orgName = "ord";

			if(strSimpleOrderId.length()>0) {

				unid = strSimpleOrderId;

				System.out.println("Generating ID--->" + unid);

				Statement stat = conobj.createStatement();


				//String qury="SELECT max(CAST(SUBSTR(ORDER_ID,LOCATE('/',ORDER_ID)+1))AS INT) FROM " + tableName;
				String qury = "SELECT * FROM " +tableName+" where ORDER_ID='"+unid+"'";
				ResultSet result = stat.executeQuery(qury);
				if (result.next()) {


					JOptionPane.showMessageDialog(null, "Same Number Exist, Receipt Not Generated!!!", "Simple Order", 1);


					return "NoOrd" ;
				}





			}
			else
			{

			}

		} catch (Exception ex) {
			System.out.println("From genSimpleOrderUniId-->" + ex);

		}


		return unid;


	}

	String genSimpleOrderUniId(Connection conobj, String tableName, String strSimpleOrderId) {
		String unid = "";

		String ColName = "OrgName", matchCol = "ID", TableName = "org_detail";
		int matchValue = 1;

		//String lgaName = getColData(conobj, ColName, matchCol, matchValue, TableName);
		try {
			String orgName = "simple";

			if(strSimpleOrderId.length()>0) {

				unid = orgName + "/" + strSimpleOrderId;

				System.out.println("Generating ID--->" + unid);

				Statement stat = conobj.createStatement();


				//String qury="SELECT max(CAST(SUBSTR(ORDER_ID,LOCATE('/',ORDER_ID)+1))AS INT) FROM " + tableName;
				String qury = "SELECT * FROM " +tableName+" where ORDER_ID='"+unid+"'";
				ResultSet result = stat.executeQuery(qury);
				if (result.next()) {


					JOptionPane.showMessageDialog(null, "Same Order Number Exist, Order Not Generated!!!", "Simple Order", 1);


					return "NoOrd" ;
				}





				}
			else
			{



				Statement stat = conobj.createStatement();


				//String qury="SELECT max(CAST(SUBSTR(ORDER_ID,LOCATE('/',ORDER_ID)+1))AS INT) FROM " + tableName;
				String qury = "SELECT MAX(DISTINCT ORDER_ID) FROM " + tableName;
				ResultSet result = stat.executeQuery(qury);
				if (result.next()) {

					String idValue = result.getString(1);
					System.out.println("from genLGAStaffUniId last idValue--->" + idValue);

					if (idValue != null) {

						if (idValue.contains("/")) {

							String[] vals = idValue.split("/");
							int val = Integer.parseInt(vals[1]);
							unid = orgName + "/" + (++val);
						}
					} else {

						unid = orgName + "/" + (++genSimpleOrdId);


					}

					//unid = orgName + "/" + (++idValue);


					System.out.println("Generated ID--->" + unid);


				} else {

					JOptionPane.showMessageDialog(null, "No Order id  found", "Error", 1);


				}


			}

		} catch (Exception ex) {
			System.out.println("From genSimpleOrderUniId-->" + ex);

		}


		return unid;


	}

	int genUniLabId(Connection conobj, String TableName, String COL_ID) {

		int unid = 0;
		try {
			Statement	stat = conobj.createStatement();

			ResultSet	result = stat.executeQuery("SELECT   max("+COL_ID+") FROM " +TableName);
			if (result.next()) {

				int idValue = result.getInt(1);
				System.out.println("from genUniId idValue--->" + idValue);

				String tabName = TableName.substring(3, TableName.length());


				unid = (++idValue);


				System.out.println("LastVAL--->" + idValue);
				System.out.println("From GenUniId generated id --->" + unid);


				SimpleDateFormat	simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

				d = new Date();

				//JOptionPane.showMessageDialog(null,"Date of "+tabName+"  : "+simpleDateFormat.format(d));

				//cylDate=simpleDateFormat.format(d);


			}

		} catch (Exception ex) {
			System.out.println("From genUniId-->" + ex);

			unid = (++genUniLabId);


			System.out.println("First GenId--->" + unid);
		}


		return unid;
	}

	int genEmpId(Connection conobj, String TableName) {

		int unid = 0;
		try {
			Statement	stat = conobj.createStatement();

			ResultSet	result = stat.executeQuery("SELECT   max(EMP_ID) FROM " +TableName);
			if (result.next()) {

				int idValue = result.getInt(1);
				System.out.println("from genUniId idValue--->" + idValue);

				//String tabName = TableName.substring(3, TableName.length());


				unid = (++idValue);


				System.out.println("LastVAL--->" + idValue);
				System.out.println("From GenUniId generated id --->" + unid);


				SimpleDateFormat	simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

				d = new Date();

				//JOptionPane.showMessageDialog(null,"Date of "+tabName+"  : "+simpleDateFormat.format(d));

				//cylDate=simpleDateFormat.format(d);


			}

		} catch (Exception ex) {
			System.out.println("From genUniId-->" + ex);

			unid = (++genUniEmpId);


			System.out.println("First GenId--->" + unid);
		}


		return unid;
	}


	int genUniAdminId(Connection conobj, String TableName) {

		int unid = 0;
		try {
			Statement	stat = conobj.createStatement();

			ResultSet	result = stat.executeQuery("SELECT   max(ID) FROM " +TableName);
			if (result.next()) {

				int idValue = result.getInt(1);
				System.out.println("from genUniId idValue--->" + idValue);

				//String tabName = TableName.substring(3, TableName.length());


				unid = (++idValue);


				System.out.println("LastVAL--->" + idValue);
				System.out.println("From GenUniId generated id --->" + unid);


			/*SimpleDateFormat	simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

				d = new Date();
*/
				//JOptionPane.showMessageDialog(null,"Date of "+tabName+"  : "+simpleDateFormat.format(d));

				//cylDate=simpleDateFormat.format(d);


			}

		} catch (Exception ex) {
			System.out.println("From genUniId-->" + ex);

			unid = (++genUniAdminId);


			System.out.println("First GenId--->" + unid);
		}


		return unid;
	}


	int genUniId(Connection conobj, String TableName) {

		int unid = 0;
		try {
		Statement	stat = conobj.createStatement();

		ResultSet	result = stat.executeQuery("SELECT   max(ID) FROM " +TableName);
			if (result.next()) {

				int idValue = result.getInt(1);
				System.out.println("from genUniId idValue--->" + idValue);

				//String tabName = TableName.substring(3, TableName.length());


				unid = (++idValue);


				System.out.println("LastVAL--->" + idValue);
				System.out.println("From GenUniId generated id --->" + unid);


			/*SimpleDateFormat	simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

				d = new Date();
*/
				//JOptionPane.showMessageDialog(null,"Date of "+tabName+"  : "+simpleDateFormat.format(d));

				//cylDate=simpleDateFormat.format(d);


			}

		} catch (Exception ex) {
			System.out.println("From genUniId-->" + ex);

			unid = (++genUniId);


			System.out.println("First GenId--->" + unid);
		}


		return unid;
	}

	private int genUniCode(Connection con, String tableName) {

		int unid = 0;
		try {
		Statement	stat = con.createStatement();

		ResultSet	result = stat.executeQuery("SELECT   max( CAST (" + tableName + ".HSN_SAC_CODE) AS INT) FROM " + tableName);
			if (result.next()) {

				int idValue = result.getInt(1);
				System.out.println("from genUniId idValue--->" + idValue);

				String tabName = tableName.substring(3, tableName.length());


				unid = (++idValue);


				System.out.println("LastVAL--->" + idValue);
				System.out.println("From GenUniId generated id --->" + unid);


			/*	simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

				d = new Date();
*/
				//JOptionPane.showMessageDialog(null,"Date of "+tabName+"  : "+simpleDateFormat.format(d));

				//cylDate=simpleDateFormat.format(d);


			}

		} catch (Exception ex) {
			System.out.println("From genUniId-->" + ex);

			unid = (++genUniCode);


			System.out.println("First GenId--->" + unid);
		}


		return unid;
	}


	java.sql.Date getDate(String strDate) {
		java.sql.Date date = null;
		try {
			//String msgVal = msgName.substring(3, msgName.length());
            simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

            Date d= simpleDateFormat.parse(strDate);

            date = new java.sql.Date(d.getTime());



            //JOptionPane.showMessageDialog(null, "Date : " + strDate);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error from getDate(str --->" + ex);

		}


		return date;
	}

	String getDateVal(String msgName) {
		String strDate = "";
		try {
			//String msgVal = msgName.substring(3, msgName.length());

			simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");


			d = new Date();



			strDate = simpleDateFormat.format(d);

		//JOptionPane.showMessageDialog(null, "Date : " + strDate);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error from getDate --->" + ex);

		}


		return strDate;
	}

	String getTimeVal(String msgName) {
		String strDate = "";
		try {
			//String msgVal = msgName.substring(3, msgName.length());

			simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");


			d = new Date();



			//strDate = simpleDateFormat.format(d);

			strDate = String.valueOf(d.getTime());

			//JOptionPane.showMessageDialog(null, "Date : " + strDate);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error from getDate --->" + ex);

		}


		return strDate;
	}



	public String getVehicalCategoryNames(Connection conobj, String idVal, String tabName) {

		String VehicalCategoryNames = "";


		if (tabName.equals("")) {
			if (idVal.equals("")) {
				try {
					stat = conobj.createStatement();


					result = stat.executeQuery("SELECT ID, vehical_name, fuel_type, model, brand, year, chasiID, price, engine_no,color,key "
							+ "FROM vehical_detail order by ID;");


					while (result.next()) {

						VehicalCategoryNames += result.getString(1) + "," + result.getString(2) + "," + result.getString(3) + "," + result.getString(4) + "," + result.getString(5)
								+ "," + result.getString(6) + "," + result.getString(7) + "," + result.getString(8) + "," + result.getString(9) + "," + result.getString(10) + "," + result.getString(11) + ":";


						System.out.println("From getVehicalCategoryNames-->" + VehicalCategoryNames);


					}

				} catch (Exception ex) {
					System.out.println("Error From getVehicalCategoryNames " + ex);
				}


			} else {
				try {
					stat = conobj.createStatement();


					result = stat.executeQuery("SELECT ID, vehical_name, fuel_type, model, brand, year, chasiID, price, engine_no,color,key "
							+ "FROM vehical_detail where ID > " + idVal + " order by ID");


					while (result.next()) {

						VehicalCategoryNames += result.getString(1) + "," + result.getString(2) + "," + result.getString(3) + "," + result.getString(4) + "," + result.getString(5)
								+ "," + result.getString(6) + "," + result.getString(7) + "," + result.getString(8) + "," + result.getString(9) + "," + result.getString(10) + "," + result.getString(11) + ":";


						System.out.println("From getVehicalCategoryNames-->" + VehicalCategoryNames);


					}

				} catch (Exception ex) {
					System.out.println("Error From getVehicalCategoryNames " + ex);
				}


			}
		} else {


			if (idVal.equals("")) {
				try {
					stat = conobj.createStatement();


					result = stat.executeQuery("SELECT id, vehical_category, staff_name, model,engine_no,color, chasiID  FROM " + tabName + " where balance_amt <> 0 "
							+ "order by id;");


					while (result.next()) {

						VehicalCategoryNames += result.getString(1) + "," + result.getString(2) + "," + result.getString(3) + "," + result.getString(4) + "," + result.getString(5)
								+ "," + result.getString(6) + "," + result.getString(7) + ":";


						System.out.println("From getVehicalCategoryNames-->" + VehicalCategoryNames);


					}

				} catch (Exception ex) {
					System.out.println("Error From getVehicalCategoryNames " + ex);
				}


			} else {
				try {
					stat = conobj.createStatement();


					result = stat.executeQuery("SELECT id, vehical_category, staff_name, model,engine_no,color, chasiID  FROM " + tabName + "  where id > " + idVal + " and balance_amt <> 0"
							+ " order by id");


					while (result.next()) {

						VehicalCategoryNames += result.getString(1) + "," + result.getString(2) + "," + result.getString(3) + "," + result.getString(4) + "," + result.getString(5)
								+ "," + result.getString(6) + "," + result.getString(7) + ":";


						System.out.println("From getVehicalCategoryNames-->" + VehicalCategoryNames);


					}

				} catch (Exception ex) {
					System.out.println("Error From getVehicalCategoryNames " + ex);
				}


			}


		}


		return VehicalCategoryNames;

	}

	public String getColValues(Connection conobj, String ColName, String TableName) {

		String Values = "";
		try {
			stat = conobj.createStatement();

			result = stat.executeQuery("select  " + ColName + " from " + TableName);


			while (result.next()) {

				Values += result.getString(1) + ":" + result.getString(2) + ",";

				System.out.println("From getLGAValues-->" + Values);


			}

		} catch (Exception ex) {
			System.out.println("Error From getLGAValues " + ex);
		}


		return Values;


	}

	public String getColData(Connection conobj, String ColName, String matchCol, String matchValue, String TableName) {

		System.out.println("From DB getColData String wallaaaaaa");
		String data = "";
		int value = 0;
		int valCash = 0;
		if (matchCol.equals("") && matchValue.equals("")) {
			try {
				stat = conobj.createStatement();

				result = stat.executeQuery("select " + ColName + " from " + TableName);


				while (result.next()) {

					valCash += result.getInt(1);

					System.out.println("From DB getColData values-->" + valCash);


				}
				data = data + valCash;

			} catch (Exception ex) {
				System.out.println("from getColData---->" + ex);
			}

		} else {


			try {

				if (TableName.contains(",")) {
					String[] tables = TableName.split(",");

					for (int i = 0; i < tables.length; i++) {

						stat = conobj.createStatement();

						if (!(tables[i].trim().equals(""))) {
							result = stat.executeQuery("select " + ColName + " from " + tables[i] + " where " + matchCol + "=" + Integer.parseInt(matchValue) + "");
						}

						while (result.next()) {

							data += result.getString(1) + ":";

							System.out.println("From DB getColData getting  value -->" + data);

							//data=data+value;

						}


					}

				}


			} catch (Exception ex) {

				System.out.println("From Outer catch --->" + ex);

						/*	try{
							System.out.println("From String getColData --->"+ex);
							 result=stat.executeQuery("select "+ColName+" from "+TableName+" where "+matchCol+"='"+matchValue+"'");

								while(result.next())
                 						{

                        				 	data=result.getString(1);

                        					System.out.println("From DB getColData getting string value-->"+data);


                 						}
							 }
							catch(Exception exc)
								{
								System.out.println("From getColData inside catch part--->"+exc);
								}


						*/
			}
		}


		return data;


	}


	public String delColData(Connection conobj, String matchCol, String matchValue, String TableName) {

		System.out.println("From DB delColData String wallaaaaaa");
		String data = "";
		int value = 0;
		int valCash = 0;
		if (matchCol.equals("") && matchValue.equals("")) {
			try {
				stat = conobj.createStatement();

				stat.executeUpdate("delete from " + TableName);


			} catch (Exception ex) {
				System.out.println("from delColData---->" + ex);
			}

		} else {

			try {
				stat = conobj.createStatement();

				int delValue = stat.executeUpdate("delete from " + TableName + " where " + matchCol + " = " + matchValue);


				if (delValue > 0) {

					System.out.println("From DB delColData deleting record returned value-->" + value);

					data = data + value;

					JOptionPane.showMessageDialog(null, "deleted from master " + data);

				}

			} catch (Exception ex) {
				System.out.println("From String delColData --->" + ex);

			}
		}


		return data;


	}


	public String getColData(Connection conobj, String ColName, String matchCol, int matchValue, String TableName) {
		String data = "";


		System.out.println(" Inside DB getColData ");
		try {
			stat = conobj.createStatement();

			result = stat.executeQuery("select " + ColName + " from " + TableName + " where " + matchCol + "=" + matchValue);

			System.out.println(" Inside DB getColData after Result");
			while (result.next()) {
				System.out.println(" Inside DB getColData While loop");
				data = result.getString(1);

				System.out.println("From DB getColData-->" + data);


			}

		} catch (Exception ex) {
			System.out.println("Hey1 from getColdadata Error !!! ---->" + ex);
			try {
				result = stat.executeQuery("select " + ColName + " from " + TableName + " where " + matchCol + "=" + matchValue);

				while (result.next()) {

					int value = result.getInt(1);

					System.out.println("From DB getColData getting integer value -->" + value);

					data = data + value;

				}

			} catch (Exception exec) {
				System.out.println("Hey2 from getColdadata Error !!! ---->" + exec);
			}
		}


		return data;


	}
		  /* String getLGAName(Connection conobj,int id)
			{


                String values="";
                try
                {
                 stat=conobj.createStatement();



		result=null;
                 result=stat.executeQuery("select OrgName from LGAName where ID ="+id);


                 		if(result.next())
                 			{

                         		values=result.getString(1);

                         		System.out.println("From getLGAName-->"+values);


			                 }

                 }catch(Exception ex){
		JOptionPane.showMessageDialog(null,"From getLGAName-->"+ex);
			}
                return values;







			}
			*/

		/* public int getClassId(Connection conobj,String classVal)
			{

					int id=0;
             				   try
               					{
                 				stat=conobj.createStatement();

                				 result=stat.executeQuery("select ID from ClassRoom where Class='"+classVal+"'");


                 					while(result.next())
                 					{

                        				 id=result.getInt(1);

                        				System.out.println("From DB getclassId-->"+id);


                 					}

                				}
                 			catch(Exception ex){System.out.println(""+ex);}


			     return id;
			  }*/

           /*    public String getShivomName(Connection conobj,int id, String svp)
					{


                String values="";
                try
                {
                 stat=conobj.createStatement();


                      if(svp.equals(""))
			{
		result=null;
                 result=stat.executeQuery("select OrgName1 from ShivomName where ID ="+id);


                 		if(result.next())
                 			{

                         		values=result.getString(1);

                         		System.out.println("From Admin-->"+values);


			                 }

		        }
		      else
			{

					result=null;
                 result=stat.executeQuery("select OrgName2 from ShivomName where ID ="+id);


                 		if(result.next())
                 			{

                         		values=result.getString(1);

                         		System.out.println("From Admin-->"+values);


			                 }





			}

                 }catch(Exception ex){}
                return values;



		}





  public static String getAdminDetails(Connection conobj,String userId,String pswdval)
             {
                String values="";
                try
                {
                 stat=conobj.createStatement();

                 result=stat.executeQuery("select * from Admin where U_ID ='"+userId+"' and Password ='"+pswdval+"'");


                 while(result.next())
                 {

                         values=result.getString(1)+":"+result.getString(2);

                         System.out.println("From Admin-->"+values);


                 }

                }
                 catch(Exception ex){}
                return values;
             }

			 public	boolean chkActualFee(Connection conobj)
			{



                                   boolean flag=false;
							 try
			                		{


						//int classId=getDbcon().getClassId(conobj,classValue);





						getDbcon();

					stat=conobj.createStatement();

                                        result=stat.executeQuery("SELECT Class FROM ClassRoom where Actual_Fee is null");



					while(result.next())
                  			{


						   JOptionPane.showMessageDialog(null,"Actuall Fee not set for --> "+result.getString(1));


						   flag=true;
				//----------------------------------------------------------------------------------------------------------------------------


					                                                             //----------------------------------------------------------------------------------------------------------------------------





                    			}



               			}
                	 catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"Error My Dear : "+ex);
				}




               return flag;




			}



	 public	boolean updateActualFee(Connection conobj,String classValue,String feeValue)
			{

							 try
			                {


						int classId=getDbcon().getClassId(conobj,classValue);








	pstat=conobj.prepareStatement("update ClassRoom set Actual_Fee= ? where ID =?");



					if(!(classId<0) && feeValue!=null)
                  			{


						int pay=Integer.parseInt(feeValue);
						pstat.setInt(1,pay);
						pstat.setInt(2,classId);



						int insertVal=pstat.executeUpdate();
								System.out.println("From DB updateActualFee  row updated");
                     						if(insertVal==1)
                    						 {
                      						System.out.println("From DB updateActualFee Value from exUpdate--->"+insertVal);

                         					return true;
                     						}






				//----------------------------------------------------------------------------------------------------------------------------


					                                                             //----------------------------------------------------------------------------------------------------------------------------





                    			}


               			}
                	 catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"Error My Dear : "+ex);
				}




               return false;




			}


					 public String getColNames(Connection conobj,String ColName1,String ColName2)
				{
                                       String value="";
               				 try
               					 {
                				 stat=conobj.createStatement();


                                                 result=stat.executeQuery("select * from ClassRoom");

                                                 rsmd=result.getMetaData();
                                                int colNo=0;
						columnCount=rsmd.getColumnCount();

                 				for(int i=1;i<=columnCount;i++)
                 					{
					        	if(rsmd.getColumnName(i).equals(ColName1) || rsmd.getColumnName(i).equals(ColName2))
								{

							      colNo=i;
							value+=rsmd.getColumnName(i)+":";
				System.out.println("values From  getColNames, ClassRoom Table Col Name :"+value);

								}


                 					}
                                                                                             value=value+rsmd.getTableName(colNo);

                				}
                 				catch(Exception ex){System.out.println("Error from  getColNames : "+ex);}

                                  return value;

				}



                         public String getStudentDetailColNames(Connection conobj)
				{
				 String value="";
               				 try
               					 {
                				 stat=conobj.createStatement();


                                                 result=stat.executeQuery("select * from StudentDetails");

                                                 rsmd=result.getMetaData();

						int colCount=rsmd.getColumnCount();

                 				for(int i=1;i<=colCount;i++)
                 					{


							value+=rsmd.getColumnName(i)+":";
				System.out.println("From  getStudentDetailColNames : getting column names : "+value);

							}




                				}
                 				catch(Exception ex){System.out.println("Error from  getStudentDetailColNames : "+ex);}

                                  return value;




				}



			public String getPendingInstColNames(Connection conobj,String oldStudentName)
					{



							System.out.println("Inside getPendingInstColNames");

							 String values="--";
               				 try
               					 {
                				 stat=conobj.createStatement();
                                                 oldStat=conobj.createStatement();

                                                 result=stat.executeQuery("select * from StudentDetails");

                                                 rsmd=result.getMetaData();

						columnCount=rsmd.getColumnCount();

                 				for(int i=1;i<=columnCount;i++)
                 					{

						          if(rsmd.getColumnName(i).endsWith("Installment"))
							     {

							      String colValue=rsmd.getColumnName(i);
          oldResult=oldStat.executeQuery("select * from StudentDetails where Student_Name ='"+oldStudentName+"' and "+colValue+" in (0)");
								while(oldResult.next())
								{
                         					System.out.println("values From getPendingInstColNames Col Name : -->"+colValue);
                                                         	 values+=":"+colValue;
								}
						    	     }


                 					}

                				}
                 				catch(Exception ex){System.out.println("Error from InstColNames : "+ex);}

                                  return values;




					}



                    public String  getClassNames(Connection conobj)
				{
					 String ClassNames="--";
                					try
                						{
                 						stat=conobj.createStatement();

                 						result=stat.executeQuery("select Class from ClassRoom");


                						 while(result.next())
                 							{

                         						 ClassNames+=":"+result.getString(1);

                         						System.out.println("From getClassNames-->"+ClassNames);


                							 }

                						}
                 					catch(Exception ex){System.out.println(""+ex);}


				return ClassNames;

				}


		public String getAllStudentRecords(Connection conobj,String className,String studentName)
					{

						  String values="";

					 try
               				 {

                                          if(className!="")
					      {


						  int classId=getDbcon().getClassId(conobj,className);

                				 stat=conobj.createStatement();


                                                 result=stat.executeQuery("select * from StudentDetails where ClassID="+classId);

                                                 rsmd=result.getMetaData();


						}
					     else if(studentName!="")
						{


                				 stat=conobj.createStatement();


                                                 result=stat.executeQuery("select * from StudentDetails where Student_Name='"+studentName+"'");

                                                 rsmd=result.getMetaData();


						 }





                                                int  columnCount=rsmd.getColumnCount();


                                                while(result.next())
						{


						//System.out.println("Fetching Records : "+result.getString());

						  for(int i=1;i<=columnCount;i++)
                 					{



							values+="--"+result.getString(i);

							System.out.println("Fetching Records : "+values);


                 					}





						}



                			}
                 			catch(Exception ex){
						System.out.println("Error from  getAllStudentRecords : "+ex);
							   }










				     return values;
					}





		public String getRowColCount(Connection conobj,String className)
					{int rowCount=0, columnCount=0;


						  String values="";
               				 try
               				 {
                				 stat=conobj.createStatement();


                                                 result=stat.executeQuery("select * from StudentDetails");

                                                 rsmd=result.getMetaData();


                                                 columnCount=rsmd.getColumnCount();


                                                while(result.next())
						{
                                                      ++rowCount;







						}

                                                if(rowCount>0 && columnCount>0)
						{
						     return rowCount+":"+columnCount;



						}
						else
						{

				System.out.println(" from RowColCount : Rows & Columns not found ");


						}

                			}
                 			catch(Exception ex){
						System.out.println("Error from  getAllStudentRecords : "+ex);
							   }




				     return rowCount+":"+columnCount;
					}



public boolean entryNamesValuesandPayment(Connection conobj,String classVal,boolean flagFullPay,String InstallmentValue,String txtPayment,String txtNewStudentName,String DOB,String FathersName,String MothersName,String Address,String Discount,String Remarks)
				{
                                  int instVal=0;
				int ActualFeeValue=0;

	 			try
			                {
					stat=conobj.createStatement();
                                                                        result=stat.executeQuery("select * from StudentDetails");

                                                 		               rsmd=result.getMetaData();

						columnCount=rsmd.getColumnCount();

						int[] pos=new int[columnCount];

					              int posValue=0;

					                    System.out.println("From DB entrynvPayment column Count is "+columnCount);

				       for(int idxVar=0;idxVar<pos.length;idxVar++)
					{posValue=idxVar;
                                                                        pos[idxVar]=++posValue;

					      System.out.println("From DB entrynvPayment putting values"+pos[idxVar]);

				 	}
                                                                            getInstColNames(conobj);

						int classId=getDbcon().getClassId(conobj,classVal);

		pstat=conobj.prepareStatement("insert into StudentDetails values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");


							    for(int idx=0;idx<pos.length;idx++)
								{


						if(pos[idx]!=colNoClassID && pos[idx]!=colNoStudentUniqueID && pos[idx]!=colNoStudentName && pos[idx]!=colNoDOB && pos[idx]!=colNoFathersName && pos[idx]!=colNoMothersName && pos[idx]!=colNoAddress && pos[idx]!=colNoTotalPaid && pos[idx]!=colNoBalance && pos[idx]!=colNoDiscount && pos[idx]!=colNoRemarks  && pos[idx]!=colNoDate && pos[idx]!=colNoReceipt)
									{
										System.out.println("1st values From entryNamesValuesandPayment"+pos[idx]);
										pstat.setInt(pos[idx],0);
										System.out.println("2nd values From entryNamesValuesandPayment"+pos[idx]);
									}



								 if(pos[idx]==colNoClassID)
									 {
						System.out.println("values From entryNamesValuesandPayment Class ID   -->Col No"+pos[idx]);
										pstat.setInt(pos[idx],classId);


									 }



								 if(pos[idx]==colNoStudentUniqueID)
								 {
						System.out.println("values From entryNamesValuesandPayment ClassRoom Unique ID   -->Col No"+pos[idx]);
										pstat.setString(pos[idx],getDbcon().genUniId(conobj));


									 }

								 if(pos[idx]==colNoStudentName)
									 {
						System.out.println("values From entryNamesValuesandPayment ClassRoom Name   -->Col No"+pos[idx]);
										pstat.setString(pos[idx],txtNewStudentName);


									 }
								   if(pos[idx]==colNoDOB)
									 {
						System.out.println("values From entryNamesValuesandPayment ClassRoom DOB   -->Col No"+pos[idx]);
										pstat.setString(pos[idx],DOB);


									 }
								 if(pos[idx]==colNoFathersName)
									 {
						System.out.println("values From entryNamesValuesandPayment ClassRoom Father's Name   -->Col No"+pos[idx]);
										pstat.setString(pos[idx],FathersName);


									 }
								 if(pos[idx]==colNoMothersName)
									 {
						System.out.println("values From entryNamesValuesandPayment ClassRoom Mother's Name   -->Col No"+pos[idx]);
										pstat.setString(pos[idx],MothersName);


									 }

								  if(pos[idx]==colNoAddress)
									 {
						System.out.println("values From entryNamesValuesandPayment ClassRoom Address   -->Col No"+pos[idx]);
										pstat.setString(pos[idx],Address);


									 }


								 if(pos[idx]==colNoTotalPaid)
									 {
						System.out.println("values From entryNamesValuesandPayment Total Paid   -->Col No"+pos[idx]);
										pstat.setInt(pos[idx],paymentValue);


									 }
								 if(pos[idx]==colNoBalance)
									 {
												pstat.setInt(pos[idx],balValue);





									 }
								 if(pos[idx]==colNoDiscount)
									 {
						System.out.println("values From entryNamesValuesandPayment Discount   -->Col No"+pos[idx]);

												if(Discount.equals(""))
												{
												pstat.setString(pos[idx],Discount);
												}
											        else
												{
												pstat.setString(pos[idx],Discount);
												}

									 }
									if(pos[idx]==colNoRemarks)
									 {
						System.out.println("values From entryNamesValuesandPayment Remarks   -->Col No"+pos[idx]);

										if(Remarks.equals(""))
												{
												 pstat.setString(pos[idx],Remarks);
												}
											        else
												{
												 pstat.setString(pos[idx],Remarks);
												}



									 }
									if(pos[idx]==colNoDate)
									 {
						System.out.println("values From entryNamesValuesandPayment Date  -->Col No"+pos[idx]);


									 simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

									  d = new Date();

								                System.out.println("Your Date of Admission : "+simpleDateFormat.format(d));

											 pstat.setString(pos[idx],d.toString());
										JOptionPane.showMessageDialog(null,"Your date of admission : "+d);



									 }
									if(pos[idx]==colNoReceipt)
									 {
			System.out.println("values From entryNamesValuesandPayment Receipt  -->Col No"+pos[idx]);

							String receiptId=getDbcon().genReceiptId(conobj,classVal);

                                                     System.out.println("Your Receipt No :"+receiptId);

						 pstat.setString(pos[idx],receiptId);
						JOptionPane.showMessageDialog(null,"Your Receipt No is :"+receiptId);



									 }






								   }
                                                                      int insertVal=pstat.executeUpdate();
								System.out.println("From DB entrynvPayment payment row inserted");
                     						if(insertVal==1)
                    						 {
                      						System.out.println("Value from exUpdate--->"+insertVal);

                         					return true;
                     						}

                                                                                            }
                                                                                         else if(Discount.equals("Free Education"))
						   {

						JOptionPane.showMessageDialog(null,"Free Education can not be applied to Full Payment:");



                                                                                          }



					}

               		     }

                            }
                	 catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"Error My Dear : "+ex);
				}
               return false;
	     }




      public boolean updateNamesValuesandPayment(Connection conobj,String classVal2,String oldStudentValueOuterScope1,String outerInstallmentValue2,String txtPayment4)
							     {

					// int instVal=0;
				 	 try
			                {


						int classId=getDbcon().getClassId(conobj,classVal2);

	pstat=conobj.prepareStatement("update StudentDetails set "+outerInstallmentValue2+"= ?, Total_Paid= ?, Balance =? where ClassID =? and Student_Name= ?");












						int pay=Integer.parseInt(txtPayment4);

						int Total_Payment=(pay+colData);
						int BalanceValue=ActualFeeValue-Total_Payment;

						pstat.setInt(1,pay);
						pstat.setInt(2,Total_Payment);

						pstat.setInt(3,BalanceValue);
						pstat.setInt(4,classId);
						pstat.setString(5,oldStudentValueOuterScope1);









						int insertVal=pstat.executeUpdate();
								System.out.println("From DB updateNamesValuesandPayment payment row updated");
                     						if(insertVal==1)
                    						 {
                      						System.out.println("From DB updateNamesValuesandPayment Value from exUpdate--->"+insertVal);

                         					return true;
                     						}
				//----------------------------------------------------------------------------------------------------------------------------


                               //----------------------------------------------------------------------------------------------------------------------------





                    			}


               			}
                	 catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"Error My Dear : "+ex);
				}




               return false;


		 }

                  public  int  getColData(Connection conobj,String ColName,String matchCol,int matchValue, String TableName)
			{
				int data=0;
             				   try
               					{
                 				stat=conobj.createStatement();

                				 result=stat.executeQuery("select "+ColName+" from "+TableName+" where "+matchCol+"="+matchValue);


                 					while(result.next())
                 					{

                        				 data=result.getInt(1);

                        				System.out.println("From DB getColData-->"+data);


                 					}

                				}
                 			catch(Exception ex){System.out.println(""+ex);}


			     return data;




			}



                    int  getColData(Connection conobj,String ColName,String matchCol1,String matchValue1,String matchCol2,int matchValue2, String TableName)
			{
				int data=0;
             				   try
               					{
                 				stat=conobj.createStatement();

                  result=stat.executeQuery("select "+ColName+" from "+TableName+" where "+matchCol1+"='"+matchValue1+"' and "+matchCol2+"="+matchValue2);


                 					while(result.next())
                 					{

                        				 data=result.getInt(1);

                        				System.out.println("From DB getColData for Col : "+ColName+" Data --> "+data);


                 					}

                				}
                 			catch(Exception ex){System.out.println(""+ex);}



			     return data;




			}



		 public int getClassId(Connection conobj,String classVal)
			{

					int id=0;
             				   try
               					{
                 				stat=conobj.createStatement();

                				 result=stat.executeQuery("select ID from ClassRoom where Class='"+classVal+"'");


                 					while(result.next())
                 					{

                        				 id=result.getInt(1);

                        				System.out.println("From DB getclassId-->"+id);


                 					}

                				}
                 			catch(Exception ex){System.out.println(""+ex);}


			     return id;
			  }







             boolean insertCustDetails(Connection conobj,String name,String cNo,String adrs,String idCard,String idCardNo,String comNo)
             {
                try
                {
                 pstat=conobj.prepareStatement("insert into CustDetails values(?,?,?,?,?,?,?)");




                  int unqId=getDbcon().genUniId(conobj);
if(name!=null && cNo!=null && adrs!=null && idCard!=null && idCardNo!=null && comNo!=null && unqId!=0)
                  {

                     pstat.setString(1,name);
                     pstat.setString(2,cNo);
                     pstat.setString(3,adrs);
                     pstat.setString(4,idCard);
                     pstat.setString(5,idCardNo);
                     pstat.setString(6, comNo);
                     pstat.setInt(7, unqId);
                  int insertVal=pstat.executeUpdate();
                     if(insertVal==1)
                     {
                      System.out.println("Value from exUpdate--->"+insertVal);

                         return true;
                     }
                    }


                }
                 catch(Exception ex){JOptionPane.showMessageDialog(null,"Mistake My Dear I think You Have Already Registered In e-ANDROID : "+ex);;}
               return false;
             }










 String genUniId(Connection conobj)
                      {

                       String unid=null;
                         try
                {
                 stat=conobj.createStatement();

                result=stat.executeQuery("SELECT   max( cint(mid( (mid(StudentDetails.Student_Unique_ID,  INSTR(StudentDetails.Student_Unique_ID,'/' ) " + " +1,len(StudentDetails.Student_Unique_ID) ) ), instr( mid(StudentDetails.Student_Unique_ID,  INSTR(StudentDetails.Student_Unique_ID,'/') " +  " +1,len(StudentDetails.Student_Unique_ID) ),'/') "+  "+1,len(StudentDetails.Student_Unique_ID))) ) FROM StudentDetails");
                 if(result.next())
                 {

                       String idValue=  result.getString(1);
                       System.out.println("from genUniId idValue--->"+idValue);


                                    //String incrId= idValue.substring(7,idValue.length()-1);

					   int incrVal=Integer.parseInt(idValue);
					 System.out.println("Converted to Int--->Incrval--->"+incrVal);

							 simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

									  d = new Date();

								                System.out.println("Your Date of Admission : "+simpleDateFormat.format(d));

						String dateYear=simpleDateFormat.format(d);

						String yearStr=  dateYear.substring(8,dateYear.length());
						unid = yearStr+"/"+getDbcon().getShivomName(conobj,2,"svp")+"/"+(++incrVal);




                          System.out.println("LastVAL--->"+idValue);
                          System.out.println("From GenId--->"+unid);


                 }

                }
                 catch(Exception ex){System.out.println("From genUniId-->"+ex);

				              simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

									  d = new Date();

				System.out.println("Your Date of Admission : "+simpleDateFormat.format(d));

						String dateYear=simpleDateFormat.format(d);

						String yearStr=  dateYear.substring(8,dateYear.length());
						unid = yearStr+"/"+getDbcon().getShivomName(conobj,2,"svp")+"/"+(++genId);


                          System.out.println("First GenId--->"+unid);
                 }



                         return unid;
                      }







String genReceiptId(Connection conobj,String ClassName)
                      {

                       String recId=null;
                         try
                {
                 stat=conobj.createStatement();
result=stat.executeQuery("SELECT   max( cint(mid( (mid(StudentDetails.Reciept_No,  INSTR(StudentDetails.Reciept_No,'/' ) " + " +1,len(StudentDetails.Reciept_No) ) ), instr( mid(StudentDetails.Reciept_No,  INSTR(StudentDetails.Reciept_No,'/') " +  " +1,len(StudentDetails.Reciept_No) ),'/') "+  "+1,len(StudentDetails.Reciept_No))) ) FROM StudentDetails");

                 if(result.next())
                 {


					   int incrVal=Integer.parseInt(result.getString(1));
					 System.out.println("From genRecId Incrval--->"+incrVal);


						 simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

									  d = new Date();

					System.out.println("Your Date of Admission : "+simpleDateFormat.format(d));

						String dateYear=simpleDateFormat.format(d);

						String monthStr=  dateYear.substring(3,5);


						recId=ClassName+"/"+monthStr+"/"+(++incrVal);



                          System.out.println("From genRecId recID is --->"+recId);


                 }

                }
                 catch(Exception ex){System.out.println("From genReceiptId-->"+ex);

				              simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

									  d = new Date();

				System.out.println("Your Date of Admission : "+simpleDateFormat.format(d));

						String dateYear=simpleDateFormat.format(d);

						String monthStr=  dateYear.substring(3,5);
			//recId = yearStr+"/"+getDbcon().getShivomName(conobj,2,"svp")+"/"+ClassName+"/"+(++genFirstRecId);

				recId=ClassName+"/"+monthStr+"/"+(++genFirstRecId);
                          System.out.println("First RecId--->"+recId);
                 }



                         return recId;
                      }
*/

	void addVahicalValues(Connection con, String vehicalId, String vehicalName, String vehicalNo, String materialId, String materialName, String materialQty, String materialPrice, String driverId, String driverName, String conductorName, String fromTo, String vivaran, String amount
			, String loader, String orderOrBuyer, String cashDeposit, String oldExpVal, String expenses, String diesel, String fromv, String startReading, String endReading, String oldBalance, String balance, int vOoZ) {

		String tableName = "inventory_detail";
		try {
			stat = con.createStatement();
			result = stat.executeQuery("select * from " + tableName);

			rsmd = result.getMetaData();

			columnCount = rsmd.getColumnCount();

			tableName = rsmd.getTableName(columnCount);

			int[] pos = new int[columnCount];

			int posValue = 0;

			System.out.println("From DB addVahicalValues column Count is " + columnCount);

			for (int idxVar = 0; idxVar < pos.length; idxVar++) {
				posValue = idxVar;
				pos[idxVar] = ++posValue;

				System.out.println("From DB addVahicalValues putting values" + pos[idxVar]);

			}
			getTabColNames(tableName, rsmd, columnCount);


			pstat = con.prepareStatement("insert into " + tableName + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			if (vOoZ == 0) {


				for (int idx = 0; idx < pos.length; idx++)

				{

					if (pos[idx] == col_vehical_id) {
						pstat.setString(pos[idx], vehicalId);
						System.out.println("From addVahicalValues  ID setting values " + driverId + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_vehical_name) {

						pstat.setString(pos[idx], vehicalName);
						System.out.println("From addVahicalValues VehicalName setting values " + vehicalName + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_vehical_no) {
						pstat.setString(pos[idx], vehicalNo);
						System.out.println("From addVahicalValues  VehicalFuelType setting values " + vehicalNo + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_material_id) {
						pstat.setString(pos[idx], materialId);
						System.out.println("From addVahicalValues  VehicalModel setting values " + materialId + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_material_name) {
						pstat.setString(pos[idx], materialName);
						System.out.println("From addVahicalValues  VehicalBrand setting values " + vivaran + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_material_qty) {
						pstat.setString(pos[idx], materialQty);
						System.out.println("From addVahicalValues  VehicalYear setting values " + amount + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_material_price) {
						pstat.setString(pos[idx], materialPrice);
						System.out.println("From addVahicalValues  VehicalChasis setting values " + loader + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_ID) {
						int uniQID = genUniId(con, tableName);
						pstat.setInt(pos[idx], uniQID);
						System.out.println("From addVahicalValues  ID setting values " + uniQID + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_driver_id) {
						pstat.setString(pos[idx], driverId);
						System.out.println("From addVahicalValues  ID setting values " + driverId + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_driver_name) {

						pstat.setString(pos[idx], driverName);
						System.out.println("From addVahicalValues VehicalName setting values " + driverName + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_conductor_name) {
						pstat.setString(pos[idx], conductorName);
						System.out.println("From addVahicalValues  VehicalFuelType setting values " + conductorName + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_from_to) {
						pstat.setString(pos[idx], fromTo);
						System.out.println("From addVahicalValues  VehicalModel setting values " + fromTo + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_vivaran) {
						pstat.setString(pos[idx], vivaran);
						System.out.println("From addVahicalValues  VehicalBrand setting values " + vivaran + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_amount) {
						pstat.setString(pos[idx], amount);
						System.out.println("From addVahicalValues  VehicalYear setting values " + amount + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_loader) {
						pstat.setString(pos[idx], loader);
						System.out.println("From addVahicalValues  VehicalChasis setting values " + loader + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_orderOrBuyer) {
						pstat.setString(pos[idx], orderOrBuyer);
						System.out.println("From addVahicalValues  VehicalPrice setting values " + orderOrBuyer + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_cashDeposit) {

						pstat.setString(pos[idx], cashDeposit);
						System.out.println("From addVahicalValues  VehicalEngineNo setting values " + cashDeposit + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_old_ExpVal) {

						pstat.setString(pos[idx], oldExpVal);
						System.out.println("From addVahicalValues  oldExpVal setting values " + oldExpVal + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_expenses) {

						pstat.setString(pos[idx], expenses);
						System.out.println("From addVahicalValues  VehicalEngineNo setting values " + expenses + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_diesel) {

						pstat.setString(pos[idx], diesel);
						System.out.println("From addVahicalValues  VehicalEngineNo setting values " + diesel + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_from) {

						pstat.setString(pos[idx], fromv);
						System.out.println("From addVahicalValues  VehicalEngineNo setting values " + diesel + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_start_reading) {

						pstat.setString(pos[idx], startReading);
						System.out.println("From addVahicalValues  VehicalEngineNo setting values " + diesel + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_end_reading) {

						pstat.setString(pos[idx], endReading);
						System.out.println("From addVahicalValues  VehicalEngineNo setting values " + diesel + "  -->Col No" + pos[idx]);


					}
					if (pos[idx] == col_old_Balance) {

						pstat.setString(pos[idx], oldBalance);
						System.out.println("From addVahicalValues  VehicalEngineNo setting values " + oldBalance + "  -->Col No" + pos[idx]);


					}
					if (pos[idx] == col_balance) {

						pstat.setString(pos[idx], balance);
						System.out.println("From addVahicalValues  VehicalEngineNo setting values " + balance + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_vehical_entry_date) {
						entryDate = getDateVal(tableName);
						pstat.setString(pos[idx], entryDate);
						System.out.println("From addVahicalValues  entryDate setting values " + entryDate + "  -->Col No" + pos[idx]);


					}

				}

			} else {
				for (int idx = 0; idx < pos.length; idx++) {

					if (pos[idx] == col_vehical_id) {
						pstat.setString(pos[idx], vehicalId);
						System.out.println("From addVahicalValues  ID setting values " + driverId + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_vehical_name) {

						pstat.setString(pos[idx], vehicalName);
						System.out.println("From addVahicalValues VehicalName setting values " + vehicalName + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_vehical_no) {
						pstat.setString(pos[idx], vehicalNo);
						System.out.println("From addVahicalValues  VehicalFuelType setting values " + vehicalNo + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_material_id) {
						pstat.setString(pos[idx], materialId);
						System.out.println("From addVahicalValues  VehicalModel setting values " + materialId + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_material_name) {
						pstat.setString(pos[idx], materialName);
						System.out.println("From addVahicalValues  VehicalBrand setting values " + vivaran + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_material_qty) {
						pstat.setString(pos[idx], materialQty);
						System.out.println("From addVahicalValues  VehicalYear setting values " + amount + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_material_price) {
						pstat.setString(pos[idx], materialPrice);
						System.out.println("From addVahicalValues  VehicalChasis setting values " + loader + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_driver_name) {

						pstat.setString(pos[idx], driverName);
						System.out.println("From addVahicalValues VehicalName setting values " + driverName + "  -->Col No" + pos[idx]);
					}


					if (pos[idx] == col_conductor_name) {
						pstat.setString(pos[idx], conductorName);
						System.out.println("From addVahicalValues  VehicalFuelType setting values " + conductorName + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_from_to) {
						pstat.setString(pos[idx], fromTo);
						System.out.println("From addVahicalValues  VehicalModel setting values " + fromTo + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_vivaran) {
						pstat.setString(pos[idx], vivaran);
						System.out.println("From addVahicalValues  VehicalBrand setting values " + vivaran + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_amount) {
						pstat.setString(pos[idx], amount);
						System.out.println("From addVahicalValues  VehicalYear setting values " + amount + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_loader) {
						pstat.setString(pos[idx], loader);
						System.out.println("From addVahicalValues  VehicalChasis setting values " + loader + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_orderOrBuyer) {
						pstat.setString(pos[idx], orderOrBuyer);
						System.out.println("From addVahicalValues  VehicalPrice setting values " + orderOrBuyer + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_cashDeposit) {

						pstat.setString(pos[idx], cashDeposit);
						System.out.println("From addVahicalValues  VehicalEngineNo setting values " + cashDeposit + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_old_ExpVal) {

						pstat.setString(pos[idx], oldExpVal);
						System.out.println("From addVahicalValues  oldExpVal setting values " + oldExpVal + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_expenses) {

						pstat.setString(pos[idx], expenses);
						System.out.println("From addVahicalValues  VehicalEngineNo setting values " + expenses + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_diesel) {

						pstat.setString(pos[idx], diesel);
						System.out.println("From addVahicalValues  VehicalEngineNo setting values " + diesel + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_from) {

						pstat.setString(pos[idx], fromv);
						System.out.println("From addVahicalValues  VehicalEngineNo setting values " + diesel + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_start_reading) {

						pstat.setString(pos[idx], startReading);
						System.out.println("From addVahicalValues  VehicalEngineNo setting values " + diesel + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_end_reading) {

						pstat.setString(pos[idx], endReading);
						System.out.println("From addVahicalValues  VehicalEngineNo setting values " + diesel + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_old_Balance) {

						pstat.setString(pos[idx], oldBalance);
						System.out.println("From addVahicalValues  VehicalEngineNo setting values " + oldBalance + "  -->Col No" + pos[idx]);


					}
					if (pos[idx] == col_balance) {

						pstat.setString(pos[idx], balance);
						System.out.println("From addVahicalValues  VehicalEngineNo setting values " + balance + "  -->Col No" + pos[idx]);


					}
					if (pos[idx] == col_entry_date) {
						entryDate = getDateVal(tableName);
						pstat.setString(pos[idx], entryDate);
						System.out.println("From addVahicalValues  entryDate setting values " + entryDate + "  -->Col No" + pos[idx]);


					}
				}


			}
			int insertVal = pstat.executeUpdate();
			//boolean insertVal=pstat.execute();

			System.out.println("From DB addVahicalValues row inserted");
			if (insertVal > 0) {
				System.out.println("Value from exUpdate--->" + insertVal);


			}


		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "From addVahicalValues Error My Dear : " + ex);
		}


	}

	String getVehicalColorList(Connection con) {
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		String values = "--";
		try {
			stat = con.createStatement();

			result = stat.executeQuery("select color from colors");


			while (result.next()) {

				values = values + ":" + result.getString(1);

				System.out.println("From getVehicalColorList-->" + values);


			}

		} catch (Exception ex) {
		}
		return values;

	}

	void addDriverDetails(Connection con, String driverName, String address, String phoneNo, String amountGiven, String remark, int vOoZ) {

		String tableName = "driver_detail";
		try {
			stat = con.createStatement();
			result = stat.executeQuery("select * from " + tableName);

			rsmd = result.getMetaData();

			columnCount = rsmd.getColumnCount();

			tableName = rsmd.getTableName(columnCount);

			int[] pos = new int[columnCount];

			int posValue = 0;

			System.out.println("From DB addVahicalValues column Count is " + (columnCount));

			for (int idxVar = 0; idxVar < pos.length; idxVar++) {
				posValue = idxVar;
				pos[idxVar] = ++posValue;

				System.out.println("From DB addVahicalValues putting values" + pos[idxVar]);

			}
			getTabColNames(tableName, rsmd, columnCount);


			pstat = con.prepareStatement("insert into " + tableName + " values(?,?,?,?,?,?,?)");

			if (vOoZ == 0) {


				for (int idx = 0; idx < pos.length; idx++)

				{


					if (pos[idx] == col_dd_ID) {
						int uniQID = genUniId(con, tableName);
						pstat.setInt(pos[idx], uniQID);
						System.out.println("From addVahicalValues  ID setting values " + uniQID + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_dd_driver_name) {

						pstat.setString(pos[idx], driverName);
						System.out.println("From addVahicalValues VehicalName setting values " + driverName + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_dd_address) {
						pstat.setString(pos[idx], address);
						System.out.println("From addVahicalValues  VehicalFuelType setting values " + address + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_dd_contact) {
						pstat.setString(pos[idx], phoneNo);
						System.out.println("From addVahicalValues  VehicalModel setting values " + phoneNo + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_dd_amount) {
						pstat.setString(pos[idx], amountGiven);
						System.out.println("From addVahicalValues  VehicalBrand setting values " + amountGiven + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_dd_remark) {
						pstat.setString(pos[idx], remark);
						System.out.println("From addVahicalValues  VehicalYear setting values " + remark + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_dd_entry_date) {
						entryDate = getDateVal(tableName);
						pstat.setString(pos[idx], entryDate);
						System.out.println("From addVahicalValues  entryDate setting values " + entryDate + "  -->Col No" + pos[idx]);


					}

				}

			} else {
				for (int idx = 0; idx < pos.length; idx++) {


					if (pos[idx] == col_dd_driver_name) {

						pstat.setString(pos[idx], driverName);
						System.out.println("From addVahicalValues VehicalName setting values " + driverName + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_dd_address) {
						pstat.setString(pos[idx], address);
						System.out.println("From addVahicalValues  VehicalFuelType setting values " + address + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_dd_contact) {
						pstat.setString(pos[idx], phoneNo);
						System.out.println("From addVahicalValues  VehicalModel setting values " + phoneNo + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_dd_amount) {
						pstat.setString(pos[idx], amountGiven);
						System.out.println("From addVahicalValues  VehicalBrand setting values " + amountGiven + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_dd_remark) {
						pstat.setString(pos[idx], remark);
						System.out.println("From addVahicalValues  VehicalYear setting values " + remark + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_dd_entry_date) {
						entryDate = getDateVal(tableName);
						pstat.setString(pos[idx], entryDate);
						System.out.println("From addVahicalValues  entryDate setting values " + entryDate + "  -->Col No" + pos[idx]);


					}


				}


			}

			int insertVal = pstat.executeUpdate();
			//boolean insertVal=pstat.execute();

			System.out.println("From DB addVahicalValues row inserted");
			if (insertVal > 0) {
				System.out.println("Value from exUpdate--->" + insertVal);


			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "From addVahicalValues Error My Dear : " + ex);
		}


	}


	public String getDriverDetails(Connection con) {


		String values = "--";
		try {
			stat = con.createStatement();

			result = stat.executeQuery("select id , driver_name from driver_detail");


			while (result.next()) {

				values = values + ":" + result.getString(1) + " " + result.getString(2);

				System.out.println("From getDriverList-->" + values);


			}

		} catch (Exception ex) {
		}
		return values;

	}

	public void addVehicalDetails(Connection con, String vehicalName, String vehicalNo, String vehicalModel, String vehicalChasis, String remark, int vOoZ) {

		String tableName = "vehical_detail";
		try {
			stat = con.createStatement();
			result = stat.executeQuery("select * from " + tableName);

			rsmd = result.getMetaData();

			columnCount = rsmd.getColumnCount();

			tableName = rsmd.getTableName(columnCount);

			int[] pos = new int[columnCount];

			int posValue = 0;

			System.out.println("From DB addVahicalValues column Count is " + (columnCount));

			for (int idxVar = 0; idxVar < pos.length; idxVar++) {
				posValue = idxVar;
				pos[idxVar] = ++posValue;

				System.out.println("From DB addVahicalValues putting values" + pos[idxVar]);

			}
			getTabColNames(tableName, rsmd, columnCount);


			pstat = con.prepareStatement("insert into " + tableName + " values(?,?,?,?,?,?,?)");

			if (vOoZ == 0) {


				for (int idx = 0; idx < pos.length; idx++)

				{


					if (pos[idx] == col_vd_ID) {
						int uniQID = genUniId(con, tableName);
						pstat.setInt(pos[idx], uniQID);
						System.out.println("From addVahicalValues  ID setting values " + uniQID + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_vd_vehical_name) {

						pstat.setString(pos[idx], vehicalName);
						System.out.println("From addVahicalValues VehicalName setting values " + vehicalName + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_vd_vehical_no) {
						pstat.setString(pos[idx], vehicalNo);
						System.out.println("From addVahicalValues  VehicalFuelType setting values " + vehicalNo + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_vd_vehical_model) {
						pstat.setString(pos[idx], vehicalModel);
						System.out.println("From addVahicalValues  VehicalModel setting values " + vehicalModel + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_vd_vehical_chasis) {
						pstat.setString(pos[idx], vehicalChasis);
						System.out.println("From addVahicalValues  VehicalBrand setting values " + vehicalChasis + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_vd_remark) {
						pstat.setString(pos[idx], remark);
						System.out.println("From addVahicalValues  VehicalYear setting values " + remark + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_vd_entry_date) {
						entryDate = getDateVal(tableName);
						pstat.setString(pos[idx], entryDate);
						System.out.println("From addVahicalValues  entryDate setting values " + entryDate + "  -->Col No" + pos[idx]);


					}

				}

			} else {
				for (int idx = 0; idx < pos.length; idx++) {


					if (pos[idx] == col_vd_vehical_name) {

						pstat.setString(pos[idx], vehicalName);
						System.out.println("From addVahicalValues VehicalName setting values " + vehicalName + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_vd_vehical_no) {
						pstat.setString(pos[idx], vehicalNo);
						System.out.println("From addVahicalValues  VehicalFuelType setting values " + vehicalNo + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_vd_vehical_model) {
						pstat.setString(pos[idx], vehicalModel);
						System.out.println("From addVahicalValues  VehicalModel setting values " + vehicalModel + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_vd_vehical_chasis) {
						pstat.setString(pos[idx], vehicalChasis);
						System.out.println("From addVahicalValues  VehicalBrand setting values " + vehicalChasis + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_vd_remark) {
						pstat.setString(pos[idx], remark);
						System.out.println("From addVahicalValues  VehicalYear setting values " + remark + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_vd_entry_date) {
						entryDate = getDateVal(tableName);
						pstat.setString(pos[idx], entryDate);
						System.out.println("From addVahicalValues  entryDate setting values " + entryDate + "  -->Col No" + pos[idx]);


					}

				}


			}

			int insertVal = pstat.executeUpdate();
			//boolean insertVal=pstat.execute();

			System.out.println("From DB addVahicalValues row inserted");
			if (insertVal > 0) {
				System.out.println("Value from exUpdate--->" + insertVal);


			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "From addVahicalValues Error My Dear : " + ex);
		}


	}

	public void addMaterialDetails(Connection con, String materialName, String materialSize, String materialQty, String materialPrice, String remark, int vOoZ) {


		String tableName = "material_detail";
		try {
			stat = con.createStatement();
			result = stat.executeQuery("select * from " + tableName);

			rsmd = result.getMetaData();

			columnCount = rsmd.getColumnCount();

			tableName = rsmd.getTableName(columnCount);

			int[] pos = new int[columnCount];

			int posValue = 0;

			System.out.println("From DB addVahicalValues column Count is " + (columnCount));

			for (int idxVar = 0; idxVar < pos.length; idxVar++) {
				posValue = idxVar;
				pos[idxVar] = ++posValue;

				System.out.println("From DB addVahicalValues putting values" + pos[idxVar]);

			}
			getTabColNames(tableName, rsmd, columnCount);


			pstat = con.prepareStatement("insert into " + tableName + " values(?,?,?,?,?,?,?)");

			if (vOoZ == 0) {


				for (int idx = 0; idx < pos.length; idx++)

				{


					if (pos[idx] == col_md_ID) {
						int uniQID = genUniId(con, tableName);
						pstat.setInt(pos[idx], uniQID);
						System.out.println("From addVahicalValues  ID setting values " + uniQID + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_md_material_name) {

						pstat.setString(pos[idx], materialName);
						System.out.println("From addVahicalValues VehicalName setting values " + materialName + "  -->Col No" + pos[idx]);


					}
					if (pos[idx] == col_md_material_size) {

						pstat.setString(pos[idx], materialSize);
						System.out.println("From addVahicalValues VehicalName setting values " + materialSize + "  -->Col No" + pos[idx]);

					}

					if (pos[idx] == col_md_material_qty) {
						pstat.setString(pos[idx], materialQty);
						System.out.println("From addVahicalValues  VehicalFuelType setting values " + materialQty + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_md_material_price) {
						pstat.setString(pos[idx], materialPrice);
						System.out.println("From addVahicalValues  VehicalModel setting values " + materialPrice + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_md_remark) {
						pstat.setString(pos[idx], remark);
						System.out.println("From addVahicalValues  VehicalYear setting values " + remark + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_md_entry_date) {
						entryDate = getDateVal(tableName);
						pstat.setString(pos[idx], entryDate);
						System.out.println("From addVahicalValues  entryDate setting values " + entryDate + "  -->Col No" + pos[idx]);


					}

				}

			} else {
				for (int idx = 0; idx < pos.length; idx++) {


					if (pos[idx] == col_md_ID) {
						int uniQID = genUniId(con, tableName);
						pstat.setInt(pos[idx], uniQID);
						System.out.println("From addVahicalValues  ID setting values " + uniQID + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_md_material_name) {

						pstat.setString(pos[idx], materialName);
						System.out.println("From addVahicalValues VehicalName setting values " + materialName + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_md_material_qty) {
						pstat.setString(pos[idx], materialQty);
						System.out.println("From addVahicalValues  VehicalFuelType setting values " + materialQty + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_md_material_price) {
						pstat.setString(pos[idx], materialPrice);
						System.out.println("From addVahicalValues  VehicalModel setting values " + materialPrice + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_md_remark) {
						pstat.setString(pos[idx], remark);
						System.out.println("From addVahicalValues  VehicalYear setting values " + remark + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_md_entry_date) {
						entryDate = getDateVal(tableName);
						pstat.setString(pos[idx], entryDate);
						System.out.println("From addVahicalValues  entryDate setting values " + entryDate + "  -->Col No" + pos[idx]);


					}


				}


			}

			int insertVal = pstat.executeUpdate();
			//boolean insertVal=pstat.execute();

			System.out.println("From DB addVahicalValues row inserted");
			if (insertVal > 0) {
				System.out.println("Value from exUpdate--->" + insertVal);


			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "From addVahicalValues Error My Dear : " + ex);
		}


	}

	public String getMultiTabData(Connection con, String col1, String col2, String tables) {

		String colArr = col1 + ":" + col2;
		String cols[] = colArr.split(":");
		String coldata = "";

		try {

			if (tables.contains(",")) {
				String[] tableArr = tables.split(",");


				if (tableArr.length == cols.length)
					for (int i = 0; i < tableArr.length; i++) {


						stat = con.createStatement();

						if (!(tableArr[i].trim().equals(""))) {

//							JOptionPane.showMessageDialog(null,"Checking Column Values"+cols[i]+" "+tableArr[i],"Columns",0);

							result = stat.executeQuery("select " + cols[i] + " from " + tableArr[i] + "");

							//					JOptionPane.showMessageDialog(null,"Checking Column Values.. OK","Columns",0);

							String[] colArrays = null;
							if (cols[i].contains(","))
								colArrays = cols[i].split(",");

							while (result.next()) {

								//						JOptionPane.showMessageDialog(null,"Checking Column Values.. OK inside while","Columns",0);

								for (int idx = 0; idx < colArrays.length; idx++) {

									int idxV = idx + 1;
									String resValue = result.getString(idxV);
									//JOptionPane.showMessageDialog(null,"Checking Column Values.. OK inside for V-->"+resValue,"Columns",0);

									coldata += resValue + ":";

									System.out.println("From DB getColData getting  value -->" + coldata);
								}
								coldata += "-";
								//data=data+value;

							}

						}
						coldata += ",";


					}


//				JOptionPane.showMessageDialog(null,"Column Values"+coldata,"Columns",0);
			}


		} catch (Exception ex) {

			System.out.println("From Outer catch --->" + ex);
		}


		return coldata;
	}



	public String getListWithCondition(String string, Connection con, String tabName, String gstFlagsVal, String colName, int id, String[] searchColNames, String colVal) {


		if (string.equals("order")) {


			String values = "";
			try {
				System.out.println("getting from " + string);
				Statement	stat = con.createStatement();


				ResultSet result;
				if (gstFlagsVal.equals("stategst")) {

					result = stat.executeQuery("select * from " + tabName+" where SEARCH_KEY Like '%igst all%'");
					while (result.next()) {

						values += result.getString(1) + ":" + result.getString(2) + ",";


					}

				}

				else if (gstFlagsVal.equals("localgst")){

					result = stat.executeQuery("select * from " + tabName+" where SEARCH_KEY Like '%cgst all%'");
					while (result.next()) {

						values += result.getString(1) + ":" + result.getString(2) + ",";


					}

				}
				else if (gstFlagsVal.equals("normalgst")) {

					result = stat.executeQuery("select * from " + tabName + " where SEARCH_KEY Like '%normal gst all%%'");
					while (result.next()) {

						values += result.getString(1) + ":" + result.getString(2) + ",";


					}
				}
			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return values;


		}
		else if (string.equals("receipt")) {


			String values = "";
			try {
				System.out.println("getting from " + string);
				Statement	stat = con.createStatement();


				ResultSet result;
				if (gstFlagsVal.equals("stategst")) {

					result = stat.executeQuery("select * from " + tabName+" where SEARCH_KEY Like '%igst all%'");
					while (result.next()) {

						values += result.getString(1) + ":" + result.getString(2) + ",";


					}

				}

				else if (gstFlagsVal.equals("localgst")){

					result = stat.executeQuery("select * from " + tabName+" where SEARCH_KEY Like '%cgst all%'");
					while (result.next()) {

						values += result.getString(1) + ":" + result.getString(2) +  ",";


					}

				}
				else if (gstFlagsVal.equals("normalgst")) {

					result = stat.executeQuery("select * from " + tabName + " where SEARCH_KEY Like '%normal gst all%%'");
					while (result.next()) {

						values += result.getString(1) + ":" + result.getString(2) +  ",";


					}
				}
			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return values;


		}


		else if (string.equals("combodoctor")) {


			String values = "";
			try {
				System.out.println("getting from " + string);
				Statement	stat = con.createStatement();


				ResultSet result = stat.executeQuery("select ID,"+colName+" from " + tabName);

				while (result.next()) {

					values += result.getString(1) + ":" + result.getString(2) + ",";


				}

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return values;


		}else if (string.equals("combopatient")) {


			String values = "";
			try {
				System.out.println("getting from " + string);
				Statement   stat = con.createStatement();


				ResultSet result = stat.executeQuery("select ID,"+colName+" from " + tabName);

				while (result.next()) {

					values += result.getString(1) + ":" + result.getString(2) + ",";


				}

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return values;


		}

		else if (string.equals("combosamplecollectionbranch")) {


			String values = "";
			try {
				System.out.println("getting from " + string);
				Statement   stat = con.createStatement();


				ResultSet result = stat.executeQuery("select ID,"+colName+" from " + tabName);

				while (result.next()) {

					values += result.getString(1) + ":" + result.getString(2) + ",";


				}

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return values;


		}
		else if (string.equals("combotestgroup")) {


			String values = "";
			try {
				System.out.println("getting from " + string);
				Statement   stat = con.createStatement();


				ResultSet result = stat.executeQuery("select ID,"+colName+" from " + tabName);

				while (result.next()) {

					values += result.getString(1) + ":" + result.getString(2) + ",";


				}

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return values;


		}
		else if (string.equals("combotestgrouprates") || string.equals("combotestgroupratessearch")) {


			String values = "";
			try {
				System.out.println("getting from " + string);
				Statement   stat = con.createStatement();


				ResultSet result =null;


				if (string.equals("combotestgrouprates")) {
					result=stat.executeQuery("select id," + colName + " from " + tabName + " where id=" + id);
				}
				else {

					for(int i = 0; i<searchColNames.length ;i++) {

						if (searchColNames[i].equalsIgnoreCase("id")
								|| searchColNames[i].equalsIgnoreCase("test_group_id")) {
							boolean numFlag = isValid(colVal);

							if (numFlag == true) {

								result = stat.executeQuery("select id," + colName + " from " + tabName + " where " + searchColNames[i]
										+ " =" + colVal + "");

								break;
							}
							else {
								continue;
							}
						} else {

							result = stat.executeQuery("select id," + colName + " from " + tabName + " where " + searchColNames[i]
									+ " Like '%" + colVal + "%'");

							break;
						}


					}


				}
				while (result.next()) {

					values = result.getString(1) + ":" + result.getString(2)+ ":" + result.getString(3);


				}

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return values;


		}

		else if (string.equals("transport")){

			String values = "";
			try {
				System.out.println("getting from " + string);
				Statement   stat = con.createStatement();


				ResultSet	result = stat.executeQuery("select * from " + tabName);

				while (result.next()) {

					values += result.getString(1) + ":" + result.getString(2) + ",";


				}

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return values;


		}

		else if (string.equals("item")) {

			String values = "--";
			try {
				System.out.println("getting from " + string);
				Statement   stat = con.createStatement();


				ResultSet result = stat.executeQuery("select * from " + tabName);

				while (result.next()) {

					values = values+ "," + result.getString(1) + ":" + result.getString(2) + ",";


				}

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return values;


		}else if (string.equals("goods_names")) {

			String values = "--";
			try {
				System.out.println("getting from " + string);
				Statement	stat = con.createStatement();


				ResultSet result = stat.executeQuery("select * from " + tabName);

				while (result.next()) {

					values = values+ "," + result.getString(1) + ":" + result.getString(2) + ":" + result.getString(3) + ",";


				}
				/*if (gstFlagsVal.equals("stategst")) {

					result = stat.executeQuery("select * from " + tabName+" where SEARCH_KEY Like '%igst all%'");
					while (result.next()) {

						values = values+ "," + result.getString(1) + ":" + result.getString(2) + ":" + result.getString(3) + ",";


					}

				}

			 else if (gstFlagsVal.equals("localgst")){

					result = stat.executeQuery("select * from " + tabName+" where SEARCH_KEY Like '%cgst all%'");
					while (result.next()) {

						values += result.getString(1) + ":" + result.getString(2) + ":" + result.getString(3) + ",";


					}

				}
			else if (gstFlagsVal.equals("normalgst")){

					result = stat.executeQuery("select * from " + tabName+" where SEARCH_KEY Like '%normal gst all%%'");
					while (result.next()) {

						values += result.getString(1) + ":" + result.getString(2) + ":" + result.getString(3) + ",";


					}
			}
*/

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return values;


		}
		else if (string.equals("gstTypes")) {

			String values = "";
			try {
				System.out.println("getting from " + string);
				Statement   stat = con.createStatement();

				ResultSet	result = stat.executeQuery("select * from " + tabName);

				while (result.next()) {

					values += result.getString(1) + ":" + result.getString(2)+ ":" + result.getString(3) + ",";


				}

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return values;


		}
		else if (string.equals("vendor")) {


			String values = "";
			try {
				System.out.println("getting from " + string);
				Statement stat = con.createStatement();


				ResultSet result = stat.executeQuery("select name from vendor");

				while (result.next()) {

					values += result.getString(1) + ",";


				}

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return values;


		}

		return "";
	}


	public String getSum(String strKey, Connection con, String tableName, String gstFlagsVal, String colName,String colVal)
	{

		if (strKey.equalsIgnoreCase("CR") || strKey.equalsIgnoreCase("DR")) {


			String values = "";
			try {
				System.out.println("getting from " + strKey);
				Statement   stat = con.createStatement();


				ResultSet result=null;
				if (strKey.equalsIgnoreCase("CR"))
					result = stat.executeQuery("select sum("+colName+") from " + tableName +" WHERE cred_debt = 'CR'");
				else if (strKey.equalsIgnoreCase("DR"))
					result = stat.executeQuery("select sum("+colName+") from " + tableName +" WHERE cred_debt = 'DR'");


				while (result.next()) {

					values = result.getString(1);


				}

			} catch (Exception ex) {
				System.out.println("Error From Total getList-->" + ex);
			}
			return values;


		}
      return   "";
	}


	public String getValue(String string, Connection con, String tabName, String colName, int empId) {
		if (string.equalsIgnoreCase("OTRate")) {


			String value = "";
			try {
				System.out.println("getting from " + string);
				Statement stat = con.createStatement();


				ResultSet result = stat.executeQuery("select " + colName + " from " + tabName + " where emp_id ="+empId);

				if (result.next()) {

					value = result.getString(1) ;

				}


			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return value;


		}
		return "";
	}
	public String getList(String string, Connection con, String tabName, String gstFlagsVal, String colName, int docId) {
		if (string.equalsIgnoreCase("branchList")) {


			String values = "";
			try {
				System.out.println("getting from " + string);
				Statement	stat = con.createStatement();


				ResultSet result = stat.executeQuery("select "+colName+" from " + tabName+"");

				while (result.next()) {

					values += result.getString(1) + ":" + result.getString(2) +",";

				}


			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return values;


		}
		else if (string.equals("combouserids")) {


			String values = "";
			try {
				System.out.println("getting from " + string);
				Statement	stat = con.createStatement();


				ResultSet result = stat.executeQuery("select "+colName+" from " + tabName);

				while (result.next()) {

					values += result.getString(1)+":"+result.getString(2) + ",";


				}

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return values;


		}



		else if (string.equals("order")) {


			String values = "";
			try {
				System.out.println("getting from " + string);
				Statement	stat = con.createStatement();


				ResultSet result;
				if (gstFlagsVal.equals("stategst")) {

					result = stat.executeQuery("select * from " + tabName+" where SEARCH_KEY Like '%igst all%'");
					while (result.next()) {

						values += result.getString(1) + ":" + result.getString(2) + ",";


					}

				}

				else if (gstFlagsVal.equals("localgst")){

					result = stat.executeQuery("select * from " + tabName+" where SEARCH_KEY Like '%cgst all%'");
					while (result.next()) {

						values += result.getString(1) + ":" + result.getString(2) + ",";


					}

				}
				else if (gstFlagsVal.equals("normalgst")) {

					result = stat.executeQuery("select * from " + tabName + " where SEARCH_KEY Like '%normal gst all%%'");
					while (result.next()) {

						values += result.getString(1) + ":" + result.getString(2) + ",";


					}
				}
			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return values;


		}
		else if (string.equals("receipt")) {


			String values = "";
			try {
				System.out.println("getting from " + string);
				Statement	stat = con.createStatement();


				ResultSet result;
				if (gstFlagsVal.equals("stategst")) {

					result = stat.executeQuery("select * from " + tabName+" where SEARCH_KEY Like '%igst all%'");
					while (result.next()) {

						values += result.getString(1) + ":" + result.getString(2) + ",";


					}

				}

				else if (gstFlagsVal.equals("localgst")){

					result = stat.executeQuery("select * from " + tabName+" where SEARCH_KEY Like '%cgst all%'");
					while (result.next()) {

						values += result.getString(1) + ":" + result.getString(2) +  ",";


					}

				}
				else if (gstFlagsVal.equals("normalgst")) {

					result = stat.executeQuery("select * from " + tabName + " where SEARCH_KEY Like '%normal gst all%%'");
					while (result.next()) {

						values += result.getString(1) + ":" + result.getString(2) +  ",";


					}
				}
			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return values;


		}

		else if (string.equals("comboListFirm")) {


			String values = "";
			try {
				System.out.println("getting from " + string);
				Statement	stat = con.createStatement();


				ResultSet result = stat.executeQuery("select ID,"+colName+" from " + tabName);

				while (result.next()) {

					values += result.getString(1)+":"+result.getString(2) + ",";


				}

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return values;


		}

		else if (string.equals("comboDoctorDegree")) {


            String values = "";
            try {
                System.out.println("getting from " + string);
                Statement	stat = con.createStatement();


                ResultSet result = stat.executeQuery("select "+colName+" from " + tabName);

                while (result.next()) {

                    values += result.getString(1) + ",";


                }

            } catch (Exception ex) {
                System.out.println("Error From getList-->" + ex);
            }
            return values;


        }
		else if (string.equals("combodoctor")) {


			String values = "";
			try {
				System.out.println("getting from " + string);
				Statement	stat = con.createStatement();


				ResultSet result = stat.executeQuery("select ID,"+colName+" from " + tabName);

				while (result.next()) {

					values += result.getString(1) + ":" + result.getString(2) + ",";


				}

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return values;


		}

		else if (string.equals("comboMethod")) {


			String values = "";
			try {
				System.out.println("getting from " + string);
				Statement   stat = con.createStatement();


				ResultSet result = stat.executeQuery("select ID,"+colName+" from " + tabName);

				while (result.next()) {

					values += result.getString(1) + ":" + result.getString(2) + ",";


				}

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return values;


		}

		else if (string.equals("comboLabIdTestReport") || string.equals("comboLabIdTestReceipt")
				|| string.equals("comboLabIdTestReportUpdated")) {


			String values = "";
			try {
				System.out.println("getting from " + string);
				Statement   stat = con.createStatement();


				ResultSet result =null;

				if (string.equals("comboLabIdTestReport")) {

					result = stat.executeQuery("select DISTINCT " + colName + " from " + tabName + " where RESFLAG = 0");
				}
				else if (string.equals("comboLabIdTestReportUpdated")) {

					result = stat.executeQuery("select DISTINCT " + colName + " from " + tabName + " where RESFLAG != 0");
				}
				else
				{
					result = stat.executeQuery("select DISTINCT " + colName + " from " + tabName);

				}

				while (result.next()) {

					values += result.getString(1) + ",";


				}

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return values;


		}

		else if (string.equals("combopatient") || string.equals("comboPatientTestReport") || string.equals("comboPatientTestReceipt")
				|| string.equals("comboPatientTestReportUpdated")) {


			String values = "";
			try {
				System.out.println("getting from " + string);
				Statement   stat = con.createStatement();

				ResultSet result =null;

				if (string.equals("combopatient")) {
					result = stat.executeQuery("select " + colName + ",ID from " + tabName);
				}
				else if(string.equals("comboPatientTestReport"))
				{
					result = stat.executeQuery("select DISTINCT PATIENT_ID , " + colName + " from " + tabName +" where RESFLAG = 0");

				}
				else if (string.equals("comboPatientTestReportUpdated")) {

					result = stat.executeQuery("select DISTINCT PATIENT_ID , " + colName + " from " + tabName +" where RESFLAG != 0");
				}

				else if(string.equals("comboPatientTestReceipt"))
				{
					result = stat.executeQuery("select DISTINCT PATIENT_ID , " + colName + " from " + tabName);

				}


				while (result.next()) {

					values += result.getString(1) + ":" + result.getString(2) + ",";


				}

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return values;


		}

		else if (string.equals("combosamplecollectionbranch")) {


			String values = "";
			try {
				System.out.println("getting from " + string);
				Statement   stat = con.createStatement();


				ResultSet result = stat.executeQuery("select ID,"+colName+" from " + tabName);

				while (result.next()) {

					values += result.getString(1) + ":" + result.getString(2) + ",";


				}

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return values;


		}
		else if (string.equals("combotestgroup") || string.equals("comboIncomeTestGroup") || string.equals("combodoctestgroup"))
		{


			String values = "";
			try {
				System.out.println("getting from " + string);
				Statement   stat = con.createStatement();

				ResultSet result = null;


				if(string.equals("combodoctestgroup"))
				{



					result = stat.executeQuery("select ID,"+colName+" from " + tabName+" where DOC_ID ="+docId);


				}
				else
				{

					result = stat.executeQuery("select ID,"+colName+" from " + tabName);


				}

				while (result.next()) {

					values += result.getString(1) + ":" + result.getString(2) + ",";


				}


			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return values;


		}
		else if (string.equals("combotestgrouprates")) {


			String values = "";
			try {
				System.out.println("getting from " + string);
				Statement   stat = con.createStatement();


				ResultSet result = stat.executeQuery("select ID,"+colName+" from " + tabName);

				while (result.next()) {

					values += result.getString(1) + ":" + result.getString(2) + ",";


				}

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return values;


		}

		else if (string.equals("transport")){

			String values = "";
			try {
				System.out.println("getting from " + string);
				Statement   stat = con.createStatement();


				ResultSet	result = stat.executeQuery("select * from " + tabName);

				while (result.next()) {

					values += result.getString(1) + ":" + result.getString(2) + ",";


				}

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return values;


		}

		else if (string.equals("item")) {

			String values = "--";
			try {
				System.out.println("getting from " + string);
				Statement   stat = con.createStatement();


				ResultSet result = stat.executeQuery("select * from " + tabName);

				while (result.next()) {

					values = values+ "," + result.getString(1) + ":" + result.getString(2) + ",";


				}

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return values;


		}else if (string.equals("goods_names")) {

			String values = "--";
			try {
				System.out.println("getting from " + string);
			Statement	stat = con.createStatement();


			ResultSet result = stat.executeQuery("select * from " + tabName);

			while (result.next()) {

					values = values+ "," + result.getString(1) + ":" + result.getString(2) + ":" + result.getString(3) + ",";


				}
				/*if (gstFlagsVal.equals("stategst")) {

					result = stat.executeQuery("select * from " + tabName+" where SEARCH_KEY Like '%igst all%'");
					while (result.next()) {

						values = values+ "," + result.getString(1) + ":" + result.getString(2) + ":" + result.getString(3) + ",";


					}

				}

			 else if (gstFlagsVal.equals("localgst")){

					result = stat.executeQuery("select * from " + tabName+" where SEARCH_KEY Like '%cgst all%'");
					while (result.next()) {

						values += result.getString(1) + ":" + result.getString(2) + ":" + result.getString(3) + ",";


					}

				}
			else if (gstFlagsVal.equals("normalgst")){

					result = stat.executeQuery("select * from " + tabName+" where SEARCH_KEY Like '%normal gst all%%'");
					while (result.next()) {

						values += result.getString(1) + ":" + result.getString(2) + ":" + result.getString(3) + ",";


					}
			}
*/

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return values;


		}
		else if (string.equals("gstTypes")) {

			String values = "";
			try {
				System.out.println("getting from " + string);
				Statement   stat = con.createStatement();

				ResultSet	result = stat.executeQuery("select * from " + tabName);

				while (result.next()) {

					values += result.getString(1) + ":" + result.getString(2)+ ":" + result.getString(3) + ",";


				}

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return values;


		}
		else if (string.equals("vendor")) {


			String values = "";
			try {
				System.out.println("getting from " + string);
				Statement stat = con.createStatement();


				ResultSet result = stat.executeQuery("select name from vendor");

				while (result.next()) {

					values += result.getString(1) + ",";


				}

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}
			return values;


		}

		return "";
	}


    int updateAllowancedetail(Connection con, String tableName, float ratePerHr, float overtimeHours,float totalOverTime,float medical, float bonus, float other,int empId)
	{

try {
	PreparedStatement pstat = con.prepareStatement("update " + tableName + " set rate =?,ot_hrs=?,overtime=?, medical=?, bonus =? , other=? where emp_id = ?");
	pstat.setFloat(1, ratePerHr);
	pstat.setFloat(2,overtimeHours);
	pstat.setFloat(3,totalOverTime);
	pstat.setFloat(4, medical);
	pstat.setFloat(5, bonus);
	pstat.setFloat(6, other);
	pstat.setInt(7, empId);

	int insertVal = pstat.executeUpdate();
	if (insertVal > 0) {
		System.out.println("Value from exUpdate--->" + insertVal);
		//JOptionPane.showMessageDialog(null, "Updated!!");

		return insertVal;

	    }
     }
     catch (Exception e)
			{
		e.printStackTrace();

			}

		return 0;
	}

	public int addPathoLabOrPatientOrDocDetails(Connection con, String tableName, String name, String sex, String age, String emailId, String phoneNo, String phoneNo2, String phoneNo3, String address, String address2, String address3, String remark, int vOoZ, int bId, String degree, float commission, float fees,float actAmt, String testReport, String tableNameReceiptDTL, String tableNameReportDTL, String childOrAdult) {
       int uniqId=0;

		try {

			/*for (int idxVar = 0; idxVar < pos.length; idxVar++) {
				posValue = idxVar;
				pos[idxVar] = ++posValue;

				System.out.println("From DB addVahicalValues putting values" + pos[idxVar]);

			}*/
				//getTabColNames(tableName, rsmd, columnCount);


				if (vOoZ == 0) {

                        //tableName = rsmd.getTableName(columnCount);

                        //int[] pos = new int[columnCount];

                        int posValue = 0;

                        //System.out.println("From DB addVahicalValues column Count is " + (columnCount));


                        if (tableName.equalsIgnoreCase("patho_lab_detail") || tableName.equalsIgnoreCase("simple_patho_lab_detail")) {
							String entryDate = "";



							//JOptionPane.showMessageDialog(null, "columnCount " + columnCount);


							try {

								Statement stat = con.createStatement();
								ResultSet resultId = stat.executeQuery("select ID from " + tableName + " where PHONE_NO='" + phoneNo + "'");

								if (resultId.next()) {

									return Integer.parseInt(resultId.getString(1));

								} else {

									ResultSet result = stat.executeQuery("select * from " + tableName + " where PHONE_NO='" + phoneNo + "'");

									ResultSetMetaData rsmd = result.getMetaData();

									int columnCount = rsmd.getColumnCount();


									PreparedStatement pstat = con.prepareStatement("insert into " + tableName + " values(?,?,?,?,?,?,?,?,?,?,?)");


								for (int i = 1; i <= columnCount; i++) {


									System.out.println("party_detail i value " + i);

									if (rsmd.getColumnName(i).equals("ID")) {
										//uniqId = genUniId(con, tableName);
										uniqId = 1;
										pstat.setInt(i, uniqId);
										System.out.println("From addVahicalValues  ID setting values " + uniqId + "  -->Col No" + i);


									}


									if (rsmd.getColumnName(i).equals("PATHO_LAB_NAME")) {

										pstat.setString(i, name);
										System.out.println("From addVahicalValues VehicalName setting values " + name + "  -->Col No" + i);


									}

									if (rsmd.getColumnName(i).equals("PHONE_NO")) {
										pstat.setString(i, phoneNo);
										System.out.println("From addVahicalValues  VehicalFuelType setting values " + phoneNo + "  -->Col No" + i);


									}

									if (rsmd.getColumnName(i).equals("PHONE_NO2")) {
										pstat.setString(i, phoneNo2);
										System.out.println("From addVahicalValues  VehicalFuelType setting values " + phoneNo2 + "  -->Col No" + i);


									}
									if (rsmd.getColumnName(i).equals("PHONE_NO3")) {
										pstat.setString(i, phoneNo3);
										System.out.println("From addVahicalValues  VehicalFuelType setting values " + phoneNo3 + "  -->Col No" + i);


									}


									if (rsmd.getColumnName(i).equals("EMAIL_ID")) {

										pstat.setString(i, emailId);
										System.out.println("From addVahicalValues  VehicalFuelType setting values " + emailId + "  -->Col No" + i);

									}


									if (rsmd.getColumnName(i).equals("ADDRESS")) {
										pstat.setString(i, address);
										System.out.println("From addVahicalValues  VehicalModel setting values " + address + "  -->Col No" + i);


									}

									if (rsmd.getColumnName(i).equals("ADDRESS2")) {
										pstat.setString(i, address2);
										System.out.println("From addVahicalValues  VehicalModel setting values " + address2 + "  -->Col No" + i);


									}
									if (rsmd.getColumnName(i).equals("ADDRESS3")) {
										pstat.setString(i, address3);
										System.out.println("From addVahicalValues  VehicalModel setting values " + address3 + "  -->Col No" + i);


									}

									if (rsmd.getColumnName(i).equals("REMARK")) {
										pstat.setString(i, remark);
										System.out.println("From addVahicalValues  VehicalYear setting values " + remark + "  -->Col No" + i);


									}

									if (rsmd.getColumnName(i).equals("ENTRY_DATE")) {
										entryDate = getDateVal(tableName);
										pstat.setString(i, entryDate);
										System.out.println("From addVahicalValues  entryDate setting values " + entryDate + "  -->Col No" + i);


									}

								}


								int insertVal = pstat.executeUpdate();
								//boolean insertVal=pstat.execute();

								System.out.println("From DB addVahicalValues row inserted");
								if (insertVal > 0) {
									System.out.println("Value from exUpdate--->" + insertVal);

									JOptionPane.showMessageDialog(null, "Done!!");

									return uniqId;
								}

							}
							} catch (Exception e) {
								entryDate = getDateVal(tableName);


								PreparedStatement pstat = con.prepareStatement("update " + tableName + " set PATHO_LAB_NAME = ? ,PHONE_NO= ?,PHONE_NO2= ?,PHONE_NO3= ?, EMAIL_ID = ?,ADDRESS  = ?,ADDRESS2  = ?,ADDRESS3  = ?, REMARK = ?,ENTRY_DATE = ? where ID = ?");


								pstat.setString(1, name);
								pstat.setString(2, phoneNo);
								pstat.setString(3, phoneNo2);
								pstat.setString(4, phoneNo3);

								pstat.setString(5, emailId);
								pstat.setString(6, address);
								pstat.setString(7, address2);
								pstat.setString(8, address3);

								pstat.setString(9, remark);
								pstat.setString(10, entryDate);

								uniqId = 1;
								pstat.setInt(11, uniqId);

								int insertVal = pstat.executeUpdate();
								if (insertVal > 0) {
									System.out.println("Value from exUpdate--->" + insertVal);
									JOptionPane.showMessageDialog(null, "Updated!!");

									return uniqId;
								}


							}


                        } else if (tableName.equals("collection_branch_detail") || tableName.equals("simple_collection_branch_detail")) {
							String entryDate = "";


							//JOptionPane.showMessageDialog(null, "columnCount " + columnCount);
							Statement stat = con.createStatement();
							ResultSet resultId = stat.executeQuery("select ID from " + tableName + " where PHONE_NO='" + phoneNo + "'");

							if (resultId.next()) {

								return Integer.parseInt(resultId.getString(1));

							} else {

								ResultSet result = stat.executeQuery("select * from " + tableName + " where PHONE_NO='" + phoneNo + "'");

								ResultSetMetaData rsmd = result.getMetaData();

								int columnCount = rsmd.getColumnCount();


							PreparedStatement pstat = con.prepareStatement("insert into " + tableName + " values(?,?,?,?,?,?,?)");


							for (int i = 1; i <= columnCount; i++) {


								System.out.println("party_detail i value " + i);

								if (rsmd.getColumnName(i).equals("ID")) {
									uniqId = genUniId(con, tableName);
									pstat.setInt(i, uniqId);
									System.out.println("From addVahicalValues  ID setting values " + uniqId + "  -->Col No" + i);


								}


								if (rsmd.getColumnName(i).equals("BRANCH_NAME")) {

									pstat.setString(i, name);
									System.out.println("From addVahicalValues VehicalName setting values " + name + "  -->Col No" + i);


								}

								if (rsmd.getColumnName(i).equals("PHONE_NO")) {
									pstat.setString(i, phoneNo);
									System.out.println("From addVahicalValues  VehicalFuelType setting values " + phoneNo + "  -->Col No" + i);


								}


								if (rsmd.getColumnName(i).equals("EMAIL_ID")) {

									pstat.setString(i, emailId);
									System.out.println("From addVahicalValues  VehicalFuelType setting values " + emailId + "  -->Col No" + i);

								}


								if (rsmd.getColumnName(i).equals("ADDRESS")) {
									pstat.setString(i, address);
									System.out.println("From addVahicalValues  VehicalModel setting values " + address + "  -->Col No" + i);


								}


								if (rsmd.getColumnName(i).equals("REMARK")) {
									pstat.setString(i, remark);
									System.out.println("From addVahicalValues  VehicalYear setting values " + remark + "  -->Col No" + i);


								}

								if (rsmd.getColumnName(i).equals("ENTRY_DATE")) {
									entryDate = getDateVal(tableName);
									pstat.setString(i, entryDate);
									System.out.println("From addVahicalValues  entryDate setting values " + entryDate + "  -->Col No" + i);


								}

							}


							int insertVal = pstat.executeUpdate();
							//boolean insertVal=pstat.execute();

							System.out.println("From DB addVahicalValues row inserted");
							if (insertVal > 0) {
								System.out.println("Value from exUpdate--->" + insertVal);

								JOptionPane.showMessageDialog(null, "Done!!");

								return uniqId;
							}

						}
                        } else if (tableName.equals("doctor_detail") || tableName.equals("simple_doctor_detail")) {
							String entryDate = "";


							//JOptionPane.showMessageDialog(null, "columnCount " + columnCount);

							Statement stat = con.createStatement();
							//ResultSet resultId = stat.executeQuery("select ID from " + tableName + " where PHONE_NO='" + phoneNo + "'");

						/*	if (resultId.next()) {

								return Integer.parseInt(resultId.getString(1));

							} else {
*/
								ResultSet result = stat.executeQuery("select * from " + tableName + "");

								ResultSetMetaData rsmd = result.getMetaData();

								int columnCount = rsmd.getColumnCount();

								PreparedStatement pstat = con.prepareStatement("insert into " + tableName + " values(?,?,?,?,?,?,?,?,?,?,?)");


							for (int i = 1; i <= columnCount; i++) {

								System.out.println("buyer_detail i value " + i);

								if (rsmd.getColumnName(i).equals("ID")) {
									uniqId = genUniId(con, tableName);
									pstat.setInt(i, uniqId);
									System.out.println("From addVahicalValues  ID setting values " + uniqId + "  -->Col No" + i);


								}


								if (rsmd.getColumnName(i).equals("DOCTOR_NAME")) {

									pstat.setString(i, name);
									System.out.println("From addVahicalValues VehicalName setting values " + name + "  -->Col No" + i);


								}


								if (rsmd.getColumnName(i).equals("DEGREE")) {

									pstat.setString(i, degree);
									System.out.println("From addVahicalValues VehicalName setting values " + degree + "  -->Col No" + i);


								}


								if (rsmd.getColumnName(i).equals("COMMISN")) {

									pstat.setFloat(i, commission);
									System.out.println("From addVahicalValues VehicalName setting values " + commission + "  -->Col No" + i);


								}

								if (rsmd.getColumnName(i).equals("FEES")) {

									pstat.setFloat(i, fees);
									System.out.println("From addVahicalValues VehicalName setting values " + fees + "  -->Col No" + i);


								}

								if (rsmd.getColumnName(i).equals("ACT_AMT")) {

									pstat.setFloat(i, actAmt);
									System.out.println("From addVahicalValues VehicalName setting values " + actAmt + "  -->Col No" + i);


								}



								if (rsmd.getColumnName(i).equals("PHONE_NO")) {
									pstat.setString(i, phoneNo);
									System.out.println("From addVahicalValues  VehicalFuelType setting values " + phoneNo + "  -->Col No" + i);


								}


								if (rsmd.getColumnName(i).equals("EMAIL_ID")) {

									pstat.setString(i, emailId);
									System.out.println("From addVahicalValues  VehicalFuelType setting values " + emailId + "  -->Col No" + i);

								}


								if (rsmd.getColumnName(i).equals("ADDRESS")) {
									pstat.setString(i, address);
									System.out.println("From addVahicalValues  VehicalModel setting values " + address + "  -->Col No" + i);


								}


								if (rsmd.getColumnName(i).equals("REMARK")) {
									pstat.setString(i, remark);
									System.out.println("From addVahicalValues  VehicalYear setting values " + remark + "  -->Col No" + i);


								}

								if (rsmd.getColumnName(i).equals("ENTRY_DATE")) {
									entryDate = getDateVal(tableName);
									pstat.setString(i, entryDate);
									System.out.println("From addVahicalValues  entryDate setting values " + entryDate + "  -->Col No" + i);


								}

							}


							int insertVal = pstat.executeUpdate();
							//boolean insertVal=pstat.execute();

							System.out.println("From DB addVahicalValues row inserted");
							if (insertVal > 0) {
								System.out.println("Value from exUpdate--->" + insertVal);

								JOptionPane.showMessageDialog(null, "Done!!");

								return uniqId;
							}


                        } else if (tableName.equals("patient_detail") || tableName.equals("simple_patient_detail")) {
                            String entryDate = "";


                            //JOptionPane.showMessageDialog(null, "columnCount " + columnCount);

							Statement stat = con.createStatement();
								ResultSet result = stat.executeQuery("select * from " + tableName + "");// where PHONE_NO='" + phoneNo + "'

								ResultSetMetaData rsmd = result.getMetaData();

								int columnCount = rsmd.getColumnCount();


								PreparedStatement pstat = con.prepareStatement("insert into " + tableName + " values(?,?,?,?,?,?,?,?,?,?,?)");


                            for (int i = 1; i <= columnCount; i++) {


                                System.out.println("party_detail i value " + i);

                                if (rsmd.getColumnName(i).equals("ID")) {
                                    uniqId = genUniId(con, tableName);
                                    pstat.setInt(i, uniqId);
                                    System.out.println("From addVahicalValues  ID setting values " + uniqId + "  -->Col No" + i);


                                }


                                if (rsmd.getColumnName(i).equals("PATIENT_NAME")) {

                                    pstat.setString(i, name);
                                    System.out.println("From addVahicalValues VehicalName setting values " + name + "  -->Col No" + i);


                                }


                                if (rsmd.getColumnName(i).equals("SEX")) {

                                    pstat.setString(i, sex);
                                    System.out.println("From addVahicalValues VehicalName setting values " + sex + "  -->Col No" + i);


                                }

                                if (rsmd.getColumnName(i).equals("AGE")) {
                                    pstat.setString(i, age);
                                    System.out.println("From addVahicalValues  VehicalFuelType setting values " + age + "  -->Col No" + i);


                                }

								if (rsmd.getColumnName(i).equals("CHILD_ADULT")) {
									pstat.setString(i, childOrAdult);
									System.out.println("From addVahicalValues  VehicalFuelType setting values " + childOrAdult + "  -->Col No" + i);


								}

                                if (rsmd.getColumnName(i).equals("PHONE_NO")) {
                                    pstat.setString(i, phoneNo);
                                    System.out.println("From addVahicalValues  VehicalFuelType setting values " + phoneNo + "  -->Col No" + i);


                                }


                                if (rsmd.getColumnName(i).equals("EMAIL_ID")) {

                                    pstat.setString(i, emailId);
                                    System.out.println("From addVahicalValues  VehicalFuelType setting values " + emailId + "  -->Col No" + i);

                                }

                                if (rsmd.getColumnName(i).equals("ADDRESS")) {
                                    pstat.setString(i, address);
                                    System.out.println("From addVahicalValues  VehicalModel setting values " + address + "  -->Col No" + i);


                                }


                                if (rsmd.getColumnName(i).equals("REMARK")) {
                                    pstat.setString(i, remark);
                                    System.out.println("From addVahicalValues  VehicalYear setting values " + remark + "  -->Col No" + i);


                                }

                                if (rsmd.getColumnName(i).equals("ENTRY_DATE")) {
                                    entryDate = getDateVal(tableName);
                                    pstat.setString(i, entryDate);
                                    System.out.println("From addVahicalValues  entryDate setting values " + entryDate + "  -->Col No" + i);


                                }

                                if (rsmd.getColumnName(i).equals("TEST_REPORT")) {
                                    pstat.setString(i, testReport);
                                    System.out.println("From addVahicalValues  entryDate setting values " + " ... " + "  -->Col No" + i);


                                }

                            }


                            int insertVal = pstat.executeUpdate();
                            //boolean insertVal=pstat.execute();

                            System.out.println("From DB addVahicalValues row inserted");
                            if (insertVal > 0) {
                                System.out.println("Value from exUpdate--->" + insertVal);

                                return uniqId;
                            }


                        }



                }else{
                    if (tableName.equalsIgnoreCase("patho_lab_detail") || tableName.equalsIgnoreCase("simple_patho_lab_detail"))
                    {
                            String entryDate = "";


                            PreparedStatement pstat = con.prepareStatement("update " + tableName + " set patho_lab_name = ? ,phone_no= ?, phone_no2 =? , phone_no3 = ?, email_id = ?,address = ?," +
                                " address2 = ?,address3 = ?,remark = ? where ID = ?");


                            pstat.setString(1, name);
                            pstat.setString(2, phoneNo);
                        pstat.setString(3, phoneNo2);
                        pstat.setString(4, phoneNo3);
                        pstat.setString(5, emailId);
                            pstat.setString(6, address);
                        pstat.setString(7, address2);
                        pstat.setString(8, address3);

                        pstat.setString(9, remark);

                            pstat.setInt(10, bId);

                            int insertVal = pstat.executeUpdate();
                            if (insertVal > 0) {
                                System.out.println("Value from exUpdate--->" + insertVal);
                                JOptionPane.showMessageDialog(null, "Updated!!");

                                return insertVal;

                            }


                        } else if (tableName.equalsIgnoreCase("doctor_detail") || tableName.equalsIgnoreCase("simple_doctor_detail")) {
                            String entryDate = "";

                            PreparedStatement pstat = con.prepareStatement("update " + tableName + " set doctor_name = ?, degree = ?, commisn = ? , phone_no = ?,email_id = ?, address = ?,remark = ? where ID = ?");


                            pstat.setString(1, name);
                            pstat.setString(2, degree);
                            pstat.setFloat(3, commission);
                            pstat.setString(4, phoneNo);
                            pstat.setString(5, emailId);
                            pstat.setString(6, address);
                            pstat.setString(7, remark);
                            pstat.setInt(8, bId);

                            int insertVal = pstat.executeUpdate();
                            if (insertVal > 0) {
                                System.out.println("Value from exUpdate--->" + insertVal);
                                JOptionPane.showMessageDialog(null, "Updated!!");

                                return insertVal;

                            }


                        } else if (tableName.equalsIgnoreCase("patient_detail") || tableName.equalsIgnoreCase("simple_patient_detail")) {
                            String entryDate = "";

                            PreparedStatement pstat = con.prepareStatement("update " + tableName + " set patient_name = ?, sex = ? , age = ?, phone_no = ?,email_id = ?, address = ? ,remark = ?,test_report = ? where ID = ?");


                            pstat.setString(1, name);
							pstat.setString(2, sex);
							pstat.setString(3, age);
                            pstat.setString(4, phoneNo);
                            pstat.setString(5, emailId);
                            pstat.setString(6, address);
                        pstat.setString(7, remark);
						pstat.setString(8, testReport);


						pstat.setInt(9, bId);

                            int insertVal = pstat.executeUpdate();
                            if (insertVal > 0) {

                            	System.out.println("Value from exUpdate--->" + insertVal);
                                //JOptionPane.showMessageDialog(null, "Updated!!");

								boolean flagReceipt=false;

								boolean flagReport=false;




								Statement statReceipt = con.createStatement();
								ResultSet resultIdReceipt = statReceipt.executeQuery("select PATIENT_ID from " + tableNameReceiptDTL + " where PATIENT_ID=" + bId + "");
								//return Integer.parseInt(resultId.getString(1));

								if (resultIdReceipt.next()) {

									//int patientIDReceipt=Integer.parseInt(resultIdReceipt.getString(1));
									int patientIDReceipt=resultIdReceipt.getInt(1);


									PreparedStatement pstatReceipt = con.prepareStatement("update " + tableNameReceiptDTL + " set PATIENT_NAME = ?," +
											"AGE = ?,GENDER = ?,CHILD_ADULT =?,MOBILE_NO = ?,EMAIL_ID = ?, ADDRESS = ? " +
											" where PATIENT_ID = ?");
									pstatReceipt.setString(1, name);
									pstatReceipt.setString(2, age);
									pstatReceipt.setString(3, sex);
									pstatReceipt.setString(4, childOrAdult);
									pstatReceipt.setString(5, phoneNo);
									pstatReceipt.setString(6, emailId);

									pstatReceipt.setString(7, address);
									pstatReceipt.setInt(8, patientIDReceipt);


									int updateValReceipt = pstatReceipt.executeUpdate();
									if (updateValReceipt > 0) {
										System.out.println("Value from exUpdate--->" + updateValReceipt);

										flagReceipt = true;


										Statement statReport = con.createStatement();
										ResultSet resultIdReport = statReport.executeQuery("select PATIENT_ID from " + tableNameReportDTL + " where PATIENT_ID=" + patientIDReceipt + "");
										//return Integer.parseInt(resultId.getString(1));

										if (resultIdReport.next()) {

											int patientIDReport=resultIdReport.getInt(1);

											//int patientIDReport=Integer.parseInt(resultIdReport.getString(1));

											PreparedStatement pstatReport = con.prepareStatement("update " + tableNameReportDTL + " set PATIENT_NAME = ?,GENDER = ?,AGE = ?," +
													"PHONE_NO = ?,ADDRESS = ?,REMARK = ?,CHILD_ADULT = ?,TEST_REMARKS = ? where PATIENT_ID = ?");
											pstatReport.setString(1, name);
											pstatReport.setString(2, sex);
											pstatReport.setString(3, age);
											pstatReport.setString(4, phoneNo);
											pstatReport.setString(5, address);
											pstatReport.setString(6, remark);
											pstatReport.setString(7, childOrAdult);
											pstatReport.setString(8, testReport);
											pstatReport.setInt(9, patientIDReport);


											int updateValReport = pstatReport.executeUpdate();
											if (updateValReport > 0) {
												System.out.println("Value from exUpdate--->" + updateValReport);

												flagReport = true;

												return updateValReport;

											}

										}
										else
										{


										}

									return updateValReceipt;

									}


								} else {



								}


                                return insertVal;

                            }


                            }
                            else if (tableName.equalsIgnoreCase("collection_branch_detail") || tableName.equalsIgnoreCase("simple_collection_branch_detail")) {
                        String entryDate = "";

                        PreparedStatement pstat = con.prepareStatement("update " + tableName + " set branch_name = ?, phone_no = ?,email_id = ?, address = ?,remark = ? where ID = ?");


                        pstat.setString(1, name);
                        pstat.setString(2, phoneNo);
                        pstat.setString(3, emailId);
                        pstat.setString(4, address);
                        pstat.setString(5, remark);

                        pstat.setInt(6, bId);

                        int insertVal = pstat.executeUpdate();
                        if (insertVal > 0) {
                            System.out.println("Value from exUpdate--->" + insertVal);
                            JOptionPane.showMessageDialog(null, "Updated!!");


                            return insertVal;
                        }


                    }




                }


		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "From addVahicalValues Error My Dear : " + ex);
		}


		return uniqId;
	}


	public boolean addBuyerDetails(Connection con, String tableName, String buyerName, String gstNo, String phoneNo, String address, String remark, int vOoZ, int bId) {


		try {
		Statement stat = con.createStatement();
		ResultSet	result = stat.executeQuery("select * from " + tableName +" where PHONE_NO='"+phoneNo+"'");

		if(result.next()){

		}
		else {
			ResultSetMetaData rsmd = result.getMetaData();

			int columnCount = rsmd.getColumnCount();

			//tableName = rsmd.getTableName(columnCount);

			//int[] pos = new int[columnCount];

			int posValue = 0;

			System.out.println("From DB addVahicalValues column Count is " + (columnCount));

			/*for (int idxVar = 0; idxVar < pos.length; idxVar++) {
				posValue = idxVar;
				pos[idxVar] = ++posValue;

				System.out.println("From DB addVahicalValues putting values" + pos[idxVar]);

			}*/
			//getTabColNames(tableName, rsmd, columnCount);


			if (vOoZ == 0) {

				if (tableName.equals("party_detail") || tableName.equals("simple_party_detail")) {
					String entryDate = "";


					//JOptionPane.showMessageDialog(null, "columnCount " + columnCount);


					PreparedStatement pstat = con.prepareStatement("insert into " + tableName + " values(?,?,?,?,?,?,?)");


					for (int i = 1; i <= columnCount; i++) {


						System.out.println("party_detail i value " + i);

						if (rsmd.getColumnName(i).equals("ID")) {
							int uniQID = genUniId(con, tableName);
							pstat.setInt(i, uniQID);
							System.out.println("From addVahicalValues  ID setting values " + uniQID + "  -->Col No" + i);


						}


						if (rsmd.getColumnName(i).equals("BUYER_NAME")) {

							pstat.setString(i, buyerName);
							System.out.println("From addVahicalValues VehicalName setting values " + buyerName + "  -->Col No" + i);


						}

						if (rsmd.getColumnName(i).equals("PHONE_NO")) {
							pstat.setString(i, phoneNo);
							System.out.println("From addVahicalValues  VehicalFuelType setting values " + phoneNo + "  -->Col No" + i);


						}


						if (rsmd.getColumnName(i).equals("GST_NO")) {

							pstat.setString(i, gstNo);
							System.out.println("From addVahicalValues  VehicalFuelType setting values " + gstNo + "  -->Col No" + i);

						}

						if (rsmd.getColumnName(i).equals("ADDRESS")) {
							pstat.setString(i, address);
							System.out.println("From addVahicalValues  VehicalModel setting values " + address + "  -->Col No" + i);


						}


						if (rsmd.getColumnName(i).equals("REMARK")) {
							pstat.setString(i, remark);
							System.out.println("From addVahicalValues  VehicalYear setting values " + remark + "  -->Col No" + i);


						}

						if (rsmd.getColumnName(i).equals("ENTRY_DATE")) {
							entryDate = getDateVal(tableName);
							pstat.setString(i, entryDate);
							System.out.println("From addVahicalValues  entryDate setting values " + entryDate + "  -->Col No" + i);


						}

					}


					int insertVal = pstat.executeUpdate();
					//boolean insertVal=pstat.execute();

					System.out.println("From DB addVahicalValues row inserted");
					if (insertVal > 0) {
						System.out.println("Value from exUpdate--->" + insertVal);

						return true;
					}


				} else if (tableName.equals("buyer_detail") || tableName.equals("simple_buyer_detail")) {
					String entryDate = "";


					//JOptionPane.showMessageDialog(null, "columnCount " + columnCount);

					PreparedStatement pstat = con.prepareStatement("insert into " + tableName + " values(?,?,?,?,?,?)");


					for (int i = 1; i <= columnCount; i++) {

						System.out.println("buyer_detail i value " + i);

						if (rsmd.getColumnName(i).equals("ID")) {
							int uniQID = genUniId(con, tableName);
							pstat.setInt(i, uniQID);
							System.out.println("From addVahicalValues  ID setting values " + uniQID + "  -->Col No" + i);


						}


						if (rsmd.getColumnName(i).equals("BUYER_NAME")) {

							pstat.setString(i, buyerName);
							System.out.println("From addVahicalValues VehicalName setting values " + buyerName + "  -->Col No" + i);


						}

						if (rsmd.getColumnName(i).equals("PHONE_NO")) {
							pstat.setString(i, phoneNo);
							System.out.println("From addVahicalValues  VehicalFuelType setting values " + phoneNo + "  -->Col No" + i);


						}


						if (rsmd.getColumnName(i).equals("ADDRESS")) {
							pstat.setString(i, address);
							System.out.println("From addVahicalValues  VehicalModel setting values " + address + "  -->Col No" + i);


						}


						if (rsmd.getColumnName(i).equals("REMARK")) {
							pstat.setString(i, remark);
							System.out.println("From addVahicalValues  VehicalYear setting values " + remark + "  -->Col No" + i);


						}

						if (rsmd.getColumnName(i).equals("ENTRY_DATE")) {
							entryDate = getDateVal(tableName);
							pstat.setString(i, entryDate);
							System.out.println("From addVahicalValues  entryDate setting values " + entryDate + "  -->Col No" + i);


						}

					}


					int insertVal = pstat.executeUpdate();
					//boolean insertVal=pstat.execute();

					System.out.println("From DB addVahicalValues row inserted");
					if (insertVal > 0) {
						System.out.println("Value from exUpdate--->" + insertVal);


						return true;
					}
				} else {
					String entryDate = "";


					JOptionPane.showMessageDialog(null, "columnCount " + columnCount);


					PreparedStatement pstat = con.prepareStatement("insert into " + tableName + " values(?,?,?,?,?,?)");


					for (int i = 1; i <= columnCount; i++) {

						System.out.println(tableName + " i value " + i);

						if (rsmd.getColumnName(i).equals("ID")) {
							int uniQID = genUniId(con, tableName);
							pstat.setInt(i, uniQID);
							System.out.println("From addVahicalValues  ID setting values " + uniQID + "  -->Col No" + i);


						}


						if (rsmd.getColumnName(i).equals("BUYER_NAME")) {

							pstat.setString(i, buyerName);
							System.out.println("From addVahicalValues VehicalName setting values " + buyerName + "  -->Col No" + i);


						}


						if (rsmd.getColumnName(i).equals("PHONE_NO")) {
							pstat.setString(i, phoneNo);
							System.out.println("From addVahicalValues  VehicalFuelType setting values " + phoneNo + "  -->Col No" + i);


						}


						if (rsmd.getColumnName(i).equals("ADDRESS")) {
							pstat.setString(i, address);
							System.out.println("From addVahicalValues  VehicalModel setting values " + address + "  -->Col No" + i);


						}

						if (rsmd.getColumnName(i).equals("REMARK")) {
							pstat.setString(i, remark);
							System.out.println("From addVahicalValues  VehicalYear setting values " + remark + "  -->Col No" + i);


						}

						if (rsmd.getColumnName(i).equals("ENTRY_DATE")) {
							entryDate = getDateVal(tableName);
							pstat.setString(i, entryDate);
							System.out.println("From addVahicalValues  entryDate setting values " + entryDate + "  -->Col No" + i);


						}

					}


					int insertVal = pstat.executeUpdate();
					//boolean insertVal=pstat.execute();

					System.out.println("From DB addVahicalValues row inserted");
					if (insertVal > 0) {
						System.out.println("Value from exUpdate--->" + insertVal);

						return true;
					}
				}


			} else {


				if (tableName.equals("party_detail") || tableName.equals("simple_party_detail")) {
					String entryDate = "";

					PreparedStatement pstat = con.prepareStatement("update " + tableName + " set BUYER_NAME = ? ,PHONE_NO= ?, GST_NO = ?,ADDRESS  = ?, REMARK = ?,ENTRY_DATE = ? where ID = ?");


					pstat.setString(1, buyerName);
					pstat.setString(2, phoneNo);
					pstat.setString(3, gstNo);
					pstat.setString(4, address);
					pstat.setString(5, remark);
					pstat.setString(6, entryDate);

					pstat.setInt(7, bId);

					int insertVal = pstat.executeUpdate();
					if (insertVal > 0) {
						System.out.println("Value from exUpdate--->" + insertVal);
						JOptionPane.showMessageDialog(null, "Updated!!");

						return true;
					}


				} else if (tableName.equals("buyer_detail")) {
					String entryDate = "";

					PreparedStatement pstat = con.prepareStatement("update " + tableName + " set BUYER_NAME = ? ,PHONE_NO= ?, ADDRESS  = ?, REMARK = ?,ENTRY_DATE = ? where ID = ?");


					pstat.setString(1, buyerName);
					pstat.setString(2, phoneNo);
					pstat.setString(3, address);
					pstat.setString(4, remark);
					pstat.setString(5, entryDate);

					pstat.setInt(6, bId);

					int insertVal = pstat.executeUpdate();
					if (insertVal > 0) {
						System.out.println("Value from exUpdate--->" + insertVal);
						JOptionPane.showMessageDialog(null, "Updated!!");

					}


				} else if (tableName.equals("simple_buyer_detail")) {
					String entryDate = "";

					PreparedStatement pstat = con.prepareStatement("update " + tableName + " set BUYER_NAME = ? ,PHONE_NO= ?, ADDRESS  = ?, REMARK = ?,ENTRY_DATE = ? where ID = ?");


					pstat.setString(1, buyerName);
					pstat.setString(2, phoneNo);
					pstat.setString(3, address);
					pstat.setString(4, remark);
					pstat.setString(5, entryDate);

					pstat.setInt(6, bId);

					int insertVal = pstat.executeUpdate();
					if (insertVal > 0) {
						System.out.println("Value from exUpdate--->" + insertVal);
						JOptionPane.showMessageDialog(null, "Updated!!");

					}


				}

			}
		}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "From addVahicalValues Error My Dear : " + ex);
		}


		return false;
	}


	public boolean updateReport(Connection con, JTable table, String tableName, String strKey, String colName, String strDelKey, String ordType, String colName2, int IdFromComboList, String tabNamePDetail, String loginDate, String shift, String markPOrA, String remark, String adharNo)
	          {

				  int rowCount=0;

				  if(table!=null) {
					  rowCount = table.getRowCount();

				  }



	          	if (strKey != null && strKey.equals("updateReceipt")) {

			try {

			/*	receipt LAB_ID ,PATIENT_ID , PATIENT_NAME ,DOCTOR_NAME ,TYPE ,AGE ,GENDER ,TEST_GROUP ,MOBILE_NO ,FEES
						,TOTAL_FEES , DISCOUNT ,PAYABLE ,PAID ,BALANCE ,COLLECT_DATE ,COLLECT_TIME ,REPORT_DATE ,REPORT_TIME ,SEARCH_KEY
						,test_report


				report TEST_GROUP_ID , PATIENT_ID ,PATIENT_NAME ,GENDER ,AGE ,PHONE_NO ,ADDRESS ,REMARK ,CHILD_ADULT ,REF_DOCTOR ,TEST ,
						RESULT ,UNITS ,CONDITION ,NORM_VALUE ,COLLECT_DATE ,COLLECT_TIME ,REPORT_DATE ,REPORT_TIME ,METHOD ,
						TEST_REMARKS ,SEARCH_KEY,LAB_ID
*/

				boolean flag=false;

				int[] selectedRow = table.getSelectedRows();

				if (selectedRow != null) {

					//	JOptionPane.showMessageDialog(null, "selectedRow != null");
					int selectedRowCount = selectedRow.length;



					int receiptNo = 0;

					int patientId = 0;

					String patientName = "";
					String doctorName = "";


					String type = "";
					String age = "";
					String gender = "";

					String childOrAdult = "";

					String testGroup = "";
					String mobileNo = "";

					String address = "";

					String emailId = "";

					float fees = 0;
					float totalFees = 0;
					float discount = 0;
					float payable = 0;
					float paid = 0;
					float balance = 0;
					//2020-11-28
					String collectDate = "";

					String collectTime = "";

					String reportDate = "";

					String reportTime = "";
					String searchKey = "";

					int testGroupId = 0;



					for (int x = 0; x < selectedRowCount; x++) {


						receiptNo = Integer.parseInt(table.getValueAt(selectedRow[x], 0).toString());

						patientId = Integer.parseInt(table.getValueAt(selectedRow[x], 1).toString());

						patientName = table.getValueAt(selectedRow[x], 2).toString();
						doctorName = table.getValueAt(selectedRow[x], 3).toString();


						type = table.getValueAt(selectedRow[x], 4).toString();
						age = table.getValueAt(selectedRow[x], 5).toString();
						gender = table.getValueAt(selectedRow[x], 6).toString();

						childOrAdult = table.getValueAt(selectedRow[x], 7).toString();

						testGroup = table.getValueAt(selectedRow[x], 8).toString();
						mobileNo = table.getValueAt(selectedRow[x], 9).toString();

						address = table.getValueAt(selectedRow[x], 10).toString();

						emailId = table.getValueAt(selectedRow[x], 11).toString();

						fees = Float.parseFloat(table.getValueAt(selectedRow[x], 12).toString());
						totalFees = Float.parseFloat(table.getValueAt(selectedRow[x], 13).toString());
						discount = Float.parseFloat(table.getValueAt(selectedRow[x], 14).toString());
						payable = Float.parseFloat(table.getValueAt(selectedRow[x], 15).toString());
						paid = Float.parseFloat(table.getValueAt(selectedRow[x], 16).toString());
						balance = Float.parseFloat(table.getValueAt(selectedRow[x], 17).toString());
						String[] collectDateArr = table.getValueAt(selectedRow[x], 18).toString().split("-");//01/10/2020
						//2020-11-28
						 collectDate = collectDateArr[2] + "/" + collectDateArr[1] + "/" + collectDateArr[0];

						collectTime = table.getValueAt(selectedRow[x], 19).toString();

						String[] reportDateArr = table.getValueAt(selectedRow[x], 20).toString().split("-");//01/10/2020
						reportDate = reportDateArr[2] + "/" + reportDateArr[1] + "/" + reportDateArr[0];

						reportTime = table.getValueAt(selectedRow[x], 21).toString();
						searchKey = table.getValueAt(selectedRow[x], 22).toString();

						testGroupId = Integer.parseInt(table.getValueAt(selectedRow[x], 23).toString());

						if (receiptNo > 0) {


						} else {
							JOptionPane.showMessageDialog(null, "Fields are empty", "Message", 1);

							return false;
						}


						PreparedStatement pstat = con.prepareStatement("update " + tableName + " set PATIENT_NAME = ?,DOCTOR_NAME = ?" +
								",TYPE = ?,AGE = ?,GENDER = ?,CHILD_ADULT =?,TEST_GROUP = ?,MOBILE_NO = ?,EMAIL_ID = ?, ADDRESS = ?,FEES " +
								"= ?,TOTAL_FEES = ?, DISCOUNT = ?,PAYABLE = ?,PAID = ?,BALANCE = ?,COLLECT_DATE = ?,COLLECT_TIME = ?" +
								",REPORT_DATE = ?,REPORT_TIME = ?,SEARCH_KEY" +
								"= ? where LAB_ID= ? AND TEST_GROUP_ID = ? AND PATIENT_ID = ?");
						pstat.setString(1, patientName);
						pstat.setString(2, doctorName);
						pstat.setString(3, type);
						pstat.setString(4, age);
						pstat.setString(5, gender);
						pstat.setString(6, childOrAdult);

						pstat.setString(7, testGroup);
						pstat.setString(8, mobileNo);
						pstat.setString(9, emailId);
						pstat.setString(10, address);

						pstat.setFloat(11, fees);
						pstat.setFloat(12, totalFees);
						pstat.setFloat(13, discount);
						pstat.setFloat(14, payable);
						pstat.setFloat(15, paid);
						pstat.setFloat(16, balance);
						pstat.setDate(17, getDate(collectDate));
						pstat.setString(18, collectTime);
						pstat.setDate(19, getDate(reportDate));
						pstat.setString(20, reportTime);
						pstat.setString(21, searchKey);
						pstat.setInt(22, receiptNo);
						pstat.setInt(23, testGroupId);
						pstat.setInt(24, patientId);


						int updateVal = pstat.executeUpdate();
						if (updateVal > 0) {
							System.out.println("Value from exUpdate--->" + updateVal);

							flag = true;

						}


					}


					if (flag == true) {

						return flag;

/*
						PreparedStatement pstat = con.prepareStatement("update " + tabNamePDetail + " set patient_name = ?, sex = ? , age = ?, phone_no = ?,email_id = ?, address = ? where ID = ?");


						pstat.setString(1, patientName);
						pstat.setString(2, gender);
						pstat.setString(3, age);
						pstat.setString(4, mobileNo);
						pstat.setString(5, emailId);
						pstat.setString(6, address);


						pstat.setInt(7, patientId);

						int insertVal = pstat.executeUpdate();
						if (insertVal > 0) {
							System.out.println("Value from exUpdate--->" + insertVal);
							//JOptionPane.showMessageDialog(null, "Updated!!");

							return flag;

						}
*/





					}


				}


			} catch (Exception e) {

				e.printStackTrace();

				JOptionPane.showMessageDialog(null, "Error !!" + e);


			}

		}
				else if(strKey.equals("deleteReceipt"))
				{
					//JOptionPane.showMessageDialog(null, strKey);

					if (strDelKey.equals("deleteRecord")) {

						boolean flag = false;

					//	JOptionPane.showMessageDialog(null, strDelKey);

						int[] selectedRow = table.getSelectedRows();

						if (selectedRow != null) {

						//	JOptionPane.showMessageDialog(null, "selectedRow != null");

							int selectedRowCount = selectedRow.length;

							for (int i = 0; i < selectedRowCount; i++) {

//                            JOptionPane.showMessageDialog(null,"at row idx "+i);

							/*	qry = "select ID, LAB_ID ,TEST_GROUP,TEST ,RESULT , CONDITION ,UNITS ,NORM_VALUE ,COLLECT_DATE , COLLECT_TIME ,REPORT_DATE ,REPORT_TIME" +
										",TEST_GROUP_ID, PATIENT_ID,PATIENT_NAME ,GENDER ,AGE , PHONE_NO ,ADDRESS ,REMARK ,CHILD_ADULT ,REF_DOCTOR , METHOD , TEST_REMARKS , SEARCH_KEY from " + tabName + " where " + colName + " = " + colVal + " AND RESFLAG = 0 order by " + ordByCol;
*/
								//JOptionPane.showMessageDialog(null, "selectedRow "+i);


								int testId = Integer.parseInt(table.getValueAt(selectedRow[i], 0).toString());
								int testGroupId = Integer.parseInt(table.getValueAt(selectedRow[i], 23).toString());



								String query = "DELETE FROM " + tableName + " WHERE " + colName2 + " = ? AND TEST_GROUP_ID = ?";


								PreparedStatement outpstat = null;
								try {
									outpstat = con.prepareStatement(query);
									//outpstat.setInt(1,testId);
									outpstat.setInt(1,testId);
									outpstat.setInt(2,testGroupId);


									int val = outpstat.executeUpdate();


									if (val > 0) {

										System.out.println("Record Deleted");
										//JOptionPane.showMessageDialog(null, "Updated!!");
										flag = true;
									}
								} catch (Exception e) {
									e.printStackTrace();
								}

							}


							if(flag)
							{

								return flag;
							}
						}
					}
					else if (strDelKey.equals("deleteAll")) {

						boolean flag = false;

						String query = "DELETE FROM " + tableName + " WHERE " + colName2 + " = ?";


						PreparedStatement outpstat = null;
						try {
							outpstat = con.prepareStatement(query);
							outpstat.setInt(1,IdFromComboList);


							int val = outpstat.executeUpdate();


							if (val > 0) {

								System.out.println("Record Deleted");
								//JOptionPane.showMessageDialog(null, "Updated!!");
								flag = true;


								return flag;


							}
						} catch (Exception e) {
							e.printStackTrace();
						}

					}


				}

				else if(strKey.equalsIgnoreCase("updateReport"))
			{
				try {


						boolean flag=false;

					int[] selectedRow = table.getSelectedRows();

					if (selectedRow != null) {

						//	JOptionPane.showMessageDialog(null, "selectedRow != null");

						int selectedRowCount = selectedRow.length;


						for (int x = 0; x < selectedRowCount; x++) {


							int rowId = Integer.parseInt(table.getValueAt(selectedRow[x], 0).toString());

							int labId = Integer.parseInt(table.getValueAt(selectedRow[x], 1).toString());
							String testGroup = table.getValueAt(selectedRow[x], 2).toString();
							String test = table.getValueAt(selectedRow[x], 3).toString();
							float result = Float.parseFloat(table.getValueAt(selectedRow[x], 4).toString());


							String condition = table.getValueAt(selectedRow[x], 5).toString();
							String units = table.getValueAt(selectedRow[x], 6).toString();
							String normValue = table.getValueAt(selectedRow[x], 7).toString();

							String[] collectDateArr = table.getValueAt(selectedRow[x], 8).toString().split("-");

							String collectDate = collectDateArr[2] + "/" + collectDateArr[1] + "/" + collectDateArr[0];


							String collectTime = table.getValueAt(selectedRow[x], 9).toString();

							String[] reportDateArr = table.getValueAt(selectedRow[x], 10).toString().split("-");

							String reportDate = reportDateArr[2] + "/" + reportDateArr[1] + "/" + reportDateArr[0];


							String reportTime = table.getValueAt(selectedRow[x], 11).toString();
							String patientName = table.getValueAt(selectedRow[x], 14).toString();
							String gender = table.getValueAt(selectedRow[x], 15).toString();
							String age = table.getValueAt(selectedRow[x], 16).toString();
							String mobileNo = table.getValueAt(selectedRow[x], 17).toString();
							String address = table.getValueAt(selectedRow[x], 18).toString();
							String remarkV = table.getValueAt(selectedRow[x], 19).toString();
							String childOrAdult = table.getValueAt(selectedRow[x], 20).toString();
							String doctorName = table.getValueAt(selectedRow[x], 21).toString();
							String method = table.getValueAt(selectedRow[x], 22).toString();
							String testRemark = table.getValueAt(selectedRow[x], 23).toString();
							String searchKey = table.getValueAt(selectedRow[x], 24).toString();

							if (labId > 0) {


							} else {
								JOptionPane.showMessageDialog(null, "Fields are empty", "Message", 1);

								return false;
							}


							PreparedStatement pstat = con.prepareStatement("update " + tableName + " set PATIENT_NAME = ?,GENDER = ?,AGE = ?," +
									"PHONE_NO = ?,ADDRESS = ?,REMARK = ?,CHILD_ADULT = ?,REF_DOCTOR = ?,TEST = ?,RESULT = ?,UNITS = ?,CONDITION = ?" +
									",NORM_VALUE = ?,COLLECT_DATE = ?,COLLECT_TIME = ? ,REPORT_DATE = ?,REPORT_TIME = ?,METHOD = ?,TEST_REMARKS = ?,SEARCH_KEY" +
									"= ? where LAB_ID= ? AND TEST_GROUP_ID = ? AND ID = ?");
							pstat.setString(1, patientName);
							pstat.setString(2, gender);
							pstat.setString(3, age);
							pstat.setString(4, mobileNo);
							pstat.setString(5, address);
							pstat.setString(6, remarkV);
							pstat.setString(7, childOrAdult);
							pstat.setString(8, doctorName);
							pstat.setString(9, test);
							pstat.setFloat(10, result);
							pstat.setString(11, units);
							pstat.setString(12, condition);
							pstat.setString(13, normValue);
							pstat.setDate(14, getDate(collectDate));
							pstat.setString(15, collectTime);
							pstat.setDate(16, getDate(reportDate));
							pstat.setString(17, reportTime);
							pstat.setString(18, method);
							pstat.setString(19, testRemark);

							pstat.setString(20, searchKey);
							pstat.setInt(21, labId);
							int testGroupId = Integer.parseInt(table.getValueAt(selectedRow[x], 12).toString());
							pstat.setInt(22, testGroupId);
							pstat.setInt(23, rowId);


							int updateVal = pstat.executeUpdate();
							if (updateVal > 0) {
								System.out.println("Value from exUpdate--->" + updateVal);

								flag = true;

							}


						}

					}
						if (flag == true)
							return flag;

					} catch (Exception e) {

						e.printStackTrace();

						JOptionPane.showMessageDialog(null, "Error !!" + e);


					}

				}
			else if(strKey.equals("deleteReport"))
				{
					if (strDelKey.equals("deleteRecord")) {

						boolean flag = false;

						int[] selectedRow = table.getSelectedRows();

						if (selectedRow != null) {
							int selectedRowCount = selectedRow.length;

							for (int i = 0; i < selectedRowCount; i++) {

//                            JOptionPane.showMessageDialog(null,"at row idx "+i);

							/*	qry = "select ID, LAB_ID ,TEST_GROUP,TEST ,RESULT , CONDITION ,UNITS ,NORM_VALUE ,COLLECT_DATE , COLLECT_TIME ,REPORT_DATE ,REPORT_TIME" +
										",TEST_GROUP_ID, PATIENT_ID,PATIENT_NAME ,GENDER ,AGE , PHONE_NO ,ADDRESS ,REMARK ,CHILD_ADULT ,REF_DOCTOR , METHOD , TEST_REMARKS , SEARCH_KEY from " + tabName + " where " + colName + " = " + colVal + " AND RESFLAG = 0 order by " + ordByCol;
*/

								int testId = Integer.parseInt(table.getValueAt(selectedRow[i], 0).toString());
								int labId = Integer.parseInt(table.getValueAt(selectedRow[i], 1).toString());

								int testGroupId = Integer.parseInt(table.getValueAt(selectedRow[i], 12).toString());



								String query = "DELETE FROM " + tableName + " WHERE " + colName + "= ? AND " + colName2 + " = ? AND TEST_GROUP_ID = ?";


								PreparedStatement outpstat = null;
								try {
									outpstat = con.prepareStatement(query);
									outpstat.setInt(1,testId);
									outpstat.setInt(2,labId);
									outpstat.setInt(3,testGroupId);


									int val = outpstat.executeUpdate();


									if (val > 0) {

										System.out.println("Record Deleted");
										//JOptionPane.showMessageDialog(null, "Updated!!");
										flag = true;
									}
								} catch (Exception e) {
									e.printStackTrace();
								}

							}


							if(flag)
							{

								return flag;
							}
						}
					}
					else if (strDelKey.equals("deleteAll")) {

						boolean flag = false;

						String query = "DELETE FROM " + tableName + " WHERE " + colName2 + " = ?";


						PreparedStatement outpstat = null;
						try {
							outpstat = con.prepareStatement(query);
							outpstat.setInt(1,IdFromComboList);


							int val = outpstat.executeUpdate();


							if (val > 0) {

								System.out.println("Record Deleted");
								//JOptionPane.showMessageDialog(null, "Updated!!");
								flag = true;


								return flag;


							}
						} catch (Exception e) {
							e.printStackTrace();
						}

					}


				}
				else if (strKey != null && strKey.equals("updateAttendanceDetail")) {

                                    
					try {


						boolean flag=false;

						int[] selectedRow = table.getSelectedRows();

						if (selectedRow != null) {

							//	JOptionPane.showMessageDialog(null, "selectedRow != null");

							int selectedRowCount = selectedRow.length;

							String markV="";
							String remarkV="";


							for (int x = 0; x < selectedRowCount; x++) {


								int id = Integer.parseInt(table.getValueAt(selectedRow[x], 0).toString());

								int empId = Integer.parseInt(table.getValueAt(selectedRow[x], 1).toString());

								String userName = table.getValueAt(selectedRow[x], 2).toString();

							/*	String loginDateCell = table.getValueAt(selectedRow[x], 4).toString();

								String shiftCell = table.getValueAt(selectedRow[x], 6).toString();
*/
								/*
								String div = table.getValueAt(selectedRow[x], 3).toString();


								String options = table.getValueAt(selectedRow[x], 4).toString();
								String adharNo = table.getValueAt(selectedRow[x], 5).toString();
									 markV = table.getValueAt(selectedRow[x], 7).toString();

								*/
								markV = table.getValueAt(selectedRow[x], 7).toString();



								//String remarkCell = table.getValueAt(selectedRow[x], 8).toString();
								

								if (id > 0 && empId > 0 && userName.length() > 0 
										&& markV.length() > 0
										) {


								} else {
									JOptionPane.showMessageDialog(null, "Fields are empty", "Message", 1);

									return false;
								}

								if(!(loginDate.equals("--"))
										&& loginDate.length()>0) {

/*
									String colnames = "login_date = ?, shift = ?, marked = ?, remark = ?";


									PreparedStatement pstat = con.prepareStatement("update " + tableName + " set " + colnames + " where id= ? AND emp_id = ?");
									pstat.setString(1, marked);
									pstat.setString(2, remark);

									pstat.setString(1, marked);
									pstat.setString(2, remark);
									pstat.setInt(3, id);
									pstat.setInt(4, empId);
*/


								}
								else if(!(shift.equals("--"))
										&& shift.length()>0) {

/*
									String colnames = "login_date = ?, shift = ?, marked = ?, remark = ?";


									PreparedStatement pstat = con.prepareStatement("update " + tableName + " set " + colnames + " where id= ? AND emp_id = ?");
									pstat.setString(1, marked);
									pstat.setString(2, remark);

									pstat.setString(1, marked);
									pstat.setString(2, remark);
									pstat.setInt(3, id);
									pstat.setInt(4, empId);
*/


								}
								else if(!(markPOrA.equals("--"))
										&& markPOrA.length()>0) {

									String colnames = "marked = ?, remark = ?";
									PreparedStatement pstat = con.prepareStatement("update " + tableName + " set " + colnames + " where id= ? AND emp_id = ? OR adhar_no ='"+adharNo+"'");
									pstat.setString(1, markPOrA);
									pstat.setString(2, remark);
									pstat.setInt(3, id);
									pstat.setInt(4, empId);


								}
								else if(remark.length()>0) {
								}





								int updateVal = pstat.executeUpdate();
								if (updateVal > 0) {
									System.out.println("Value from exUpdate--->" + updateVal);

									flag = true;

								}


							}
						}

						if (flag == true)
							return flag;

					} catch (Exception e) {

						e.printStackTrace();

						JOptionPane.showMessageDialog(null, "Error !!" + e);


					}

				}
				if(strKey!=null && strKey.equals("deleteGroupDetail")) {


					if (strDelKey.equals("deleteRecord")) {

						boolean flag = false;

						int[] selectedRow = table.getSelectedRows();

						if (selectedRow != null) {
							int selectedRowCount = selectedRow.length;

							for (int i = 0; i < selectedRowCount; i++) {

//                            JOptionPane.showMessageDialog(null,"at row idx "+i);


								int testId = Integer.parseInt(table.getValueAt(selectedRow[i], 0).toString());
								int testGroupId = Integer.parseInt(table.getValueAt(selectedRow[i], 11).toString());



								String query = "DELETE FROM " + tableName + " WHERE " + colName + "= ? AND " + colName2 + " = ?";


								PreparedStatement outpstat = null;
								try {
									outpstat = con.prepareStatement(query);
									outpstat.setInt(1,testId);
									outpstat.setInt(2,testGroupId);//IdFromComboList


									int val = outpstat.executeUpdate();


									if (val > 0) {

										System.out.println("Record Deleted");
										//JOptionPane.showMessageDialog(null, "Updated!!");
										flag = true;
									}
								} catch (Exception e) {
									e.printStackTrace();
								}

							}


							if(flag)
							{

								return flag;
							}
						}
					}
					else if (strDelKey.equals("deleteAll")) {

						boolean flag = false;
						String query = "DELETE FROM " + tableName + " WHERE " + colName2 + " = ?";


						PreparedStatement outpstat = null;
						try {
							outpstat = con.prepareStatement(query);
							outpstat.setInt(1,IdFromComboList);


							int val = outpstat.executeUpdate();


							if (val > 0) {

								System.out.println("Record Deleted");
								//JOptionPane.showMessageDialog(null, "Updated!!");
								flag = true;


									return flag;


							}
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				}
				else if (strKey.equals("deleteDoctorDetail")) {

					if (strDelKey.equals("deleteAll")) {

						boolean flag = false;
						String query = "DELETE FROM " + tableName + " WHERE " + colName2 + " = ?";


						PreparedStatement outpstat = null;
						try {
							outpstat = con.prepareStatement(query);
							outpstat.setInt(1, IdFromComboList);


							int val = outpstat.executeUpdate();


							if (val > 0) {

								System.out.println("Record Deleted");
								//JOptionPane.showMessageDialog(null, "Updated!!");
								flag = true;


								return flag;


							}
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				}
				else if (strKey.equals("deleteFirmDetail")) {

					if (strDelKey.equals("deleteAll")) {

						boolean flag = false;
						String query = "DELETE FROM " + tableName + " WHERE " + colName2 + " = ?";


						PreparedStatement outpstat = null;
						try {
							outpstat = con.prepareStatement(query);
							outpstat.setInt(1, IdFromComboList);


							int val = outpstat.executeUpdate();


							if (val > 0) {

								System.out.println("Record Deleted");
								//JOptionPane.showMessageDialog(null, "Updated!!");
								flag = true;


								return flag;


							}
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				}
				else if (strKey.equals("deletePatientDetail")) {

					if (strDelKey.equals("deleteAll")) {

						boolean flag = false;
						String query = "DELETE FROM " + tableName + " WHERE " + colName2 + " = ?";


						PreparedStatement outpstat = null;
						try {
							outpstat = con.prepareStatement(query);
							outpstat.setInt(1, IdFromComboList);


							int val = outpstat.executeUpdate();


							if (val > 0) {

								System.out.println("Record Deleted");
								//JOptionPane.showMessageDialog(null, "Updated!!");
								flag = true;


								return flag;


							}
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				}
				else if (strKey.equals("deleteCollectionBranchDetail")) {

					if (strDelKey.equals("deleteAll")) {

						boolean flag = false;
						String query = "DELETE FROM " + tableName + " WHERE " + colName2 + " = ?";


						PreparedStatement outpstat = null;
						try {
							outpstat = con.prepareStatement(query);
							outpstat.setInt(1, IdFromComboList);


							int val = outpstat.executeUpdate();


							if (val > 0) {

								System.out.println("Record Deleted");
								//JOptionPane.showMessageDialog(null, "Updated!!");
								flag = true;


								return flag;


							}
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				}
				else if (strKey.equals("deleteTestGroupRateDetail")) {

					if (strDelKey.equals("deleteAll")) {

						boolean flag = false;
						String query = "DELETE FROM " + tableName + " WHERE " + colName2 + " = ?";


						PreparedStatement outpstat = null;
						try {
							outpstat = con.prepareStatement(query);
							outpstat.setInt(1, IdFromComboList);


							int val = outpstat.executeUpdate();


							if (val > 0) {

								System.out.println("Record Deleted");
								//JOptionPane.showMessageDialog(null, "Updated!!");
								flag = true;


								return flag;


							}
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				}
				else if (strKey.equals("deleteMethodDetail")) {

					if (strDelKey.equals("deleteAll")) {

						boolean flag = false;
						String query = "DELETE FROM " + tableName + " WHERE " + colName2 + " = ?";


						PreparedStatement outpstat = null;
						try {
							outpstat = con.prepareStatement(query);
							outpstat.setInt(1, IdFromComboList);


							int val = outpstat.executeUpdate();


							if (val > 0) {

								System.out.println("Record Deleted");
								//JOptionPane.showMessageDialog(null, "Updated!!");
								flag = true;


								return flag;


							}
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				}


				  return false;
			  }


	public int addPatientTestReceiptDetails(Connection con, String tableName, int labId, String doctorName, String sampleCollectionBranch, String datePicker1Val, String datePicker2Val, String timePicker1Val, String timePicker2Val, int patientID ,String patientNameVal, int ageVal, String gender, String isChildVal, String phoneNoVal, String emailIdVal, String address, String testName,int testGrouppId,float fees, float totalFees, float discount, float payable, float paid, float balance, int vOoZ, String remark, String searchKey) {

        if (vOoZ == 0) {
            try {



                Statement	stat = con.createStatement();
                ResultSet result = null;

                result = stat.executeQuery("select * from " + tableName);






                int insertVal = 0;

                /*if (result.next()) {

                    JOptionPane.showMessageDialog(null, "Already Exist!!");


                }
                else {
*/
                    //JOptionPane.showMessageDialog(null, "Price, GST NOT Same");


                    ResultSetMetaData rsmd = result.getMetaData();

                    int columnCount = rsmd.getColumnCount();

                    tableName = rsmd.getTableName(columnCount);

                    int[] pos = new int[columnCount];

                    int posValue = 0;

                    System.out.println("From DB addVahicalValues column Count is " + (columnCount));

               /*     for (int idxVar = 0; idxVar < pos.length; idxVar++) {
                        posValue = idxVar;
                        pos[idxVar] = ++posValue;

                        System.out.println("From DB addVahicalValues putting values" + pos[idxVar]);

                    }
               */     getTabColNames(tableName, rsmd, columnCount);


                    PreparedStatement	pstat = con.prepareStatement("insert into " + tableName + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");




//				System.out.println("If succeed Table Name====> " + tableName + "and ColCount is -->" + ColCount);

                    for (int i = 1; i <= columnCount; i++) {

                        //System.out.println("colnames====> " + rsmd.getColumnName(i));





                        if (rsmd.getColumnName(i).equals("LAB_ID")) {

                            pstat.setInt(i, labId);
                            System.out.println("From addVahicalValues  ID setting values " + labId + "  -->Col No" + i);

                            //						System.out.println("values From getLGABankColNames-->Col No " + col_gd_ID + " Col Name :" + col_name_ID);
                        }


						if (rsmd.getColumnName(i).equals("PATIENT_ID"))
						{
							pstat.setInt(i, patientID);
							System.out.println("From addVahicalValues VehicalName setting values " + patientID + "  -->Col No" + i);

						}

                        if (rsmd.getColumnName(i).equals("PATIENT_NAME")) {

                        	pstat.setString(i, patientNameVal);
                            System.out.println("From addVahicalValues VehicalName setting values " + testName + "  -->Col No" + i);
                        }
                        if (rsmd.getColumnName(i).equals("DOCTOR_NAME")) {

                            pstat.setString(i, doctorName);

                        }


						if (rsmd.getColumnName(i).equals("TYPE")) {


                            pstat.setString(i, "OPD");
                            System.out.println("From addVahicalValues VehicalName setting values " +"OPD"  + "  -->Col No" + i);

                        }


						if (rsmd.getColumnName(i).equals("AGE")) {


							pstat.setInt(i, ageVal);
							System.out.println("From addVahicalValues VehicalName setting values " + ageVal + "  -->Col No" + i);



						}
                        if (rsmd.getColumnName(i).equals("GENDER")) {


                            pstat.setString(i, gender);
                            System.out.println("From addVahicalValues VehicalName setting values " + gender + "  -->Col No" + i);



                        }

                        if (rsmd.getColumnName(i).equals("CHILD_ADULT")) {


							pstat.setString(i, isChildVal);
							System.out.println("From addVahicalValues VehicalName setting values " + isChildVal + "  -->Col No" + i);



						}


                        if (rsmd.getColumnName(i).equals("TEST_GROUP")) {


							pstat.setString(i, testName);
							System.out.println("From addVahicalValues VehicalName setting values " + testName + "  -->Col No" + i);



						}


						if (rsmd.getColumnName(i).equals("TEST_GROUP_ID")) {


							pstat.setInt(i, testGrouppId);
							System.out.println("From addVahicalValues VehicalName setting values " + testGrouppId + "  -->Col No" + i);



						}



                        if (rsmd.getColumnName(i).equals("MOBILE_NO")) {

                            pstat.setString(i, phoneNoVal);
                            System.out.println("From addVahicalValues VehicalName setting values " + phoneNoVal + "  -->Col No" + i);


                        }

						if (rsmd.getColumnName(i).equals("ADDRESS")) {

							pstat.setString(i, address);
							System.out.println("From addVahicalValues VehicalName setting values " + address + "  -->Col No" + i);


						}
						if (rsmd.getColumnName(i).equals("EMAIL_ID")) {

							pstat.setString(i, emailIdVal);
							System.out.println("From addVahicalValues VehicalName setting values " + emailIdVal + "  -->Col No" + i);


						}


						if (rsmd.getColumnName(i).equals("FEES")) {
							pstat.setFloat(i, fees);
							System.out.println("From addVahicalValues  VehicalFuelType setting values " + fees+ "  -->Col No" + i);


						}

						if (rsmd.getColumnName(i).equals("TOTAL_FEES")) {
                            pstat.setFloat(i, totalFees);
                            System.out.println("From addVahicalValues  VehicalFuelType setting values " + totalFees+ "  -->Col No" + i);


                        }


                        if (rsmd.getColumnName(i).equals("DISCOUNT")) {

                            pstat.setFloat(i, discount);
                            System.out.println("From addVahicalValues VehicalName setting values " + discount + "  -->Col No" + i);


                        }

                        if (rsmd.getColumnName(i).equals("PAYABLE")) {
                            pstat.setFloat(i, payable);
                            System.out.println("From addVahicalValues  VehicalFuelType setting values " + payable+ "  -->Col No" + i);


                        }

                        if (rsmd.getColumnName(i).equals("PAID")) {
                            pstat.setFloat(i, paid);
                            System.out.println("From addVahicalValues  VehicalModel setting values " + paid + "  -->Col No" + i);

                        }
                        if (rsmd.getColumnName(i).equals("BALANCE")) {
                            pstat.setFloat(i, balance);

                            System.out.println("From addVahicalValues  VehicalModel setting values " + balance + "  -->Col No" + i);


                        }


                        if (rsmd.getColumnName(i).equals("COLLECT_DATE")) {

							//String entryDate = getDateVal(tableName);
                            pstat.setDate(i, getDate(datePicker1Val));
                            System.out.println("From addVahicalValues  VehicalModel setting values " + datePicker1Val + "  -->Col No" + i);

                        }

						if (rsmd.getColumnName(i).equals("COLLECT_TIME")) {

							//String entryDate = getDateVal(tableName);
							pstat.setString(i, timePicker1Val);
							System.out.println("From addVahicalValues  VehicalModel setting values " + timePicker1Val + "  -->Col No" + i);

						}

						if (rsmd.getColumnName(i).equals("REPORT_DATE")) {

							//String entryDate = getDateVal(tableName);
							pstat.setDate(i, getDate(datePicker2Val));
							System.out.println("From addVahicalValues  VehicalModel setting values " + datePicker2Val + "  -->Col No" + i);

						}

						if (rsmd.getColumnName(i).equals("REPORT_TIME")) {

							//String entryDate = getDateVal(tableName);
							pstat.setString(i, timePicker2Val);
							System.out.println("From addVahicalValues  VehicalModel setting values " + timePicker2Val + "  -->Col No" + i);

						}




						if (rsmd.getColumnName(i).equals("SEARCH_KEY")) {

							//String entryDate = getDateVal(tableName);
							pstat.setString(i, searchKey);
							System.out.println("From addVahicalValues  VehicalModel setting values " + timePicker2Val + "  -->Col No" + i);

						}

						if (rsmd.getColumnName(i).equals("TEST_REPORT")) {

							//String entryDate = getDateVal(tableName);
							pstat.setString(i, "");
							System.out.println("From addVahicalValues  VehicalModel setting values " + "..." + "  -->Col No" + i);

						}
                    }






                    insertVal = pstat.executeUpdate();
                       //boolean insertVal=pstat.execute();

                System.out.println("From DB addVahicalValues row inserted");
                if (insertVal > 0) {
                    System.out.println("Value from exUpdate--->" + insertVal);

                    //JOptionPane.showMessageDialog(null, "Done !!!");

                    //addGoodsNameDetails(con,materialName , goodsStatus,goodsTableName,gstFlagsVal);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "From addVahicalValues Error My Dear : " + ex);
            }


            return	labId;
        }
        return 0 ;

    }



    public int addGroupDetails(Connection con, String tableName, int testGroupId, String testGroupName, String chkBoxTestType,String testName, String defaultValue,
							   String unit, String options, String normalValuesMale,
							   String normalValuesFeMale,
							   String normalValuesChildMale, String normalValuesChildFeMale, String status,
							   String testNote, String searchKey, int vOoZ, String groupNamesTable) {

		int uniQID=0;
		if (vOoZ == 0) {
			try {



			Statement	stat = con.createStatement();
				ResultSet result = null;

					result = stat.executeQuery("select * from " + tableName + " where TEST_NAME ='"
							+ testName + "'");


				int insertVal = 0;

				if (result.next()) {

					//JOptionPane.showMessageDialog(null, "Already Exist!!");
					System.out.println("Already Exist!!");


				}
				else {

					//JOptionPane.showMessageDialog(null, "Price, GST NOT Same");


					ResultSetMetaData rsmd = result.getMetaData();

					int columnCount = rsmd.getColumnCount();

					tableName = rsmd.getTableName(columnCount);




				PreparedStatement	pstat = con.prepareStatement("insert into " + tableName + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");




//				System.out.println("If succeed Table Name====> " + tableName + "and ColCount is -->" + ColCount);

						for (int i = 1; i <= columnCount; i++) {

							//System.out.println("colnames====> " + rsmd.getColumnName(i));

							if (rsmd.getColumnName(i).equals("ID")) {

								uniQID = genUniId(con, tableName);
								pstat.setInt(i, uniQID);
								System.out.println("From addVahicalValues  ID setting values " + uniQID + "  -->Col No" + i);

							//						System.out.println("values From getLGABankColNames-->Col No " + col_gd_ID + " Col Name :" + col_name_ID);
							}

							if (rsmd.getColumnName(i).equals("TEST_GROUP_ID")) {
								pstat.setInt(i, testGroupId);

								System.out.println("From addVahicalValues  VehicalModel setting values " + testGroupId + "  -->Col No" + i);


							}



							if (rsmd.getColumnName(i).equals("TEST_GROUP")) {



								pstat.setString(i, testGroupName);
								System.out.println("From addVahicalValues VehicalName setting values " + testGroupName + "  -->Col No" + i);
							}


							if (rsmd.getColumnName(i).equals("TEST_TYPE")) {



								pstat.setString(i, chkBoxTestType);
								System.out.println("From addVahicalValues VehicalName setting values " + chkBoxTestType + "  -->Col No" + i);
							}



							if (rsmd.getColumnName(i).equals("TEST_NAME")) {



								pstat.setString(i, testName);
								System.out.println("From addVahicalValues VehicalName setting values " + testName + "  -->Col No" + i);
							}
							if (rsmd.getColumnName(i).equals("DEFAULT_VALUE")) {

									pstat.setString(i, defaultValue);

							}




							if (rsmd.getColumnName(i).equals("OPTIONS")) {


								pstat.setString(i, options);
								System.out.println("From addVahicalValues VehicalName setting values " + options + "  -->Col No" + i);

							}
							if (rsmd.getColumnName(i).equals("UNITS")) {


								pstat.setString(i, unit);
								System.out.println("From addVahicalValues VehicalName setting values " + unit + "  -->Col No" + i);



							}

							if (rsmd.getColumnName(i).equals("NORM_VAL_MALE")) {

								pstat.setString(i, normalValuesMale);
								System.out.println("From addVahicalValues VehicalName setting values " + normalValuesMale + "  -->Col No" + i);


							}

							if (rsmd.getColumnName(i).equals("NORM_VAL_FEMALE")) {
								pstat.setString(i, normalValuesFeMale);
								System.out.println("From addVahicalValues  VehicalFuelType setting values " + normalValuesFeMale+ "  -->Col No" + i);


							}


							if (rsmd.getColumnName(i).equals("NORM_VAL_MALE_CHILD")) {

								pstat.setString(i, normalValuesChildMale);
								System.out.println("From addVahicalValues VehicalName setting values " + normalValuesChildMale + "  -->Col No" + i);


							}

							if (rsmd.getColumnName(i).equals("NORM_VAL_FEMALE_CHILD")) {
								pstat.setString(i, normalValuesChildFeMale);
								System.out.println("From addVahicalValues  VehicalFuelType setting values " + normalValuesChildFeMale+ "  -->Col No" + i);


							}

							if (rsmd.getColumnName(i).equals("STATUS")) {
								pstat.setString(i, status);
								System.out.println("From addVahicalValues  VehicalModel setting values " + status + "  -->Col No" + i);

							}
							if (rsmd.getColumnName(i).equals("TEST_NOTE")) {
								pstat.setString(i, testNote);

								System.out.println("From addVahicalValues  VehicalModel setting values " + testNote + "  -->Col No" + i);


							}




							if (rsmd.getColumnName(i).equals("SEARCH_KEY")) {
								pstat.setString(i, searchKey);
								System.out.println("From addVahicalValues  VehicalModel setting values " + searchKey + "  -->Col No" + i);

							}

						}






					insertVal = pstat.executeUpdate();
				}        //boolean insertVal=pstat.execute();

				System.out.println("From DB addVahicalValues row inserted");
				if (insertVal > 0) {
					System.out.println("Value from exUpdate--->" + insertVal);

					//JOptionPane.showMessageDialog(null,"Done!!");

					//addGoodsNameDetails(con,materialName , goodsStatus,goodsTableName,gstFlagsVal);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "From addVahicalValues Error My Dear : " + ex);
			}


			return	uniQID;
		}
		return 0 ;

	}


	public boolean deleteFromTables(Connection con, JTable table, String tableName, String colName, String strKey, String strDelKey, String[] gstFlagsVal, String ordType, String colVal) {

		boolean flag=false;

		int rowCount= table.getRowCount();

		int[] selectedRow = table.getSelectedRows();


		if(strKey.equals("delete")) {

			try {



				if(strDelKey.equals("delorder"))
				{

	                String query="DELETE FROM " + tableName + " WHERE " + colName + " = '" + colVal + "'";

                    //JOptionPane.showMessageDialog(null, query);
					System.out.println("Deleting Record...");
						//JOptionPane.showMessageDialog(null, "Updated!!");

						String tabName = "";

						String columnName ="ID";
					    String tabNameOrdId = "";
						if(ordType!=null && ordType.equals("simpleord")) {
							tabName = "simple_goods_detail";
							tabNameOrdId = "simple_order_ids";
							}
						else {
							tabName = "goods_detail";
							tabNameOrdId = "order_ids";
						}



						//flag = addStockQtyForDelOrd(strDelKey,con,rowCount,tabName,columnName,table,gstFlagsVal,flag);


					for (int x = 0; x < rowCount; x++) {
						if (gstFlagsVal[0].equals("stategst")) {

							float igstRate= Float.valueOf(table.getValueAt(x, 7).toString());
							float igstAmt= Float.valueOf(table.getValueAt(x, 8).toString());
							float amount= Float.valueOf(table.getValueAt(x, 9).toString());
							String searchKeyVal= table.getValueAt(x, 13).toString();

							flag = 	delOrderDetailAndGoodsDetail(con, table,tabName,x,0,0,0,0,igstRate,igstAmt,0,0,amount,searchKeyVal,rowCount);
									//con, table, rowCount, rsmd, columnCount, tableName, ordId, partyName, quotationName, quotationId, inTableName,0,0,0,0,igstRate,igstAmt,0,0,amount,searchKeyVal,x);

						} else if (gstFlagsVal[0].equals("localgst")) {

							float cgstRate= Float.valueOf(table.getValueAt(x, 7).toString());
							float cgstAmt= Float.valueOf(table.getValueAt(x, 8).toString());
							float sgstRate= Float.valueOf(table.getValueAt(x, 9).toString());
							float sgstAmt= Float.valueOf(table.getValueAt(x, 10).toString());

							float amount= Float.valueOf(table.getValueAt(x, 11).toString());
							String searchKeyVal= table.getValueAt(x, 15).toString();

							flag = 	delOrderDetailAndGoodsDetail(con, table,tabName,x,cgstRate,cgstAmt,sgstRate,sgstAmt,0,0,0,0,amount,searchKeyVal, rowCount);


						} else if (gstFlagsVal[0].equals("normalgst")) {
							float normGstRate= Float.valueOf(table.getValueAt(x, 7).toString());
							float normGstAmt= Float.valueOf(table.getValueAt(x, 8).toString());
							float amount= Float.valueOf(table.getValueAt(x, 9).toString());
							String searchKeyVal= table.getValueAt(x, 13).toString();

							//setOrderDetailAndGoodsDetail(con, table, rowCount, rsmd, columnCount, tableName, ordId, partyName, quotationName, quotationId, inTableName,0,0,0,0,0,0,normGstRate,normGstAmt,amount,searchKeyVal, x);
							flag = 	delOrderDetailAndGoodsDetail(con, table,tabName,x,0,0,0,0,0,0,normGstRate,normGstAmt,amount,searchKeyVal, rowCount);

						}

					}

						if(flag==true) {

							PreparedStatement outpstat = con.prepareStatement(query);


							int val = outpstat.executeUpdate();

							String queryOrdId="DELETE FROM " + tabNameOrdId + " WHERE " + colName + " = '" + colVal + "'";

							PreparedStatement outpstatOrdId = con.prepareStatement(queryOrdId);


							int valOrdId = outpstatOrdId.executeUpdate();



							return flag;
						}
					}
					else {
					for (int x = 0; x < rowCount; x++) {

						String colValSno = String.valueOf(table.getValueAt(x, 0));

						String query="DELETE FROM " + tableName + " WHERE " + colName + "=" + colValSno + "";

                        JOptionPane.showMessageDialog(null, query);

						PreparedStatement outpstat = con.prepareStatement(query);


						int val = outpstat.executeUpdate();


						if (val > 0) {

							System.out.println("Record Deleted");
							//JOptionPane.showMessageDialog(null, "Updated!!");
							flag = true;
						}

					}
				}
				if(flag==true)
				return flag;

			} catch (Exception e) {

				e.printStackTrace();

				JOptionPane.showMessageDialog(null, "Error!!"+e);

			}

		}
		else if(strKey.equals("deleteQty"))
		{
			       //return deleteStockQty(strKey,con,rowCount,tableName,colName,table,gstFlagsVal,flag);

			for (int x = 0; x < rowCount; x++) {
				switch (gstFlagsVal[0]) {
					case "stategst": {

						float igstRate = Float.valueOf(table.getValueAt(x, 7).toString());
						float igstAmt = Float.valueOf(table.getValueAt(x, 8).toString());
						float amount = Float.valueOf(table.getValueAt(x, 9).toString());
						String searchKeyVal = table.getValueAt(x, 13).toString();

						return deleteStockQtyFun(con, table, tableName, x, 0, 0, 0, 0, igstRate, igstAmt, 0, 0, amount, searchKeyVal, rowCount);
						//con, table, rowCount, rsmd, columnCount, tableName, ordId, partyName, quotationName, quotationId, inTableName,0,0,0,0,igstRate,igstAmt,0,0,amount,searchKeyVal,x);

					}
					case "localgst": {

						float cgstRate = Float.valueOf(table.getValueAt(x, 7).toString());
						float cgstAmt = Float.valueOf(table.getValueAt(x, 8).toString());
						float sgstRate = Float.valueOf(table.getValueAt(x, 9).toString());
						float sgstAmt = Float.valueOf(table.getValueAt(x, 15).toString());

						float amount = Float.valueOf(table.getValueAt(x, 11).toString());
						String searchKeyVal = table.getValueAt(x, 12).toString();

						return deleteStockQtyFun(con, table, tableName, x, cgstRate, cgstAmt, sgstRate, sgstAmt, 0, 0, 0, 0, amount, searchKeyVal, rowCount);


					}
					case "normalgst": {
						float normGstRate = Float.valueOf(table.getValueAt(x, 7).toString());
						float normGstAmt = Float.valueOf(table.getValueAt(x, 8).toString());
						float amount = Float.valueOf(table.getValueAt(x, 9).toString());
						String searchKeyVal = table.getValueAt(x, 13).toString();

						//setOrderDetailAndGoodsDetail(con, table, rowCount, rsmd, columnCount, tableName, ordId, partyName, quotationName, quotationId, inTableName,0,0,0,0,0,0,normGstRate,normGstAmt,amount,searchKeyVal, x);
						return deleteStockQtyFun(con, table, tableName, x, 0, 0, 0, 0, 0, 0, normGstRate, normGstAmt, amount, searchKeyVal, rowCount);

					}
				}

			}
			       


		}
		/*else if(strKey!=null && strKey.equals("delorder")) {

			try{
				float totalAmount =0.0f;
				float cGstAmount = 0.0f;
				float sGstAmount = 0.0f;
				float iGstAmount = 0.0f;


				for (int x = 0; x < rowCount; x++) {

				*//*	ID INT ,DESCRIPTION_OF_GOODS VARCHAR(30000) , HSN_SAC_CODE VARCHAR(30000), QTY INT," +
					"UNIT VARCHAR(30000), PRICE FLOAT, DISCOUNT FLOAT, CGST_RATE FLOAT," +
							"CGST_AMOUNT FLOAT, SGST_RATE FLOAT, SGST_AMOUNT FLOAT, IGST_RATE FLOAT , IGST_AMOUNT FLOAT,AMOUNT FLOAT, ENTRY_DATE VARCHAR(30000)," +
							"ORDER_ID VARCHAR(30000), PARTY_NAME VARCHAR(30000), QUOTATION_NAME VARCHAR(30000)," +
							"QUOTATION_ID
*//*
					String goodsSNO = table.getValueAt(x,0).toString();

					String goodsName = table.getValueAt(x,1).toString();
					String hsnSacCode = table.getValueAt(x,2).toString();
					String qtyVal = table.getValueAt(x,3).toString();

					String goodsSize = table.getValueAt(x,4).toString();
					String goodsPriceVal = table.getValueAt(x,5).toString();
					String discount = table.getValueAt(x,6).toString();


					String cGSTRateVal = table.getValueAt(x,7).toString();
					String sGSTRateVal = table.getValueAt(x,9).toString();
					String iGSTRateVal = table.getValueAt(x,11).toString();

					String normGSTRateVal = table.getValueAt(x,13).toString();


					String entryDate = table.getValueAt(x,17).toString();
					String orderId = table.getValueAt(x,18).toString();
					String partyName = table.getValueAt(x,19).toString();
					String quotationName = table.getValueAt(x,20).toString();
					String quotationId = table.getValueAt(x,21).toString();



					//String iGSTRateVal = table.getValueAt(x,11).toString();

					float goodsPrice = 0;
					float  cGSTRate = 0;
					float sGSTRate = 0;
					float qty = 0;
					float iGSTRate=0;


					float normGSTRate = 0;
					float normGstAmount = 0;
					if (!(goodsName.equals("")) && !(goodsSize.equals("")) && !(discount.equals("")) && !(goodsPriceVal.equals("")) && !(cGSTRateVal.equals(""))
							&& !(sGSTRateVal.equals("")) && !(qtyVal.equals(""))) {



						goodsPrice = Float.parseFloat(goodsPriceVal);
						qty = Float.parseFloat(qtyVal);



						//txtMaterialCalcAmount.setText("" + totalAmount);
						//flag = true;


						if (gstFlagsVal[0].equals("stategst")) {

							iGSTRate=Float.parseFloat(iGSTRateVal);

							iGstAmount=(qty * goodsPrice * iGSTRate) / 100;

							totalAmount = ((goodsPrice * qty) + iGstAmount)-Float.parseFloat(discount);


							{
								//JOptionPane.showMessageDialog(null, "Already Exist!!!");

					*//*ID INT ,DESCRIPTION_OF_GOODS VARCHAR(30000) , HSN_SAC_CODE VARCHAR(30000), QTY INT," +
					"UNIT VARCHAR(30000), PRICE FLOAT, DISCOUNT FLOAT, CGST_RATE INT," +
							"CGST_AMOUNT FLOAT, SGST_RATE INT, SGST_AMOUNT FLOAT, AMOUNT FLOAT, ENTRY_DATE VARCHAR(30000)," +
							"ORDER_ID VARCHAR(30000), PARTY_NAME VARCHAR(30000), QUOTATION_NAME VARCHAR(30000)," +
							"QUOTATION_ID VARCHAR(30000)
*//*


								try {
									PreparedStatement pstat = con.prepareStatement("update " + tableName + " set DESCRIPTION_OF_GOODS = ?,HSN_SAC_CODE = ?, QTY = ?, UNIT = ?,PRICE=?, DISCOUNT =?,  IGST_RATE = ? , IGST_AMOUNT = ?, AMOUNT = ? ,PARTY_NAME = ? ,QUOTATION_NAME = ? " +
											"   where ID = ? AND ORDER_ID = ?");


									pstat.setString(1, goodsName);
									pstat.setString(2,hsnSacCode);
									pstat.setInt(3, Integer.parseInt(qtyVal));

									pstat.setString(4, goodsSize);

									pstat.setFloat(5, goodsPrice);

									pstat.setFloat(6, Float.parseFloat(discount));

									pstat.setFloat(7, iGSTRate);
									pstat.setFloat(8, iGstAmount);



									pstat.setFloat(9, totalAmount);

									//pstat.setString(10, entryDate);
									//pstat.setString(11, orderId);
									pstat.setString(10, partyName);
									pstat.setString(11, quotationName);
									//pstat.setString(12, quotationId);





									pstat.setInt(12, Integer.parseInt(goodsSNO));
									pstat.setString(13, orderId);



									int updateVal = pstat.executeUpdate();
									if (updateVal > 0) {
										System.out.println("Value from exUpdate--->" + updateVal);
										//JOptionPane.showMessageDialog(null, "Updated!!");

										flag=true;
									}

								}catch (Exception e)
								{

									e.printStackTrace();

									JOptionPane.showMessageDialog(null, "UpadteOrderError !!"+e);



								}






							}




						} else if (gstFlagsVal[0].equals("localgst")){


							cGSTRate = Float.parseFloat(cGSTRateVal);
							sGSTRate = Float.parseFloat(sGSTRateVal);

							cGstAmount = (qty * goodsPrice * cGSTRate) / 100;

							//txtMaterialCGSTAmount.setText("" + cGstAmount);

							sGstAmount = (qty * goodsPrice * sGSTRate) / 100;

							//txtMaterialSGSTAmount.setText("" + sGstAmount);

							totalAmount = ((goodsPrice * qty) + cGstAmount + sGstAmount)-Float.parseFloat(discount);

							{
								//JOptionPane.showMessageDialog(null, "Already Exist!!!");

					*//*ID INT ,DESCRIPTION_OF_GOODS VARCHAR(30000) , HSN_SAC_CODE VARCHAR(30000), QTY INT," +
					"UNIT VARCHAR(30000), PRICE FLOAT, DISCOUNT FLOAT, CGST_RATE INT," +
							"CGST_AMOUNT FLOAT, SGST_RATE INT, SGST_AMOUNT FLOAT, AMOUNT FLOAT, ENTRY_DATE VARCHAR(30000)," +
							"ORDER_ID VARCHAR(30000), PARTY_NAME VARCHAR(30000), QUOTATION_NAME VARCHAR(30000)," +
							"QUOTATION_ID VARCHAR(30000)
*//*


								try {
									PreparedStatement pstat = con.prepareStatement("update " + tableName + " set DESCRIPTION_OF_GOODS = ?,HSN_SAC_CODE = ?, QTY = ?, UNIT = ?,PRICE=?, DISCOUNT =?, CGST_RATE = ?," +
											"CGST_AMOUNT= ?,  SGST_RATE = ?," +
											" SGST_AMOUNT= ?, AMOUNT = ? ,PARTY_NAME = ? ,QUOTATION_NAME = ?" +
											"   where ID = ? AND ORDER_ID = ?");


									pstat.setString(1, goodsName);
									pstat.setString(2,hsnSacCode);
									pstat.setInt(3, Integer.parseInt(qtyVal));

									pstat.setString(4, goodsSize);

									pstat.setFloat(5, goodsPrice);

									pstat.setFloat(6, Float.parseFloat(discount));
									pstat.setFloat(7, cGSTRate);

									pstat.setFloat(8, cGstAmount);

									pstat.setFloat(9, sGSTRate);

									pstat.setFloat(10, sGstAmount);

									pstat.setFloat(11, totalAmount);

									//pstat.setString(10, entryDate);
									//pstat.setString(11, orderId);
									pstat.setString(12, partyName);
									pstat.setString(13, quotationName);
									pstat.setInt(14, Integer.parseInt(goodsSNO));
									pstat.setString(15, orderId);



									int updateVal = pstat.executeUpdate();
									if (updateVal > 0) {
										System.out.println("Value from exUpdate--->" + updateVal);
										//JOptionPane.showMessageDialog(null, "Updated!!");

										flag=true;
									}

								}catch (Exception e)
								{

									e.printStackTrace();

									JOptionPane.showMessageDialog(null, "UpadteOrderError !!"+e);



								}






							}
						}
						else if (gstFlagsVal[0].equals("normalgst")) {

							normGSTRate=Float.parseFloat(normGSTRateVal);

							normGstAmount=(qty * goodsPrice * normGSTRate) / 100;

							totalAmount = ((goodsPrice * qty) + normGstAmount)-Float.parseFloat(discount);


							{
								//JOptionPane.showMessageDialog(null, "Already Exist!!!");

					*//*ID INT ,DESCRIPTION_OF_GOODS VARCHAR(30000) , HSN_SAC_CODE VARCHAR(30000), QTY INT," +
					"UNIT VARCHAR(30000), PRICE FLOAT, DISCOUNT FLOAT, CGST_RATE INT," +
							"CGST_AMOUNT FLOAT, SGST_RATE INT, SGST_AMOUNT FLOAT, AMOUNT FLOAT, ENTRY_DATE VARCHAR(30000)," +
							"ORDER_ID VARCHAR(30000), PARTY_NAME VARCHAR(30000), QUOTATION_NAME VARCHAR(30000)," +
							"QUOTATION_ID VARCHAR(30000)
*//*


								try {
									PreparedStatement pstat = con.prepareStatement("update " + tableName + " set DESCRIPTION_OF_GOODS = ?,HSN_SAC_CODE = ?, QTY = ?, UNIT = ?,PRICE=?, DISCOUNT =?, NORM_GST_RATE = ? , NORM_GST_AMOUNT = ?, AMOUNT = ?  ,PARTY_NAME = ? ,QUOTATION_NAME = ? " +
											"   where ID = ? AND ORDER_ID = ?");


									pstat.setString(1, goodsName);
									pstat.setString(2,hsnSacCode);
									pstat.setInt(3, Integer.parseInt(qtyVal));

									pstat.setString(4, goodsSize);

									pstat.setFloat(5, goodsPrice);

									pstat.setFloat(6, Float.parseFloat(discount));

									pstat.setFloat(7, normGSTRate);
									pstat.setFloat(8, normGstAmount);

									pstat.setFloat(9, totalAmount);

									//pstat.setString(10, entryDate);
									//pstat.setString(11, orderId);
									pstat.setString(10, partyName);
									pstat.setString(11, quotationName);
									//pstat.setString(12, quotationId);







									pstat.setInt(12, Integer.parseInt(goodsSNO));
									pstat.setString(13, orderId);



									int updateVal = pstat.executeUpdate();
									if (updateVal > 0) {
										System.out.println("Value from exUpdate--->" + updateVal);
										//JOptionPane.showMessageDialog(null, "Updated!!");

										flag=true;
									}

								}catch (Exception e)
								{

									e.printStackTrace();

									JOptionPane.showMessageDialog(null, "UpadteOrderError !!"+e);



								}






							}


						}

					} else {
						JOptionPane.showMessageDialog(null, "Fields are empty", "Message", 1);

						return false;
					}





					if(totalAmount>1)
					{

					}


				}

				if(flag==true)
					return flag;


			} catch (Exception e) {

				e.printStackTrace();

				JOptionPane.showMessageDialog(null, "Error !!"+e);



			}

		}*/
		else if(strKey!=null && strKey.equals("delgoodsnames")) {

			try{


				for (int x = 0; x < rowCount; x++) {





					String goodsSNO = table.getValueAt(x,0).toString();

					String goodsName = table.getValueAt(x,1).toString();



					if (!(goodsSNO.equals("")) && !(goodsName.equals(""))) {


					} else {
						JOptionPane.showMessageDialog(null, "Fields are empty", "Message", 1);

						return false;
					}




						try {
							PreparedStatement pstat = con.prepareStatement("update " + tableName + " set DESCRIPTION_OF_GOODS = ?  where ID = ?");


							pstat.setString(1, goodsName);


							pstat.setInt(2, Integer.parseInt(goodsSNO));



							int updateVal = pstat.executeUpdate();
							if (updateVal > 0) {
								System.out.println("Value from exUpdate--->" + updateVal);
								//JOptionPane.showMessageDialog(null, "Updated!!");

								flag=true;
							}

						}catch (Exception e)
						{

							e.printStackTrace();

							JOptionPane.showMessageDialog(null, "GoodsNameInError !!"+e);



						}

				}

				if(flag==true)
					return flag;


			} catch (Exception e) {

				e.printStackTrace();

				JOptionPane.showMessageDialog(null, "Error !!"+e);



			}

		}
	else if(strKey!=null && strKey.equals("delstock")) {
			//return deleteStockQty(strKey,con,rowCount,tableName,colName,table,gstFlagsVal,flag);


			for (int x = 0; x < rowCount; x++) {

				String goodsSNO = table.getValueAt(x,0).toString();
				String goodsName = table.getValueAt(x,1).toString();
				String hsnSacCode = table.getValueAt(x,2).toString();
				String qtyVal = table.getValueAt(x,3).toString();
				String goodsSize = table.getValueAt(x,4).toString();
				String goodsPriceVal = table.getValueAt(x,5).toString();
				String discount = table.getValueAt(x,6).toString();




				if (gstFlagsVal[0].equals("stategst")) {


					float igstRate= Float.valueOf(table.getValueAt(x, 7).toString());
					float igstAmt= Float.valueOf(table.getValueAt(x, 8).toString());
					float amount= Float.valueOf(table.getValueAt(x, 9).toString());
					String searchKeyVal= table.getValueAt(x, 10).toString();

					return updateStockQtyFun(con, table,tableName,x,goodsSNO,goodsName,hsnSacCode,qtyVal,goodsSize,goodsPriceVal,discount,0,0,0,0,igstRate,igstAmt,0,0,amount,searchKeyVal,rowCount);
					//con, table, rowCount, rsmd, columnCount, tableName, ordId, partyName, quotationName, quotationId, inTableName,0,0,0,0,igstRate,igstAmt,0,0,amount,searchKeyVal,x);

				} else if (gstFlagsVal[0].equals("localgst")) {

					float cgstRate= Float.valueOf(table.getValueAt(x, 7).toString());
					float cgstAmt= Float.valueOf(table.getValueAt(x, 8).toString());
					float sgstRate= Float.valueOf(table.getValueAt(x, 9).toString());
					float sgstAmt= Float.valueOf(table.getValueAt(x, 10).toString());

					float amount= Float.valueOf(table.getValueAt(x, 11).toString());
					String searchKeyVal= table.getValueAt(x, 12).toString();

					return updateStockQtyFun(con, table,tableName,x,goodsSNO,goodsName,hsnSacCode,qtyVal,goodsSize,goodsPriceVal,discount,cgstRate,cgstAmt,sgstRate,sgstAmt,0,0,0,0,amount,searchKeyVal, rowCount);


				} else if (gstFlagsVal[0].equals("normalgst")) {
					float normGstRate= Float.valueOf(table.getValueAt(x, 7).toString());
					float normGstAmt= Float.valueOf(table.getValueAt(x, 8).toString());
					float amount= Float.valueOf(table.getValueAt(x, 9).toString());
					String searchKeyVal= table.getValueAt(x, 10).toString();

					//setOrderDetailAndGoodsDetail(con, table, rowCount, rsmd, columnCount, tableName, ordId, partyName, quotationName, quotationId, inTableName,0,0,0,0,0,0,normGstRate,normGstAmt,amount,searchKeyVal, x);
					return updateStockQtyFun(con, table,tableName,x,goodsSNO,goodsName,hsnSacCode,qtyVal,goodsSize,goodsPriceVal,discount,0,0,0,0,0,0,normGstRate,normGstAmt,amount,searchKeyVal, rowCount);

				}

			}



		}
		else if(strKey!=null && strKey.equals("deltransport")){

			try {


				for (int x = 0; x < rowCount; x++) {


					String sNO = table.getValueAt(x, 0).toString();

					String transportName = table.getValueAt(x, 1).toString();
					String lrNo = table.getValueAt(x, 2).toString();
					String bankName = table.getValueAt(x, 3).toString();


					String bankAccNo = table.getValueAt(x, 4).toString();
					String ifscCode = table.getValueAt(x, 5).toString();
					String agent = table.getValueAt(x, 6).toString();

					String totalDagina = table.getValueAt(x, 7).toString();

					if (!(sNO.equals("")) && !(transportName.equals("")) && !(lrNo.equals("")) && !(bankName.equals(""))
							&& !(bankAccNo.equals(""))
							&& !(agent.equals("")) && !(totalDagina.equals(""))) {


					} else {
						JOptionPane.showMessageDialog(null, "Fields are empty", "Message", 1);

						return false;
					}


					PreparedStatement	pstat = con.prepareStatement("update " + tableName + " set TRANSPORT_NAME = ?,LR_NO = ?, BANK_NAME= ? ,BANK_ACC_NO= ?, IFSC_CODE =?,AGENT= ?, TOTAL_DAGINA= ? where ID = ?");



					pstat.setString(1, transportName);

					pstat.setString(2, lrNo);

					pstat.setString(3, bankName);
					pstat.setString(4, bankAccNo);

					pstat.setString(5, ifscCode);

					pstat.setString(6, agent);

					pstat.setString(7,totalDagina);







					pstat.setInt(8, Integer.parseInt(sNO));

					int updateVal = pstat.executeUpdate();
					if (updateVal > 0) {
						System.out.println("Value from exUpdate--->" + updateVal);

						flag=true;

					}


				}


				if(flag==true)
					return flag;

			}
			catch (Exception e)
			{

				e.printStackTrace();

				JOptionPane.showMessageDialog(null, "Error !!"+e);



			}

		}
		else if(strKey!=null && strKey.equals("delquotation")){

			try {

				for (int x = 0; x < rowCount; x++) {

					String sNO = table.getValueAt(x, 0).toString();

					String quotationName = table.getValueAt(x, 1).toString();
					String gstNo = table.getValueAt(x, 2).toString();
					String bnkName = table.getValueAt(x, 3).toString();


					String bnkAccNo = table.getValueAt(x, 4).toString();
					String termsCond1 = table.getValueAt(x, 5).toString();
					String termsCond2 = table.getValueAt(x, 6).toString();
					String termsCond3 = table.getValueAt(x, 7).toString();


					if (!(sNO.equals("")) && !(quotationName.equals("")) && !(gstNo.equals(""))
							&& !(bnkName.equals("")) && !(bnkAccNo.equals(""))
							&& !(termsCond1.equals("")) && !(termsCond2.equals("")) && !(termsCond3.equals("")))
					{


					} else {
						JOptionPane.showMessageDialog(null, "Fields are empty", "Message", 1);

						return false;
					}


					PreparedStatement	pstat = con.prepareStatement("update " + tableName + " set QUOTATION_NAME = ?, GST_NO = ?, BNK_NAME = ?, BNKACC_NO = ?, TERMS_COND1 = ?, TERMS_COND2 = ? , TERMS_COND3 = ? where ID = ?");



					pstat.setString(1, quotationName);

					pstat.setString(2, gstNo);

					pstat.setString(3, bnkName);
					pstat.setString(4, bnkAccNo);

					pstat.setString(5, termsCond1);

					pstat.setString(6, termsCond2);

					pstat.setString(7,termsCond3);







					pstat.setInt(8, Integer.parseInt(sNO));

					int updateVal = pstat.executeUpdate();
					if (updateVal > 0) {
						System.out.println("Value from exUpdate--->" + updateVal);


						flag=true;

					}


				}



				if(flag==true)
					return flag;


			}
			catch (Exception e)
			{

				e.printStackTrace();

				JOptionPane.showMessageDialog(null, "Error !!"+e);

			}

		}else if(strKey!=null && strKey.equals("delsupplier")){

			try {

				for (int x = 0; x < rowCount; x++) {


					String sNO = table.getValueAt(x, 0).toString();

					String name = table.getValueAt(x, 1).toString();
					String phoneNo = table.getValueAt(x, 2).toString();


					String address = table.getValueAt(x, 3).toString();
					String remark = table.getValueAt(x, 4).toString();
					String entryDate = table.getValueAt(x, 5).toString();


					if (!(sNO.equals("")) && !(name.equals("")) && !(phoneNo.equals(""))
							&& !(address.equals(""))
							&& !(remark.equals("")) && !(entryDate.equals(""))) {


					} else {
						JOptionPane.showMessageDialog(null, "Fields are empty", "Message", 1);

						return false;
					}


					PreparedStatement pstat = con.prepareStatement("update " + tableName + " set BUYER_NAME = ? ,PHONE_NO= ?, ADDRESS  = ?, REMARK = ?,ENTRY_DATE = ? where ID = ?");


					pstat.setString(1, name);
					pstat.setString(2, phoneNo);
					pstat.setString(3, address);
					pstat.setString(4, remark);
					pstat.setString(5, entryDate);

					pstat.setInt(6, Integer.parseInt(sNO));

					int insertVal = pstat.executeUpdate();
					if (insertVal > 0) {
						System.out.println("Value from exUpdate--->" + insertVal);

						flag=true;
					}


				}

				if(flag==true)
					return flag;


			}
			catch (Exception e)
			{

				e.printStackTrace();

				JOptionPane.showMessageDialog(null, "Error!!"+e);

			}

		}else if(strKey!=null && strKey.equals("delparty")){

			try {

				for (int x = 0; x < rowCount; x++) {


					String sNO = table.getValueAt(x, 0).toString();

					String name = table.getValueAt(x, 1).toString();
					String phoneNo = table.getValueAt(x, 2).toString();
					String gstNo = table.getValueAt(x, 3).toString();


					String address = table.getValueAt(x, 4).toString();
					String remark = table.getValueAt(x, 5).toString();
					String entryDate = table.getValueAt(x, 6).toString();


					if (!(sNO.equals("")) && !(name.equals("")) && !(phoneNo.equals("")) && !(gstNo.equals(""))
							&& !(address.equals(""))
							&& !(remark.equals("")) && !(entryDate.equals(""))) {


					} else {
						JOptionPane.showMessageDialog(null, "Fields are empty", "Message", 1);

						return false;
					}


					PreparedStatement pstat = con.prepareStatement("update " + tableName + " set BUYER_NAME = ? ,PHONE_NO= ?, GST_NO = ?,ADDRESS  = ?, REMARK = ?,ENTRY_DATE = ? where ID = ?");


					pstat.setString(1, name);
					pstat.setString(2, phoneNo);
					pstat.setString(3, gstNo);
					pstat.setString(4, address);
					pstat.setString(5, remark);
					pstat.setString(6, entryDate);

					pstat.setInt(7, Integer.parseInt(sNO));

					int insertVal = pstat.executeUpdate();
					if (insertVal > 0) {
						System.out.println("Value from exUpdate--->" + insertVal);

						flag=true;
					}


				}



				if(flag==true)
					return flag;


			}
			catch (Exception e)
			{

				e.printStackTrace();

				JOptionPane.showMessageDialog(null, "Error!!"+e);

			}

		}



				return flag;
	}

	private boolean updateStockQtyFun(Connection con, JTable table, String tableName, int x, String goodsSNO, String goodsName, String hsnSacCode, String qtyVal, String goodsSize, String goodsPriceVal, String discount, float cgstRate, float cgstAmt, float sgstRate, float sgstAmt, float igstRate, float igstAmt, float normGstRate, float normGstAmt, float amount, String searchKeyVal, int rowCount) {
		//inTableName="goods_detail";

		//String inTableName="goods_detail";
		boolean flag=false;
		try{
			Statement instat = con.createStatement();

			ResultSet inresult = instat.executeQuery("select * from " + tableName +" where ID ="+table.getValueAt(x,0).toString()+"");

			int insertVal=0;


			int qty =0;
			float goodsPrice=0;
			float cGstAmount=0;
			float sGstAmount=0;
			float iGstAmount=0;
			float normGstAmount=0;
			float totalAmount=0;

			if(inresult.next())
			{

				qty = Integer.parseInt(qtyVal);
				//totalAmount = ((goodsPrice * qty) + iGstAmount)-Float.parseFloat(discount);
				goodsPrice=Float.parseFloat(goodsPriceVal);

				cGstAmount = (qty * goodsPrice * cgstRate) / 100;


				sGstAmount = (qty * goodsPrice * sgstRate) / 100;

				//totalAmount = ((goodsPrice * qty) + cGstAmount + sGstAmount)-Float.parseFloat(discount);

				iGstAmount=(qty * goodsPrice * igstRate) / 100;


				normGstAmount=(qty * goodsPrice * normGstRate) / 100;


				totalAmount = ((goodsPrice * qty) + cGstAmount + sGstAmount + iGstAmount + normGstAmount) - Float.parseFloat(discount);


				//JOptionPane.showMessageDialog(null, "Already Exist!!!");



				try {
					PreparedStatement pstat = con.prepareStatement("update " + tableName + " set DESCRIPTION_OF_GOODS = ?,HSN_SAC_CODE = ?, QTY = ?, UNIT = ?,PRICE = ?, DISCOUNT =?, CGST_RATE = ?,CGST_AMOUNT= ?, SGST_RATE = ?, SGST_AMOUNT= ?,  IGST_RATE = ? ,IGST_AMOUNT = ? ,  NORM_GST_RATE = ? ,NORM_GST_AMOUNT = ? , AMOUNT = ?  where ID = ?");
					pstat.setString(1, goodsName);
					pstat.setString(2,hsnSacCode);
					pstat.setInt(3, qty);
					pstat.setString(4, goodsSize);
					pstat.setFloat(5, goodsPrice);
					pstat.setFloat(6, Float.parseFloat(discount));
					pstat.setFloat(7, cgstRate);
					pstat.setFloat(8, cGstAmount);
					pstat.setFloat(9, sgstRate);
					pstat.setFloat(10, sGstAmount);
					pstat.setFloat(11, igstRate);
					pstat.setFloat(12, iGstAmount);

					pstat.setFloat(13, normGstRate);
					pstat.setFloat(14, normGstAmount);


					pstat.setFloat(15, totalAmount);
					pstat.setInt(16, Integer.parseInt(goodsSNO));



					int updateVal = pstat.executeUpdate();
					if (updateVal > 0) {
						System.out.println("Value from exUpdate--->" + insertVal);
						//JOptionPane.showMessageDialog(null, "Updated!!");


						if((rowCount-1)==x)
						{
							flag= true;
							return flag;
						}

					}

				}catch (Exception e)
				{
					//JOptionPane.showMessageDialog(null, "delStockQtyFun In Error : "+e);

					e.printStackTrace();
				}






			}
		}catch (Exception e)
		{
			//JOptionPane.showMessageDialog(null, "delStockQtyFunError : "+e);
			e.printStackTrace();
		}


		return flag;
	}

	private boolean deleteStockQtyFun(Connection con, JTable table, String tabName, int x, float cgstRate, float cgstAmt, float sgstRate, float sgstAmt, float igstRate, float igstAmt, float normGstRate, float normGstAmt, float amount, String searchKeyVal, int rowCount) {
		//inTableName="goods_detail";

		//String inTableName="goods_detail";
		boolean flag=false;
		try{
			Statement instat = con.createStatement();

			ResultSet inresult = instat.executeQuery("select * from " + tabName +" where ID ="+table.getValueAt(x,0).toString()+"");

			int insertVal=0;

			if(inresult.next())
			{






				int materialQtyVal=0;
				float calcAmountVal =0;
				float cGSTAmountVal= 0;
				float sGSTAmountVal= 0;
				float iGSTAmountVal= 0;
				float normGSTAmountVal= 0;

				ResultSetMetaData inrsmd = inresult.getMetaData();

				int colCount = inrsmd.getColumnCount();



				for (int i = 1; i <= colCount; i++) {


					if (inrsmd.getColumnName(i).equals("QTY")) {

						materialQtyVal= Integer.parseInt(inresult.getString(i))-Integer.parseInt(table.getValueAt(x,3).toString());
					}
					if (inrsmd.getColumnName(i).equals("AMOUNT")) {

						calcAmountVal = Float.valueOf(inresult.getString(i)) - amount ;

					}





					if (inrsmd.getColumnName(i).equals("CGST_AMOUNT")) {

						cGSTAmountVal = Float.valueOf(inresult.getString(i)) - cgstAmt ;



					}


					if (inrsmd.getColumnName(i).equals("SGST_AMOUNT")) {

						sGSTAmountVal = Float.valueOf(inresult.getString(i)) - sgstAmt ;



					}


					if (inrsmd.getColumnName(i).equals("IGST_AMOUNT")) {

						iGSTAmountVal = Float.valueOf(inresult.getString(i)) - igstAmt ;



					}


					if (inrsmd.getColumnName(i).equals("NORM_GST_AMOUNT")) {

						normGSTAmountVal = Float.valueOf(inresult.getString(i)) - normGstAmt ;



					}






				}




				//JOptionPane.showMessageDialog(null, "Already Exist!!!");



				try {
					PreparedStatement pstat = con.prepareStatement("update " + tabName + " set QTY = ?,  CGST_AMOUNT= ?, SGST_AMOUNT= ?, IGST_AMOUNT= ?,NORM_GST_AMOUNT =?, AMOUNT = ?  where ID = ?");


					pstat.setInt(1, materialQtyVal);
					pstat.setFloat(2, cGSTAmountVal);
					pstat.setFloat(3, sGSTAmountVal);
					pstat.setFloat(4, iGSTAmountVal);
					pstat.setFloat(5, normGSTAmountVal);
					pstat.setFloat(6, calcAmountVal);
					pstat.setString(7, table.getValueAt(x, 0).toString());



					int updateVal = pstat.executeUpdate();
					if (updateVal > 0) {
						System.out.println("Value from exUpdate--->" + insertVal);
						//JOptionPane.showMessageDialog(null, "Updated!!");


						if((rowCount-1)==x)
						{
							flag= true;
							return flag;
						}

					}

				}catch (Exception e)
				{
					//JOptionPane.showMessageDialog(null, "delStockQtyFun In Error : "+e);

					e.printStackTrace();
				}






			}
		}catch (Exception e)
		{
			//JOptionPane.showMessageDialog(null, "delStockQtyFunError : "+e);
			e.printStackTrace();
		}


		return flag;
	}

	private boolean delOrderDetailAndGoodsDetail(Connection con, JTable table, String tabName, int x, float cgstRate, float cgstAmt, float sgstRate, float sgstAmt, float igstRate, float igstAmt, float normGstRate, float normGstAmt, float amount, String searchKeyVal, int rowCount) {
		//inTableName="goods_detail";

		//String inTableName="goods_detail";
		boolean flag=false;
	try{
		Statement instat = con.createStatement();

		ResultSet inresult = instat.executeQuery("select * from " + tabName +" where ID ="+table.getValueAt(x,0).toString()+"");

		int insertVal=0;

		if(inresult.next())
		{






			int materialQtyVal=0;
			float calcAmountVal =0;
			float cGSTAmountVal= 0;
			float sGSTAmountVal= 0;
			float iGSTAmountVal= 0;
			float normGSTAmountVal= 0;

			ResultSetMetaData inrsmd = inresult.getMetaData();

			int colCount = inrsmd.getColumnCount();



			for (int i = 1; i <= colCount; i++) {


				if (inrsmd.getColumnName(i).equals("QTY")) {

					materialQtyVal= Integer.parseInt(inresult.getString(i))+Integer.parseInt(table.getValueAt(x,3).toString());
				}
				if (inrsmd.getColumnName(i).equals("AMOUNT")) {

					calcAmountVal = Float.valueOf(inresult.getString(i)) + amount ;

				}





				if (inrsmd.getColumnName(i).equals("CGST_AMOUNT")) {

					cGSTAmountVal = Float.valueOf(inresult.getString(i)) + cgstAmt ;



				}


				if (inrsmd.getColumnName(i).equals("SGST_AMOUNT")) {

					sGSTAmountVal = Float.valueOf(inresult.getString(i)) + sgstAmt ;



				}


				if (inrsmd.getColumnName(i).equals("IGST_AMOUNT")) {

					iGSTAmountVal = Float.valueOf(inresult.getString(i)) + igstAmt ;



				}


				if (inrsmd.getColumnName(i).equals("NORM_GST_AMOUNT")) {

					normGSTAmountVal = Float.valueOf(inresult.getString(i)) + normGstAmt ;



				}






			}




			//JOptionPane.showMessageDialog(null, "Already Exist!!!");



			try {
				PreparedStatement pstat = con.prepareStatement("update " + tabName + " set QTY = ?,  CGST_AMOUNT= ?, SGST_AMOUNT= ?, IGST_AMOUNT= ?,NORM_GST_AMOUNT =?, AMOUNT = ?  where ID = ?");


				pstat.setInt(1, materialQtyVal);
				pstat.setFloat(2, cGSTAmountVal);
				pstat.setFloat(3, sGSTAmountVal);
				pstat.setFloat(4, iGSTAmountVal);
				pstat.setFloat(5, normGSTAmountVal);
				pstat.setFloat(6, calcAmountVal);
				pstat.setString(7, table.getValueAt(x, 0).toString());



				int updateVal = pstat.executeUpdate();
				if (updateVal > 0) {
					System.out.println("Value from exUpdate--->" + insertVal);
					//JOptionPane.showMessageDialog(null, "Updated!!");


	                if((rowCount-1)==x)
					{
						flag= true;
						return flag;
					}

				}

			}catch (Exception e)
			{
				JOptionPane.showMessageDialog(null, "delOrderAndGoods In Error : "+e);

			}






		}
	  }catch (Exception e)
	{
		JOptionPane.showMessageDialog(null, "delOrderAndGoodsError : "+e);

	}


		return flag;
	}


	private boolean deleteStockQty(String strKey,Connection con, int rowCount, String tableName, String colName, JTable table, String[] gstFlagsVal, boolean flag) {

		try{

			for (int x = 0; x < rowCount; x++) {

				//inTableName="goods_detail";

				//String inTableName="goods_detail";

				System.out.println("Inserted");
				//JOptionPane.showMessageDialog(null,"Inserted");

				Statement instat = con.createStatement();


				ResultSet inresult = instat.executeQuery("select * from " + tableName +" where " + colName + "="+table.getValueAt(x,0).toString()+"");


				if(inresult.next())
				{






					int materialQtyVal=0;
					float calcAmountVal =0;
					float discountVal = 0;
					float cGSTAmountVal= 0;
					float sGSTAmountVal= 0;
					float iGSTAmountVal =0;
					float normGSTAmountVal =0;

					ResultSetMetaData inrsmd = inresult.getMetaData();

					int columnCount = inrsmd.getColumnCount();

					if (gstFlagsVal[0].equals("stategst"))
					{



								for (int i = 1; i <= columnCount; i++) {


									if (inrsmd.getColumnName(i).equals("QTY")) {

										materialQtyVal = Integer.parseInt(inresult.getString(i)) - Integer.parseInt(table.getValueAt(x, 3).toString());


									}
									if (inrsmd.getColumnName(i).equals("AMOUNT")) {

										calcAmountVal = Float.valueOf(inresult.getString(i)) - Float.valueOf(table.getValueAt(x, 15).toString());


									}


									if (inrsmd.getColumnName(i).equals("DISCOUNT")) {
										discountVal = Float.valueOf(inresult.getString(i));
										Float discount = Float.valueOf(table.getValueAt(x, 6).toString());
										if (discountVal > discount)
											discountVal = discountVal - discount;
										else
											discountVal = discount;


									}


									if (inrsmd.getColumnName(i).equals("IGST_AMOUNT")) {

										iGSTAmountVal = Float.valueOf(inresult.getString(i)) - Float.valueOf(table.getValueAt(x, 12).toString());
										;


									}

								}

								try {
									PreparedStatement pstat = con.prepareStatement("update " + tableName + " set QTY = ?, DISCOUNT =?, IGST_AMOUNT= ?,  AMOUNT = ?  where ID = ?");


									pstat.setInt(1, materialQtyVal);

									pstat.setFloat(2, discountVal);
									pstat.setFloat(3, iGSTAmountVal);
									pstat.setFloat(4, calcAmountVal);

									pstat.setInt(5, Integer.parseInt(table.getValueAt(x, 0).toString()));


									int updateVal = pstat.executeUpdate();
									if (updateVal > 0) {
										System.out.println("Value from exUpdate--->" + updateVal);
										//JOptionPane.showMessageDialog(null, "Updated!!");
										flag = true;

									}

								} catch (Exception e) {

									e.printStackTrace();

									JOptionPane.showMessageDialog(null, "InDelQtyError!!" + e);

								}






					}
					else if (gstFlagsVal[0].equals("localgst")){
						for (int i = 1; i <= columnCount; i++) {


							if (inrsmd.getColumnName(i).equals("QTY")) {

								materialQtyVal= Integer.parseInt(inresult.getString(i))-Integer.parseInt(table.getValueAt(x,3).toString());
							}
							if (inrsmd.getColumnName(i).equals("AMOUNT")) {

								calcAmountVal = Float.valueOf(inresult.getString(i)) - Float.valueOf(table.getValueAt(x,15).toString()) ;

							}




							if (inrsmd.getColumnName(i).equals("DISCOUNT")) {
								discountVal = Float.valueOf(inresult.getString(i));
								Float discount= Float.valueOf(table.getValueAt(x,6).toString());
								if(discountVal>discount)
									discountVal = discountVal - discount ;
								else
									discountVal=discount;



							}
							if (inrsmd.getColumnName(i).equals("CGST_AMOUNT")) {

								cGSTAmountVal = Float.valueOf(inresult.getString(i)) - Float.valueOf(table.getValueAt(x,8).toString()) ;



							}


							if (inrsmd.getColumnName(i).equals("SGST_AMOUNT")) {

								sGSTAmountVal = Float.valueOf(inresult.getString(i)) - Float.valueOf(table.getValueAt(x,10).toString()) ;



							}










						}
						try {
							PreparedStatement pstat = con.prepareStatement("update " + tableName + " set QTY = ?, DISCOUNT =?, CGST_AMOUNT= ?, SGST_AMOUNT= ?,  AMOUNT = ?  where ID = ?");


							pstat.setInt(1, materialQtyVal);

							pstat.setFloat(2, discountVal);
							pstat.setFloat(3, cGSTAmountVal);
							pstat.setFloat(4, sGSTAmountVal);


							pstat.setFloat(5, calcAmountVal);

							pstat.setInt(6, Integer.parseInt(table.getValueAt(x, 0).toString()));



							int updateVal = pstat.executeUpdate();
							if (updateVal > 0) {
								System.out.println("Value from exUpdate--->" + updateVal);
								//JOptionPane.showMessageDialog(null, "Updated!!");
								flag=true;

							}

						}catch (Exception e)
						{

							e.printStackTrace();

							JOptionPane.showMessageDialog(null, "InDelQtyError!!"+e);

						}



					}
					else if (gstFlagsVal[0].equals("normalgst")) {
						for (int i = 1; i <= columnCount; i++) {


							if (inrsmd.getColumnName(i).equals("QTY")) {

								materialQtyVal= Integer.parseInt(inresult.getString(i))-Integer.parseInt(table.getValueAt(x,3).toString());
							}
							if (inrsmd.getColumnName(i).equals("AMOUNT")) {

								calcAmountVal = Float.valueOf(inresult.getString(i)) - Float.valueOf(table.getValueAt(x,15).toString()) ;

							}




							if (inrsmd.getColumnName(i).equals("DISCOUNT")) {
								discountVal = Float.valueOf(inresult.getString(i));
								Float discount= Float.valueOf(table.getValueAt(x,6).toString());
								if(discountVal>discount)
									discountVal = discountVal - discount ;
								else
									discountVal=discount;



							}



							if (inrsmd.getColumnName(i).equals("NORM_GST_AMOUNT")) {

								normGSTAmountVal = Float.valueOf(inresult.getString(i)) - Float.valueOf(table.getValueAt(x, 14).toString());


							}

						}

						try {
							PreparedStatement pstat = con.prepareStatement("update " + tableName + " set QTY = ?, DISCOUNT =?, NORM_GST_AMOUNT= ?,  AMOUNT = ?  where ID = ?");


							pstat.setInt(1, materialQtyVal);

							pstat.setFloat(2, discountVal);
							pstat.setFloat(3, normGSTAmountVal);
							pstat.setFloat(4, calcAmountVal);

							pstat.setInt(5, Integer.parseInt(table.getValueAt(x, 0).toString()));



							int updateVal = pstat.executeUpdate();
							if (updateVal > 0) {
								System.out.println("Value from exUpdate--->" + updateVal);
								//JOptionPane.showMessageDialog(null, "Updated!!");
								flag=true;

							}

						}catch (Exception e)
						{

							e.printStackTrace();

							JOptionPane.showMessageDialog(null, "InDelQtyError!!"+e);

						}

					}

				}


			}

			if(flag==true)
				return flag;


		} catch (Exception e) {

			e.printStackTrace();

			JOptionPane.showMessageDialog(null, "Error !!"+e);
		}
		return flag;
	}



	public boolean deleteFromOrderTable(Connection con, JTable table, String tableName, String inTableName,String colName,String colVal) {




		try {
			PreparedStatement	outpstat = con.prepareStatement("DELETE FROM "+tableName+" WHERE "+colName+"='"+colVal+"'");


			int val=	outpstat.executeUpdate();

			int rowCount= table.getRowCount();

			if(val>0) {
				//inTableName="goods_detail";

				//String inTableName="goods_detail";

				for (int x = 0; x < rowCount; x++) {


					Statement instat = con.createStatement();

					ResultSet inresult = instat.executeQuery("select * from " + inTableName + " where DESCRIPTION_OF_GOODS ='" + table.getValueAt(x, 1).toString() + "'");

					int insertVal = 0;

					if (inresult.next()) {


						int materialQtyVal = 0;
						float calcAmountVal = 0;
						float discountVal = 0;
						float cGSTAmountVal = 0;
						float sGSTAmountVal = 0;


						ResultSetMetaData inrsmd = inresult.getMetaData();

						int columnCount = inrsmd.getColumnCount();


						for (int i = 1; i <= columnCount; i++) {


							if (inrsmd.getColumnName(i).equals("QTY")) {

								materialQtyVal = Integer.parseInt(inresult.getString(i)) + Integer.parseInt(table.getValueAt(x, 3).toString());
							}
							if (inrsmd.getColumnName(i).equals("AMOUNT")) {

								calcAmountVal = Float.valueOf(inresult.getString(i)) + Float.valueOf(table.getValueAt(x, 11).toString());

							}


							/*if (inrsmd.getColumnName(i).equals("DISCOUNT")) {
								discountVal = Float.valueOf(inresult.getString(i));
								Float discount = Float.valueOf(table.getValueAt(x, 6).toString());
								if (discountVal > discount)
									discountVal = discountVal - discount;
								else
									discountVal = discount;


							}*/
							if (inrsmd.getColumnName(i).equals("CGST_AMOUNT")) {

								cGSTAmountVal = Float.valueOf(inresult.getString(i)) + Float.valueOf(table.getValueAt(x, 8).toString());


							}


							if (inrsmd.getColumnName(i).equals("SGST_AMOUNT")) {

								sGSTAmountVal = Float.valueOf(inresult.getString(i)) + Float.valueOf(table.getValueAt(x, 10).toString());


							}


						}


						//JOptionPane.showMessageDialog(null, "Already Exist!!!");


						try {
							PreparedStatement pstat = con.prepareStatement("update " + inTableName + " set QTY = ?, DISCOUNT =?, CGST_AMOUNT= ?, SGST_AMOUNT= ?,  AMOUNT = ?  where DESCRIPTION_OF_GOODS = ?");


							pstat.setInt(1, materialQtyVal);

							pstat.setFloat(2, discountVal);
							pstat.setFloat(3, cGSTAmountVal);
							pstat.setFloat(4, sGSTAmountVal);


							pstat.setFloat(5, calcAmountVal);

							pstat.setString(6, table.getValueAt(x, 1).toString());


							int updateVal = pstat.executeUpdate();
							if (updateVal > 0) {
								System.out.println("Value from exUpdate--->" + insertVal);
								//JOptionPane.showMessageDialog(null, "Updated!!");

								return true;
							}

						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Error : " + e);

						}


					}


				}

			}


		} catch (SQLException e) {
			e.printStackTrace();
		}


		return false;
	}


	public String addPatientTestReportDetails(Connection con, String tableName, String columName, int patientIdOrLabId, JTable table, String patientNameVal, String gender, int age, String phoneNo, String address, String remark, String isChildVal, String testGroup,String doctorName, String method, String testRemarks, String collectDate, String reportDate, String collectTime, String reportTime, int testGroupId, int iflag, String tabNamePDetail, String tabNameTRECDetail) {

		int labId=0;
		try {
			int rowCount = table.getRowCount();


			if(iflag==0) {
				String col_id="LAB_ID";
				labId = genUniLabId(con, tableName,col_id);

				for (int x = 0; x < rowCount; x++) {
					String searchKey = "";
					String entryDate = "";



					if (table.getValueAt(x,11).toString().equals("PosNeg")) {

						String tableNamePsNg="posneg_test_report_detail";

						Statement stat = con.createStatement();
						ResultSet outresult = stat.executeQuery("select * from " + tableNamePsNg);

						ResultSetMetaData rsmd = outresult.getMetaData();

						int columnCount = rsmd.getColumnCount();




						PreparedStatement outpstat = con.prepareStatement("insert into " + tableNamePsNg + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

						//JOptionPane.showMessageDialog(null,"at row "+x+" of total rowCount "+rowCount);
						for (int y = 1; y <= columnCount; y++) {

							String colName = rsmd.getColumnName(y);
							System.out.println("colnames====> " + colName);


							if (colName.equals("ID")) {

								outpstat.setInt(y, Integer.parseInt(table.getValueAt(x, 0).toString()));

								//strVal = strVal+table.getValueAt(selectedRow[i], j)+",";
							}

							if (colName.equals("TEST_GROUP_ID")) {

								outpstat.setInt(y, Integer.parseInt(table.getValueAt(x, 8).toString()));


								//strVal = strVal+table.getValueAt(selectedRow[i], j)+",";
							}


							if (colName.equals("PATIENT_ID")) {

								outpstat.setInt(y, patientIdOrLabId);
							}


							if (colName.equals("PATIENT_NAME")) {

								outpstat.setString(y, patientNameVal);
							}



							if (colName.equals("LAB_ID")) {
//						outpstat.setString(y, table.getValueAt(x, 4).toString());
								outpstat.setInt(y, labId);

							}

							if (colName.equals("TEST_GROUP")) {
								outpstat.setString(y, table.getValueAt(x, 9).toString());

							}

							if (colName.equals("TEST_TYPE")) {
								outpstat.setString(y, table.getValueAt(x,11).toString());

							}

							if (colName.equals("TEST")) {
								outpstat.setString(y, table.getValueAt(x, 1).toString());

							}

							if (colName.equals("DEFAULT_VALUE")) {
								outpstat.setString(y, table.getValueAt(x, 2).toString());

							}

							if (colName.equals("OPTIONS")) {
								outpstat.setString(y, table.getValueAt(x, 4).toString());

							}

							if (colName.equals("RESFLAG")) {
								outpstat.setFloat(y, 0);

							}

							if (colName.equals("COLLECT_DATE")) {
								outpstat.setDate(y, getDate(collectDate));

							}

							if (colName.equals("REPORT_DATE")) {
								outpstat.setDate(y, getDate(reportDate));

							}

							if (colName.equals("COLLECT_TIME")) {
								outpstat.setString(y, collectTime);

							}

							if (colName.equals("REPORT_TIME")) {
								outpstat.setString(y, reportTime);

							}


							if (colName.equals("METHOD")) {
								outpstat.setString(y, "");

							}

							if (colName.equals("TEST_REMARKS")) {
								outpstat.setString(y, "");

							}

							if (colName.equals("SEARCH_KEY")) {
								outpstat.setString(y, "all");

							}


							/*
									if (colName.equals("GENDER")) {

								outpstat.setString(y, gender);
							}

							if (colName.equals("AGE")) {

								outpstat.setInt(y, age);
							}


							if (colName.equals("PHONE_NO")) {

								outpstat.setString(y, phoneNo);
							}

							if (colName.equals("ADDRESS")) {

								outpstat.setString(y, address);
							}
							if (colName.equals("REMARK")) {

								outpstat.setString(y, remark);
							}


							if (colName.equals("CHILD_ADULT")) {
								outpstat.setString(y, isChildVal);
							}

							if (colName.equals("REF_DOCTOR")) {
								outpstat.setString(y, doctorName);
							}

							if (colName.equals("CONDITION")) {
								outpstat.setString(y, "");

							}


							if (colName.equals("NORM_VALUE")) {
								outpstat.setString(y, table.getValueAt(x, 5).toString());
							}


							if (colName.equals("UNITS")) {
								outpstat.setString(y, table.getValueAt(x, 3).toString());
							}


							 */

						}

						int val = outpstat.executeUpdate();

						if (val > 0) {

							System.out.println("Inserted");
							//JOptionPane.showMessageDialog(null, "Done");

						}


					}
					else
					{
						Statement stat = con.createStatement();
						ResultSet outresult = stat.executeQuery("select * from " + tableName);

						ResultSetMetaData rsmd = outresult.getMetaData();

						int columnCount = rsmd.getColumnCount();



						PreparedStatement outpstat = con.prepareStatement("insert into " + tableName + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

						//JOptionPane.showMessageDialog(null,"at row "+x+" of total rowCount "+rowCount);
						for (int y = 1; y <= columnCount; y++) {

							String colName = rsmd.getColumnName(y);
							System.out.println("colnames====> " + colName);


							if (colName.equals("ID")) {

								outpstat.setInt(y, Integer.parseInt(table.getValueAt(x, 0).toString()));

								//strVal = strVal+table.getValueAt(selectedRow[i], j)+",";
							}

							if (colName.equals("TEST_GROUP_ID")) {

								outpstat.setInt(y, Integer.parseInt(table.getValueAt(x, 8).toString()));


								//strVal = strVal+table.getValueAt(selectedRow[i], j)+",";
							}


							if (colName.equals("PATIENT_ID")) {

								outpstat.setInt(y, patientIdOrLabId);
							}


							if (colName.equals("PATIENT_NAME")) {

								outpstat.setString(y, patientNameVal);
							}

							if (colName.equals("GENDER")) {

								outpstat.setString(y, gender);
							}

							if (colName.equals("AGE")) {

								outpstat.setInt(y, age);
							}


							if (colName.equals("PHONE_NO")) {

								outpstat.setString(y, phoneNo);
							}

							if (colName.equals("ADDRESS")) {

								outpstat.setString(y, address);
							}
							if (colName.equals("REMARK")) {

								outpstat.setString(y, remark);
							}


							if (colName.equals("CHILD_ADULT")) {
								outpstat.setString(y, isChildVal);
							}

							if (colName.equals("REF_DOCTOR")) {
								outpstat.setString(y, doctorName);
							}

							if (colName.equals("LAB_ID")) {
//						outpstat.setString(y, table.getValueAt(x, 4).toString());
								outpstat.setInt(y, labId);

							}

							if (colName.equals("TEST_GROUP")) {
								outpstat.setString(y, table.getValueAt(x, 9).toString());

							}

							if (colName.equals("TEST_TYPE")) {
								outpstat.setString(y, table.getValueAt(x,11).toString());

							}

							if (colName.equals("TEST")) {
								outpstat.setString(y, table.getValueAt(x, 1).toString());

							}
							if (colName.equals("RESULT")) {
								outpstat.setFloat(y, 0);

							}

							if (colName.equals("RESFLAG")) {
								outpstat.setFloat(y, 0);

							}
							if (colName.equals("CONDITION")) {
								outpstat.setString(y, "");

							}


							if (colName.equals("NORM_VALUE")) {
								outpstat.setString(y, table.getValueAt(x, 5).toString());
							}


							if (colName.equals("UNITS")) {
								outpstat.setString(y, table.getValueAt(x, 3).toString());
							}


							if (colName.equals("COLLECT_DATE")) {
								outpstat.setDate(y, getDate(collectDate));

							}

							if (colName.equals("REPORT_DATE")) {
								outpstat.setDate(y, getDate(reportDate));

							}

							if (colName.equals("COLLECT_TIME")) {
								outpstat.setString(y, collectTime);

							}

							if (colName.equals("REPORT_TIME")) {
								outpstat.setString(y, reportTime);

							}


							if (colName.equals("METHOD")) {
								outpstat.setString(y, "");

							}

							if (colName.equals("TEST_REMARKS")) {
								outpstat.setString(y, "");

							}

							if (colName.equals("SEARCH_KEY")) {
								outpstat.setString(y, "all");

							}


						}

						int val = outpstat.executeUpdate();

						if (val > 0) {

							System.out.println("Inserted");
							//JOptionPane.showMessageDialog(null, "Done");

						}


					}





				}

			}// iflag 1
			else
			{
				int uniQLabId =0;
				boolean flag=true;


				try {

					float lowRange = 0;
					float highRange = 0;
					float resultValue = 0;
					String condition = "";
					String defaultVal = "";
					String option = "";

					Statement stat = con.createStatement();
					ResultSet outresult = stat.executeQuery("select * from " + tableName);

					ResultSetMetaData rsmd = outresult.getMetaData();

					int columnCount = rsmd.getColumnCount();




					for (int x = 0; x < rowCount; x++) {




						if (table.getValueAt(x,6).toString().equals("PosNeg")) {


								for (int y = 1; y <= columnCount; y++) {

									String colName = rsmd.getColumnName(y);
									System.out.println("colnames====> " + colName);


									if (colName.equals("DEFAULT_VALUE")) {

										//String formattedString = String.format("%.02f", myFloat);
										defaultVal = table.getValueAt(x, 4).toString();

									}
									else if (colName.equals("OPTIONS")) {

										//String formattedString = String.format("%.02f", myFloat);
										option = table.getValueAt(x, 5).toString();

									}

								/*	qry = "select ID, LAB_ID ,TEST_GROUP,TEST,DEFAULT_VALUE,OPTIONS ,TEST_TYPE,COLLECT_DATE , COLLECT_TIME ,REPORT_DATE ,REPORT_TIME" +
											",TEST_GROUP_ID, PATIENT_ID,PATIENT_NAME ,METHOD , TEST_REMARKS, RESFLAG,SEARCH_KEY from " + tabName + " where " + colName + " = " + colVal + " AND RESFLAG = 0 order by test_group_id";
*/

								}

								if (flag == false) {
									JOptionPane.showMessageDialog(null, "Error with ID " + table.getValueAt(x, 0).toString());


								} else {
									PreparedStatement pstat = con.prepareStatement("update " + tableName + " set DEFAULT_VALUE = ?,OPTIONS = ?, REPORT_DATE =?, REPORT_TIME =?, METHOD =?, TEST_REMARKS =?,RESFLAG =? where " + columName + " = ? AND ID = ?");


									pstat.setString(1, defaultVal);
									pstat.setString(2, option);
									pstat.setDate(3, getDate(reportDate));
									pstat.setString(4, reportTime);
									pstat.setString(5, method);
									pstat.setString(6, testRemarks);

									uniQLabId = Integer.parseInt(table.getValueAt(x, 1).toString());

									pstat.setInt(7, 1);

									pstat.setInt(8, uniQLabId);

									pstat.setInt(9, Integer.parseInt(table.getValueAt(x, 0).toString()));

									int val = pstat.executeUpdate();

									if (val > 0) {

										System.out.println("Inserted");

									}
								}



						}
						else
						{
							for (int y = 1; y <= columnCount; y++) {

								String colName = rsmd.getColumnName(y);
								System.out.println("colnames====> " + colName);


								if (colName.equals("RESULT")) {

									//String formattedString = String.format("%.02f", myFloat);
									resultValue = Float.parseFloat(table.getValueAt(x, 4).toString());

								}
								if (colName.equals("NORM_VALUE")) {
									String normValue = table.getValueAt(x, 7).toString();

									if (normValue.contains("-")) {

										String[] normValArr = normValue.split("-");

										lowRange = Float.parseFloat(normValArr[0]);

										highRange = Float.parseFloat(normValArr[1]);


										if (resultValue < lowRange || resultValue > highRange) {

											condition = "ABNORMAL";

										} else if (resultValue >= lowRange && resultValue <= highRange) {

											condition = "NORMAL";

										} else {

											flag = false;


										}


									} else {
										flag = false;
									}


								}


							}

							if (flag == false) {
								JOptionPane.showMessageDialog(null, "Error with ID " + table.getValueAt(x, 0).toString());


							} else {
								PreparedStatement pstat = con.prepareStatement("update " + tableName + " set RESULT = ?, CONDITION =? ,REPORT_DATE =?, REPORT_TIME =?, METHOD =?, TEST_REMARKS =?,RESFLAG =? where " + columName + " = ? AND ID = ?");


								pstat.setFloat(1, resultValue);


								pstat.setString(2, condition);

								pstat.setDate(3, getDate(reportDate));

								pstat.setString(4, reportTime);

								pstat.setString(5, method);
								pstat.setString(6, testRemarks);

								uniQLabId = Integer.parseInt(table.getValueAt(x, 1).toString());

								pstat.setInt(7, 1);

								pstat.setInt(8, uniQLabId);

								pstat.setInt(9, Integer.parseInt(table.getValueAt(x, 0).toString()));

								int val = pstat.executeUpdate();

								if (val > 0) {

									System.out.println("Inserted");

								}
							}
						}
				    }

				}catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, "Error : "+e);

				}

				String entryDate = getDateVal(tableName);

				if(flag==false)
				{
					JOptionPane.showMessageDialog(null, "Invalid Range or Value!!!");

					//JOptionPane.showMessageDialog(null, "EntryDate : "+entryDate);

					uniQLabId =0;
					return uniQLabId+","+entryDate;

				}
				else
				{


					int patientId =Integer.parseInt(table.getValueAt(0, 12).toString());

					PreparedStatement pstat = con.prepareStatement("update " + tabNamePDetail + " set entry_date = ?, test_report =?  where ID = ?");


					pstat.setString(1, entryDate);


					pstat.setString(2, testRemarks);

					pstat.setInt(3, patientId);


					int val = pstat.executeUpdate();

					if (val > 0) {

						System.out.println("Inserted");


					}



					JOptionPane.showMessageDialog(null, "EntryDate : "+entryDate);
					return uniQLabId+","+entryDate;

				}


			}
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null,"PTREPORT Error : "+e,"Error Message",1);

		}


			return labId+","+"entryDate";
	}


	public String insertInToOrderTable(Connection con, JTable table, String quotationId, String quotationName, String supplierName, String partyName, String transportName,String tableName, String inTableName, String[] gstFlagsVal) {

		/*String ordDetailColNames[]={"ID","DESCRIPTION_OF_GOODS","HSN_SAC_CODE","QTY","UNIT","PRICE","DISCOUNT","CGST_RATE",
				"CGST_AMOUNT","SGST_RATE","SGST_AMOUNT","IGST_RATE","IGST_AMOUNT","NORM_GST_RATE","NORM_GST_AMOUNT",
				"AMOUNT","SEARCH_KEY","ENTRY_DATE","ORDER_ID","PARTY_NAME","QUOTATION_NAME","QUOTATION_ID"};
		*/
		String	ordIdEntryDateSearchKey ="";
		int rowCount = table.getRowCount();

		//tableName = "order_detail";
		String ordId="";
		try {
		Statement	stat = con.createStatement();
		ResultSet	outresult = stat.executeQuery("select * from " + tableName);

		ResultSetMetaData rsmd = outresult.getMetaData();

		int	columnCount = rsmd.getColumnCount();

			tableName = rsmd.getTableName(columnCount);

			String strOrderId = JOptionPane.showInputDialog(null, "Enter Number", "Order Detail", 1);


			boolean numFlag= isValid(strOrderId);

			if(strOrderId!=null && strOrderId.length()>0)
			{


				if(numFlag==true) {


					ordId = genLGAStaffUniId(con, tableName, strOrderId);

					if(ordId.equals("NoOrd"))
					{
						return "NoOrd" ;

					}

				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Number, Order Not Generated!!!", "Order", 1);


					return "NoOrd" ;
				}


			}
			else
			{
				JOptionPane.showMessageDialog(null, "Process end by user Order Not Generated!!!", "Order", 1);


				return "NoOrd" ;

			}
			/*else {

				int yesNoVal = JOptionPane.showConfirmDialog(null,
						"Do you want to generate Auto Order?",null, JOptionPane.YEID_OPTION);
				if(yesNoVal == JOptionPane.YES_OPTION) {
					ordId = genLGAStaffUniId(con, tableName,"");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Process end by user Order Not Generated!!!", "Simple Order", 1);


					return "NoOrd" ;

				}

			}*/

			for (int x = 0; x < rowCount; x++) {
				if (gstFlagsVal[0].equals("stategst")) {

					float igstRate= Float.valueOf(table.getValueAt(x, 7).toString());
					float igstAmt= Float.valueOf(table.getValueAt(x, 8).toString());
					float amount= Float.valueOf(table.getValueAt(x, 9).toString());
					String searchKeyVal= table.getValueAt(x, 10).toString();

				ordIdEntryDateSearchKey =	setOrderDetailAndGoodsDetail(con, table, rowCount, rsmd, columnCount, tableName, ordId, partyName, quotationName, supplierName,transportName ,inTableName,0,0,0,0,igstRate,igstAmt,0,0,amount,searchKeyVal,x);

				} else if (gstFlagsVal[0].equals("localgst")) {

					float cgstRate= Float.valueOf(table.getValueAt(x, 7).toString());
					float cgstAmt= Float.valueOf(table.getValueAt(x, 8).toString());
					float sgstRate= Float.valueOf(table.getValueAt(x, 9).toString());
					float sgstAmt= Float.valueOf(table.getValueAt(x, 10).toString());

					float amount= Float.valueOf(table.getValueAt(x, 11).toString());
					String searchKeyVal= table.getValueAt(x, 12).toString();

					ordIdEntryDateSearchKey =	setOrderDetailAndGoodsDetail(con, table, rowCount, rsmd, columnCount, tableName, ordId, partyName, quotationName, supplierName,transportName , inTableName,cgstRate,cgstAmt,sgstRate,sgstAmt,0,0,0,0,amount,searchKeyVal, x);


				} else if (gstFlagsVal[0].equals("normalgst")) {
					float normGstRate= Float.valueOf(table.getValueAt(x, 7).toString());
					float normGstAmt= Float.valueOf(table.getValueAt(x, 8).toString());
					float amount= Float.valueOf(table.getValueAt(x, 9).toString());
					String searchKeyVal= table.getValueAt(x, 10).toString();

					ordIdEntryDateSearchKey =	setOrderDetailAndGoodsDetail(con, table, rowCount, rsmd, columnCount, tableName, ordId, partyName, quotationName, supplierName,transportName ,inTableName,0,0,0,0,0,0,normGstRate,normGstAmt,amount,searchKeyVal, x);

				}

			}


		}
		catch (Exception e)
		{

			e.printStackTrace();
		}

	     if(ordIdEntryDateSearchKey.contains(","))
		  return ordIdEntryDateSearchKey;
		 else
	      return "";
	}

	private String setOrderDetailAndGoodsDetail(Connection con, JTable table, int rowCount, ResultSetMetaData rsmd, int columnCount, String tableName, String ordId, String partyName, String quotationName, String supplierName, String transportName , String inTableName, float cgstRate, float cgstAmt, float sgstRate, float sgstAmt, float igstRate, float igstAmt, float normGstRate, float normGstAmt, float amount, String searchKeyVal, int x) throws SQLException {
		String searchKey="";
		String entryDate="";


			PreparedStatement	outpstat = con.prepareStatement("insert into " + tableName + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			//JOptionPane.showMessageDialog(null,"at row "+x+" of total rowCount "+rowCount);
			for (int y = 1; y <= columnCount; y++) {

				String colName = rsmd.getColumnName(y);
				System.out.println("colnames====> " +colName);


				if (colName.equals("ID")) {

					outpstat.setInt(y,Integer.parseInt(table.getValueAt(x,0).toString()));

					//strVal = strVal+table.getValueAt(selectedRow[i], j)+",";
				}

				if (colName.equals("DESCRIPTION_OF_GOODS")) {

					outpstat.setString(y,table.getValueAt(x,1).toString());
				}
				if (colName.equals("HSN_SAC_CODE")) {

					outpstat.setString(y,table.getValueAt(x,2).toString());
				}

				if (colName.equals("QTY")) {
					outpstat.setInt(y,Integer.parseInt(table.getValueAt(x,3).toString()));
				}
				if (colName.equals("UNIT")) {
					outpstat.setString(y,table.getValueAt(x,4).toString());
				}

				if (colName.equals("PRICE")) {
					outpstat.setFloat(y,Float.valueOf(table.getValueAt(x,5).toString()));

				}
				if (colName.equals("DISCOUNT")) {
					outpstat.setFloat(y,Float.valueOf(table.getValueAt(x,6).toString()));
				}


				if (colName.equals("CGST_RATE")) {
					outpstat.setFloat(y,cgstRate);
				}
				if (colName.equals("CGST_AMOUNT")) {
					outpstat.setFloat(y,cgstAmt);

				}

				if (colName.equals("SGST_RATE")) {
					outpstat.setFloat(y,sgstRate);

				}

				if (colName.equals("SGST_AMOUNT")) {
					outpstat.setFloat(y,sgstAmt);

				}

				if (colName.equals("IGST_RATE")) {
					outpstat.setFloat(y,igstRate);

				}

				if (colName.equals("IGST_AMOUNT")) {
					outpstat.setFloat(y,igstAmt);

				}
				if (colName.equals("NORM_GST_RATE")) {
					outpstat.setFloat(y, normGstRate);
				}

				if (colName.equals("NORM_GST_AMOUNT")) {

					outpstat.setFloat(y, normGstAmt);

				}
				if (colName.equals("AMOUNT")) {
					outpstat.setFloat(y,amount);
				}

				if (colName.equals("SEARCH_KEY")) {

					searchKey = searchKeyVal;
					outpstat.setString(y,searchKey);

				}

				if (colName.equals("ENTRY_DATE")) {

					entryDate = getDateVal(tableName);
					outpstat.setString(y, entryDate);

				}
				if (colName.equals("ORDER_ID")) {

					outpstat.setString(y,ordId);

				}
				if (colName.equals("PARTY_NAME")) {

					outpstat.setString(y,partyName);

				}
				if (colName.equals("QUOTATION_NAME")) {

					outpstat.setString(y,quotationName);

				}
				if (colName.equals("TRANSPORT_NAME")) {

					outpstat.setString(y,transportName);

				}
				if (colName.equals("SUPPLIER_NAME")) {

					outpstat.setString(y,supplierName);

				}


			}

			int val=	outpstat.executeUpdate();

			if(val>0)
			{
				//inTableName="goods_detail";

				//String inTableName="goods_detail";

				System.out.println("Inserted");
				//JOptionPane.showMessageDialog(null,"Inserted");

				Statement instat = con.createStatement();

				ResultSet inresult = instat.executeQuery("select * from " + inTableName +" where ID ="+Integer.parseInt(table.getValueAt(x,0).toString())+"");

				int insertVal=0;

				if(inresult.next())
				{






					int materialQtyVal=0;
					float calcAmountVal =0;
					float discountVal = 0;
					float cGSTAmountVal= 0;
					float sGSTAmountVal= 0;
					float iGSTAmountVal= 0;
					float normGSTAmountVal= 0;

					ResultSetMetaData inrsmd = inresult.getMetaData();

					int colCount = inrsmd.getColumnCount();



					for (int i = 1; i <= colCount; i++) {


						if (inrsmd.getColumnName(i).equals("QTY")) {

							materialQtyVal= Integer.parseInt(inresult.getString(i))-Integer.parseInt(table.getValueAt(x,3).toString());
						}
						if (inrsmd.getColumnName(i).equals("AMOUNT")) {

							calcAmountVal = Float.valueOf(inresult.getString(i)) - amount ;

						}




						if (inrsmd.getColumnName(i).equals("DISCOUNT")) {
							discountVal = Float.valueOf(inresult.getString(i));
							Float discount= Float.valueOf(table.getValueAt(x,6).toString());
							if(discountVal>discount)
								discountVal = discountVal - discount ;
							else
								discountVal=discount;



						}
						if (inrsmd.getColumnName(i).equals("CGST_AMOUNT")) {

							cGSTAmountVal = Float.valueOf(inresult.getString(i)) - cgstAmt ;



						}


						if (inrsmd.getColumnName(i).equals("SGST_AMOUNT")) {

							sGSTAmountVal = Float.valueOf(inresult.getString(i)) - sgstAmt ;



						}


						if (inrsmd.getColumnName(i).equals("IGST_AMOUNT")) {

							iGSTAmountVal = Float.valueOf(inresult.getString(i)) - igstAmt ;



						}


						if (inrsmd.getColumnName(i).equals("NORM_GST_AMOUNT")) {

							normGSTAmountVal = Float.valueOf(inresult.getString(i)) - normGstAmt ;



						}






					}




					//JOptionPane.showMessageDialog(null, "Already Exist!!!");



					try {
						PreparedStatement pstat = con.prepareStatement("update " + inTableName + " set QTY = ?, DISCOUNT =?, CGST_AMOUNT= ?, SGST_AMOUNT= ?, IGST_AMOUNT= ?,NORM_GST_AMOUNT =?, AMOUNT = ?  where ID = ?");


						pstat.setInt(1, materialQtyVal);
						pstat.setFloat(2, discountVal);
						pstat.setFloat(3, cGSTAmountVal);
						pstat.setFloat(4, sGSTAmountVal);
						pstat.setFloat(5, iGSTAmountVal);
						pstat.setFloat(6, normGSTAmountVal);
						pstat.setFloat(7, calcAmountVal);
						pstat.setInt(8, Integer.parseInt(table.getValueAt(x, 0).toString()));



						int updateVal = pstat.executeUpdate();
						if (updateVal > 0) {
							System.out.println("Value from exUpdate--->" + insertVal);
							//JOptionPane.showMessageDialog(null, "Updated!!");

							if((rowCount-1)==x)
							{


								return ordId+","+entryDate+","+searchKey;

							}


						}

					}catch (Exception e)
					{
						JOptionPane.showMessageDialog(null, "Error : "+e);

					}






				}


			}


		return "";
	}


	private String setReceiptDetail(Connection con, JTable table, int rowCount, ResultSetMetaData rsmd, int columnCount, String tableName, String ordId, String partyName, String quotationName, String supplierName, String inTableName, float cgstRate, float cgstAmt, float sgstRate, float sgstAmt, float igstRate, float igstAmt, float normGstRate, float normGstAmt, float amount, String searchKeyVal, int x, String chequeId, String receivedAmount, String totalQty, String totalPrice, String remainQty, String remainPrice) throws SQLException {
		String searchKey="";
		String entryDate="";
		boolean flag = false;
		PreparedStatement	outpstat = con.prepareStatement("insert into " + tableName + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");


		//JOptionPane.showMessageDialog(null,"at row "+x+" of total rowCount "+rowCount);
		for (int y = 1; y <= columnCount; y++) {

			String colName = rsmd.getColumnName(y);
			System.out.println("colnames====> " +colName);


			if (colName.equals("ID")) {

				outpstat.setInt(y,Integer.parseInt(table.getValueAt(x,0).toString()));

				//strVal = strVal+table.getValueAt(selectedRow[i], j)+",";
			}

			if (colName.equals("DESCRIPTION_OF_GOODS")) {

				outpstat.setString(y,table.getValueAt(x,1).toString());
			}
			if (colName.equals("HSN_SAC_CODE")) {

				outpstat.setString(y,table.getValueAt(x,2).toString());
			}

			if (colName.equals("QTY")) {
				outpstat.setInt(y,Integer.parseInt(table.getValueAt(x,3).toString()));
			}
			if (colName.equals("UNIT")) {
				outpstat.setString(y,table.getValueAt(x,4).toString());
			}

			if (colName.equals("PRICE")) {
				outpstat.setFloat(y,Float.valueOf(table.getValueAt(x,5).toString()));

			}
			if (colName.equals("DISCOUNT")) {
				outpstat.setFloat(y,Float.valueOf(table.getValueAt(x,6).toString()));
			}


			if (colName.equals("CGST_RATE")) {
				outpstat.setFloat(y,cgstRate);
			}
			if (colName.equals("CGST_AMOUNT")) {
				outpstat.setFloat(y,cgstAmt);

			}

			if (colName.equals("SGST_RATE")) {
				outpstat.setFloat(y,sgstRate);

			}

			if (colName.equals("SGST_AMOUNT")) {
				outpstat.setFloat(y,sgstAmt);

			}

			if (colName.equals("IGST_RATE")) {
				outpstat.setFloat(y,igstRate);

			}

			if (colName.equals("IGST_AMOUNT")) {
				outpstat.setFloat(y,igstAmt);

			}
			if (colName.equals("NORM_GST_RATE")) {
				outpstat.setFloat(y, normGstRate);
			}

			if (colName.equals("NORM_GST_AMOUNT")) {

				outpstat.setFloat(y, normGstAmt);

			}
			if (colName.equals("AMOUNT")) {
				outpstat.setFloat(y,amount);
			}

			if (colName.equals("SEARCH_KEY")) {

				searchKey = searchKeyVal;
				outpstat.setString(y,searchKey);

			}

			if (colName.equals("ENTRY_DATE")) {

				entryDate = getDateVal(tableName);
				outpstat.setString(y, entryDate);

			}
			if (colName.equals("ORDER_ID")) {

				outpstat.setString(y,ordId);

			}
			if (colName.equals("PARTY_NAME")) {

				outpstat.setString(y,partyName);

			}
			if (colName.equals("QUOTATION_NAME")) {

				outpstat.setString(y,quotationName);

			}

			if (colName.equals("SUPPLIER_NAME")) {

				outpstat.setString(y,supplierName);

			}





			if (colName.equals("CHEQUE_OR_CASH")) {

				outpstat.setString(y,chequeId);

			}


			if (colName.equals("RECEIVED_AMOUNT")) {

				outpstat.setFloat(y, Float.parseFloat(receivedAmount));

			}

			if (colName.equals("TOTAL_QTY")) {

				outpstat.setFloat(y, Float.parseFloat(totalQty));

			}
			if (colName.equals("TOTAL_AMOUNT")) {

				outpstat.setFloat(y, Float.parseFloat(totalPrice));

			}
			if (colName.equals("BALANCE_QTY")) {

				outpstat.setFloat(y, Float.parseFloat(remainQty));

			}
			if (colName.equals("BALANCE_AMOUNT")) {

				outpstat.setFloat(y, Float.parseFloat(remainPrice));

			}



		}

		int val=	outpstat.executeUpdate();

		if(val>0)
		{
			System.out.println("value from executeUpdate "+val);

			if((rowCount-1)==x)
			{
				flag = true;

				return ordId+","+entryDate+","+searchKey;

			}


		}
		/*{
			//inTableName="goods_detail";

			//String inTableName="goods_detail";

			System.out.println("Inserted");
			//JOptionPane.showMessageDialog(null,"Inserted");

			Statement instat = con.createStatement();

			ResultSet inresult = instat.executeQuery("select * from " + inTableName +" where DESCRIPTION_OF_GOODS ='"+table.getValueAt(x,0).toString()+"'");

			int insertVal=0;

			if(inresult.next())
			{






				int materialQtyVal=0;
				float calcAmountVal =0;
				float discountVal = 0;
				float cGSTAmountVal= 0;
				float sGSTAmountVal= 0;
				float iGSTAmountVal= 0;
				float normGSTAmountVal= 0;

				ResultSetMetaData inrsmd = inresult.getMetaData();

				int colCount = inrsmd.getColumnCount();



				for (int i = 1; i <= colCount; i++) {


					if (inrsmd.getColumnName(i).equals("QTY")) {

						materialQtyVal= Integer.parseInt(inresult.getString(i))-Integer.parseInt(table.getValueAt(x,3).toString());
					}
					if (inrsmd.getColumnName(i).equals("AMOUNT")) {

						calcAmountVal = Float.valueOf(inresult.getString(i)) - amount ;

					}




					if (inrsmd.getColumnName(i).equals("DISCOUNT")) {
						discountVal = Float.valueOf(inresult.getString(i));
						Float discount= Float.valueOf(table.getValueAt(x,6).toString());
						if(discountVal>discount)
							discountVal = discountVal - discount ;
						else
							discountVal=discount;



					}
					if (inrsmd.getColumnName(i).equals("CGST_AMOUNT")) {

						cGSTAmountVal = Float.valueOf(inresult.getString(i)) - cgstAmt ;



					}


					if (inrsmd.getColumnName(i).equals("SGST_AMOUNT")) {

						sGSTAmountVal = Float.valueOf(inresult.getString(i)) - sgstAmt ;



					}


					if (inrsmd.getColumnName(i).equals("IGST_AMOUNT")) {

						iGSTAmountVal = Float.valueOf(inresult.getString(i)) - igstAmt ;



					}


					if (inrsmd.getColumnName(i).equals("NORM_GST_AMOUNT")) {

						normGSTAmountVal = Float.valueOf(inresult.getString(i)) - normGstAmt ;



					}






				}




				//JOptionPane.showMessageDialog(null, "Already Exist!!!");



				try {
					PreparedStatement pstat = con.prepareStatement("update " + inTableName + " set QTY = ?, DISCOUNT =?, CGST_AMOUNT= ?, SGST_AMOUNT= ?, IGST_AMOUNT= ?,NORM_GST_AMOUNT =?, AMOUNT = ?  where DESCRIPTION_OF_GOODS = ?");


					pstat.setInt(1, materialQtyVal);
					pstat.setFloat(2, discountVal);
					pstat.setFloat(3, cGSTAmountVal);
					pstat.setFloat(4, sGSTAmountVal);
					pstat.setFloat(5, iGSTAmountVal);
					pstat.setFloat(6, normGSTAmountVal);
					pstat.setFloat(7, calcAmountVal);
					pstat.setString(8, table.getValueAt(x, 0).toString());



					int updateVal = pstat.executeUpdate();
					if (updateVal > 0) {
						System.out.println("Value from exUpdate--->" + insertVal);
						//JOptionPane.showMessageDialog(null, "Updated!!");

					}

				}catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, "Error : "+e);

				}






			}


		}*/


		return "";
	}


	public String insertInToSimpleOrderTable(Connection con, JTable table,String quotationId, String quotationName, String supplierAddress, String partyName) {

		int rowCount = table.getRowCount();

		String tableName = "simple_order_detail";
		String ordId="";
		try {
		Statement	stat = con.createStatement();
		ResultSet	result = stat.executeQuery("select * from " + tableName);

		ResultSetMetaData	rsmd = result.getMetaData();

		int	columnCount = rsmd.getColumnCount();

			tableName = rsmd.getTableName(columnCount);


			/*String name;
			System.out.println("Enter name:");
			name = keyboard.nextLine();
			if (!name.matches("[a-zA-Z_]+")) {
				System.out.println("Invalid name");
			}
			String number;
			System.out.println("Enter number:");
			number = keyboard.nextLine();
			if (!number.matches("[0-9]+")) {
				System.out.println("Invalid number");
			}
			*/

			String strSimpleOrderId = JOptionPane.showInputDialog(null, "Enter Number", "Simple Order", 1);


			boolean numFlag= isValid(strSimpleOrderId);

			if(strSimpleOrderId!=null && strSimpleOrderId.length()>0)
			{


				if(numFlag==true) {
					ordId = genSimpleOrderUniId(con, tableName, strSimpleOrderId);

				      if(ordId.equals("NoOrd"))
					  {
						  return "NoOrd" ;

					  }

				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Number, Order Not Generated!!!", "Simple Order", 1);


					return "NoOrd" ;
				}


			}
			else {

				int yesNoVal = JOptionPane.showConfirmDialog(null,
						"Do you want to generate Auto Order?",null, JOptionPane.YES_NO_OPTION);
				if(yesNoVal == JOptionPane.YES_OPTION) {
					ordId = genSimpleOrderUniId(con, tableName,"");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Process end by user Order Not Generated!!!", "Simple Order", 1);


					return "NoOrd" ;

				}

			}
			for (int x = 0; x < rowCount; x++) {

			PreparedStatement	pstat = con.prepareStatement("insert into " + tableName + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

				//JOptionPane.showMessageDialog(null,"at row "+x+" of total rowCount "+rowCount);
				for (int y = 1; y <= columnCount; y++) {

					String colName = rsmd.getColumnName(y);
					System.out.println("colnames====> " +colName);


					if (colName.equals("ID")) {

						pstat.setInt(y,Integer.parseInt(table.getValueAt(x,0).toString()));

						//strVal = strVal+table.getValueAt(selectedRow[i], j)+",";
					}

					if (colName.equals("DESCRIPTION_OF_GOODS")) {

						pstat.setString(y,table.getValueAt(x,1).toString());
					}
					if (colName.equals("HSN_SAC_CODE")) {

						pstat.setString(y,table.getValueAt(x,2).toString());
					}

					if (colName.equals("QTY")) {
						pstat.setInt(y,Integer.parseInt(table.getValueAt(x,3).toString()));
					}
					if (colName.equals("UNIT")) {
						pstat.setString(y,table.getValueAt(x,4).toString());
					}

					if (colName.equals("PRICE")) {
						pstat.setFloat(y,Float.valueOf(table.getValueAt(x,5).toString()));

					}

					if (colName.equals("DISCOUNT")) {
						pstat.setFloat(y,Float.valueOf(table.getValueAt(x,6).toString()));
					}


					if (colName.equals("CGST_RATE")) {
						pstat.setInt(y,Integer.parseInt(table.getValueAt(x,7).toString()));
					}
					if (colName.equals("CGST_AMOUNT")) {
						pstat.setFloat(y,Float.valueOf(table.getValueAt(x,8).toString()));

					}

					if (colName.equals("SGST_RATE")) {
						pstat.setInt(y,Integer.parseInt(table.getValueAt(x,9).toString()));

					}

					if (colName.equals("SGST_AMOUNT")) {
						pstat.setFloat(y,Float.valueOf(table.getValueAt(x,10).toString()));

					}
					if (colName.equals("AMOUNT")) {
						pstat.setFloat(y,Float.valueOf(table.getValueAt(x,11).toString()));
					}

					if (colName.equals("ENTRY_DATE")) {

						entryDate = getDateVal(tableName);
						pstat.setString(y, entryDate);

					}
					if (colName.equals("ORDER_ID")) {

						pstat.setString(y,ordId);

					}
					if (colName.equals("PARTY_NAME")) {

						pstat.setString(y,partyName);

					}
					if (colName.equals("QUOTATION_NAME")) {

						pstat.setString(y,quotationName);

					}
					if (colName.equals("QUOTATION_ID")) {

						pstat.setString(y,quotationId);

					}

				}

				int val=	pstat.executeUpdate();

				if(val>0)
				{
					String inTableName="simple_goods_detail";

					System.out.println("Inserted");
					//JOptionPane.showMessageDialog(null,"Inserted");

					Statement statIn = con.createStatement();

					ResultSet resultIn = statIn.executeQuery("select * from " + inTableName +" where DESCRIPTION_OF_GOODS ='"+table.getValueAt(x,1).toString()+"'");

					int insertVal=0;

					if(resultIn.next())
					{






						int materialQtyVal=0;
						float calcAmountVal =0;
						float discountVal = 0;
						float cGSTAmountVal= 0;
						float sGSTAmountVal= 0;


						ResultSetMetaData rsmdIn = resultIn.getMetaData();

						int columnCountIn = rsmdIn.getColumnCount();



						for (int i = 1; i <= columnCountIn; i++) {


							if (rsmdIn.getColumnName(i).equals("QTY")) {

								materialQtyVal= Integer.parseInt(resultIn.getString(i))-Integer.parseInt(table.getValueAt(x,3).toString());
							}
							if (rsmdIn.getColumnName(i).equals("AMOUNT")) {

								calcAmountVal = Float.valueOf(resultIn.getString(i)) - Float.valueOf(table.getValueAt(x,11).toString()) ;

							}




							if (rsmdIn.getColumnName(i).equals("DISCOUNT")) {
								discountVal = Float.valueOf(resultIn.getString(i));
								Float discount= Float.valueOf(table.getValueAt(x,6).toString());
								if(discountVal>discount)
									discountVal = discountVal - discount ;
								else
									discountVal=discount;



							}
							if (rsmdIn.getColumnName(i).equals("CGST_AMOUNT")) {

								cGSTAmountVal = Float.valueOf(resultIn.getString(i)) - Float.valueOf(table.getValueAt(x,8).toString()) ;



							}


							if (rsmdIn.getColumnName(i).equals("SGST_AMOUNT")) {

								sGSTAmountVal = Float.valueOf(resultIn.getString(i)) - Float.valueOf(table.getValueAt(x,10).toString()) ;



							}










						}




						//JOptionPane.showMessageDialog(null, "Already Exist!!!");



						try {
							PreparedStatement pstatIn = con.prepareStatement("update " + inTableName + " set QTY = ?, DISCOUNT =?, CGST_AMOUNT= ?, SGST_AMOUNT= ?,  AMOUNT = ?  where DESCRIPTION_OF_GOODS = ?");


							pstatIn.setInt(1, materialQtyVal);

							pstatIn.setFloat(2, discountVal);
							pstatIn.setFloat(3, cGSTAmountVal);
							pstatIn.setFloat(4, sGSTAmountVal);


							pstatIn.setFloat(5, calcAmountVal);

							pstatIn.setString(6, table.getValueAt(x, 1).toString());



							int updateVal = pstatIn.executeUpdate();
							if (updateVal > 0) {
								System.out.println("Value from exUpdate--->" + insertVal);
								//JOptionPane.showMessageDialog(null, "Updated!!");

							}

						}catch (Exception e)
						{
							JOptionPane.showMessageDialog(null, "Error : "+e);

						}






					}


				}
			}

		}
		catch (Exception e)
		{

			e.printStackTrace();
		}
		return ordId+","+entryDate;
	}

	private boolean isValid(String number) {
		if (number.matches("[0-9]+")) {
			return true;
		}

	return false;
	}

	public void addGstFlag(Connection con,int uniQID,String gstType, float gstRate, String tableName)
	{



		try {
		Statement	stat = con.createStatement();
		ResultSet	result = stat.executeQuery("select * from " + tableName);

		ResultSetMetaData	rsmd = result.getMetaData();

		int	columnCount = rsmd.getColumnCount();





		PreparedStatement	pstat = con.prepareStatement("insert into " + tableName + " values(?,?,?)");

			for (int i = 1; i <= columnCount; i++) {

//					System.out.println("colnames====> " + rsmd.getColumnName(i));

				if (rsmd.getColumnName(i).equals("ID")) {
					//int uniQID = genUniId(con, tableName);
					pstat.setInt(i, uniQID);
					System.out.println("From addVahicalValues  ID setting values " + uniQID + "  -->Col No" + i);


				}


				if (rsmd.getColumnName(i).equals("GST_CAT")) {

					pstat.setString(i, gstType);
					System.out.println("From addVahicalValues VehicalName setting values " + "empty" + "  -->Col No" + i);


				}
				if (rsmd.getColumnName(i).equals("GST_RATE")) {
					pstat.setFloat(i, gstRate);
					System.out.println("From addVahicalValues  VehicalFuelType setting values " + "empty" + "  -->Col No" + i);


				}

			}
			int insertVal = pstat.executeUpdate();
			//boolean insertVal=pstat.execute();

			if (insertVal > 0) {
				System.out.println("inserted row Value from exUpdate--->" + insertVal);

				//JOptionPane.showMessageDialog(null," Success !!!");


			}
		} catch (Exception ex) {
			ex.printStackTrace();
			//			JOptionPane.showMessageDialog(null, "From DBLicense Error My Dear : " + ex);

		}


	}

	public void addGstDetails(Connection con, String gstType, int gstRate, String tableName)
	{



		try {
			stat = con.createStatement();
			result = stat.executeQuery("select * from " + tableName);

			rsmd = result.getMetaData();

			columnCount = rsmd.getColumnCount();

			tableName = rsmd.getTableName(columnCount);

			int[] pos = new int[columnCount];

			int posValue = 0;

			System.out.println("From DB  column Count is " + (columnCount));

			for (int idxVar = 0; idxVar < pos.length; idxVar++) {
				posValue = idxVar;
				pos[idxVar] = ++posValue;

				System.out.println("From DB  putting values" + pos[idxVar]);

			}
			getTabColNames(tableName, rsmd, columnCount);




			pstat = con.prepareStatement("insert into " + tableName + " values(?,?,?)");

			for (int idx = 0; idx < pos.length; idx++)
			{


				if (pos[idx] == col_gst_ID) {
					int uniQID = genUniId(con, tableName);
					pstat.setInt(pos[idx], uniQID);
					System.out.println("From addTransportDetails  ID setting values "  + "  -->Col No" + pos[idx]);


				}

				if (pos[idx] == col_gst_type_name) {

					pstat.setString(pos[idx], gstType);
					System.out.println("From addTransportDetails VehicalName setting values " + gstType + "  -->Col No" + pos[idx]);


				}

				if (pos[idx] == col_gst_rate) {

					pstat.setInt(pos[idx], gstRate);
					System.out.println("From addTransportDetails VehicalName setting values " + gstRate + "  -->Col No" + pos[idx]);


				}








			}


			int insertVal = pstat.executeUpdate();
			//boolean insertVal=pstat.execute();

			if (insertVal > 0) {
				System.out.println("inserted row Value from exUpdate--->" + insertVal);

				//JOptionPane.showMessageDialog(null," Success !!!");


			}
		} catch (Exception ex) {
			ex.printStackTrace();
			//			JOptionPane.showMessageDialog(null, "From DBLicense Error My Dear : " + ex);

		}


	}

	public String getGstFlag(String gst_col, Connection con, String tableName, String string) {
		String values = "";



			try {
				//System.out.println("getting from " + tableName);

             if(string.equals("tax"))
			 {
				 Statement stat = con.createStatement();

				 ResultSet result = stat.executeQuery("select ID from " + tableName + "");

				 if (result.next()) {

					 values = result.getString(1) + ":" + "";

					 return values;

				 }
			 }
		else {
				 Statement stat = con.createStatement();

				 ResultSet result = stat.executeQuery("select GST_CAT , GST_RATE  from " + tableName + "");

				 if (result.next()) {

					 values = result.getString(1) + ":" + result.getString(2);

                     //System.out.println("Null From getFlag-->");

                     return values;

				 }

			 }

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}


		return values;
	}

	public void changeGstFlags(Connection con, String finalTableGstFlag, String gst_col, String gstCategory,float gstRate,int gst_ID) {

		//System.out.println("calling dbConchangeGFlags");

		try {
		PreparedStatement	pstat = con.prepareStatement("update " + finalTableGstFlag + " set gst_cat = ? ,GST_RATE = ? where ID = ?");


			pstat.setString(1, gstCategory);

			pstat.setFloat(2, gstRate);

			pstat.setInt(3, gst_ID);

			int insertVal = pstat.executeUpdate();
			if (insertVal > 0) {
				System.out.println("Value from gstflag exUpdate--->" + insertVal);
				//JOptionPane.showMessageDialog(null, "GST Rate changed");

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}

	}

	public void changeGstDetails(Connection con,String tableName, int gstId, String txtChangeGstRateVal, int vOoZ,String gstCategory) {
		try {


			if(gstCategory.equals("stategst") || gstCategory.equals("normalgst"))
			{



				pstat = con.prepareStatement("update " + tableName + " set GST_RATE = ? where ID = ?");


				pstat.setFloat(1, Float.parseFloat(txtChangeGstRateVal));
				pstat.setInt(2, gstId);

				int insertVal = pstat.executeUpdate();
				if (insertVal > 0) {
					System.out.println("Value from exUpdate--->" + insertVal);
					JOptionPane.showMessageDialog(null, "GST Rate changed");

				}

			}
			else {



				pstat = con.prepareStatement("update " + tableName + " set GST_RATE = ? where ID = ?");


				pstat.setFloat(1, Float.parseFloat(txtChangeGstRateVal));
				pstat.setInt(2, gstId);

				int insertVal = pstat.executeUpdate();
				if (insertVal > 0) {
					System.out.println("Value from exUpdate--->" + insertVal);
					JOptionPane.showMessageDialog(null, "GST Rate changed");

				}

			}


		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error  Changing GST Rate" + ex);
			System.out.println("Error  Changing GST Rate-->" + ex);

		}


	}
	public String getMultiColListDetail(String strId, Connection con, String tableName) {
		String values = "";
		if (tableName.equalsIgnoreCase("bizme_admin") || tableName.equalsIgnoreCase("simple_bizme_admin"))
		{


			try {
				//System.out.println("getting from " + tableName);
				Statement	stat = con.createStatement();


				ResultSet result = stat.executeQuery("select USER_ID,PASSWORD  from "+tableName+" where ID="+strId);

				if(result.next()) {

					values = result.getString(1) + ":" + result.getString(2);

					}

				return values;

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}


		}
		else if (tableName.equalsIgnoreCase("method_detail") || tableName.equalsIgnoreCase("simple_method_detail"))
		{


			try {
				System.out.println("getting from " + tableName);
				Statement	stat = con.createStatement();


				ResultSet result = stat.executeQuery("select METHOD_NAME,DESCRIPTION,SEARCH_KEY  from "+tableName+" where ID="+strId);

				if(result.next()) {

					values = result.getString(1) + ":" + result.getString(2)
							+ ":" + result.getString(3);


				}

				return values;

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}


		}
		else if (tableName.equalsIgnoreCase("test_group_rates") || tableName.equalsIgnoreCase("simple_test_group_rates")
				|| tableName.equalsIgnoreCase("doc_test_rates")) {


			try {
				System.out.println("getting from " + tableName);
				Statement	stat = con.createStatement();


				ResultSet result = null;


				if(tableName.equalsIgnoreCase("doc_test_rates"))
				{
					result = stat.executeQuery("select TEST_GROUP , REPORT_TITLE ,SHORT_NAME ,RATE,COMMISN ,ACT_AMT,SEARCH_KEY  from "+tableName+" where ID="+strId);


				}
				else
				{
					result = stat.executeQuery("select TEST_GROUP , REPORT_TITLE ,SHORT_NAME ,RATE,SEARCH_KEY  from "+tableName+" where ID="+strId);


				}

				if(result.next()) {

					values = result.getString(1) + ":" + result.getString(2)
							+ ":" + result.getString(3) + ":" + result.getString(4)
							+ ":" + result.getString(5) ;


				}

				return values;

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}


		}
		else if (tableName.equalsIgnoreCase("patho_lab_detail") || tableName.equalsIgnoreCase("simple_patho_lab_detail")) {


			try {
				System.out.println("getting from " + tableName);
			Statement	stat = con.createStatement();

				ResultSet result = stat.executeQuery("select patho_lab_name,phone_no,phone_no2,phone_no3,email_id,address,address2,address3,remark from "+tableName+" where ID="+strId);

				if(result.next()) {

					values = result.getString(1) + ":" + result.getString(2)
							+ ":" + result.getString(3) + ":" + result.getString(4)
							+ ":" + result.getString(5) + ":" + result.getString(6)
							+ ":" + result.getString(7) + ":" + result.getString(8)
							+ ":" + result.getString(9);


				}

				return values;

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}


		}
		else if (tableName.equalsIgnoreCase("doctor_detail") || tableName.equalsIgnoreCase("simple_doctor_detail")) {


			try {
				System.out.println("getting from " + tableName);
			Statement	stat = con.createStatement();


			ResultSet	result = stat.executeQuery("select doctor_name , degree ,commisn , fees , act_amt , phone_no ,email_id , address ,remark from "+tableName+" where ID="+strId);

				if(result.next()) {

					values = result.getString(1) + ":" + result.getString(2)
							+ ":" + result.getString(3) + ":" + result.getString(4)
							+ ":" + result.getString(5) + ":" + result.getString(6)
							+ ":" + result.getString(7)+ ":" + result.getString(8)+ ":" + result.getString(9);

				}

				return values;

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}


		}

		else if (tableName.equalsIgnoreCase("patient_detail") || tableName.equalsIgnoreCase("simple_patient_detail")) {


			try {
				System.out.println("getting from " + tableName);
				Statement stat = con.createStatement();


                ResultSet result = stat.executeQuery("select patient_name , sex ,age , phone_no ,email_id , address ,remark,test_report,child_adult from "+tableName+" where ID="+strId);

				if(result.next()) {

					values = result.getString(1) + ":" + result.getString(2)
							+ ":" + result.getString(3) + ":" + result.getString(4)
							+ ":" + result.getString(5) + ":" + result.getString(6)
                            + ":" + result.getString(7)+ ":" + result.getString(8)
							+ ":" + result.getString(9);


				}

				return values;

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}


		}



		else if (tableName.equalsIgnoreCase("collection_branch_detail") || tableName.equalsIgnoreCase("simple_collection_branch_detail")) {


			try {
				System.out.println("getting from " + tableName);
				Statement stat = con.createStatement();

                ResultSet result = stat.executeQuery("select branch_name , phone_no ,email_id , address ,remark from "+tableName+" where ID="+strId);

				if(result.next()) {

					values = result.getString(1) + ":" + result.getString(2)
							+ ":" + result.getString(3) + ":" + result.getString(4)
							+ ":" + result.getString(5);


				}

				return values;

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}


		}


		/*if (tableName.equalsIgnoreCase("buyer_detail") || tableName.equalsIgnoreCase("simple_buyer_detail")) {


			try {
				System.out.println("getting from " + tableName);
				stat = con.createStatement();

						result = stat.executeQuery("select BUYER_NAME , PHONE_NO, ADDRESS, REMARK, ENTRY_DATE from "+tableName+" where ID="+strId);

				if(result.next()) {

					values = result.getString(1) + ":" + result.getString(2)+ ":" + result.getString(3)
							+ ":" + result.getString(4)+ ":" + result.getString(5);


				}

				return values;

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}


		}
		else if (tableName.equalsIgnoreCase("goods_detail") || tableName.equalsIgnoreCase("simple_goods_detail")) {


			try {
				System.out.println("getting from " + tableName);
				stat = con.createStatement();

				String strQuery="select DESCRIPTION_OF_GOODS , QTY , UNIT, PRICE , DISCOUNT " +
						"from "+tableName+" where ID="+strId;
				result = stat.executeQuery(strQuery);

				if(result.next()) {

					values = result.getString(1) + ":" + result.getString(2)
							+ ":" +result.getString(3) + ":" + result.getString(4)
							+ ":" +result.getString(5) ;


				}

				return values;

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}


		}

		else if (tableName.equalsIgnoreCase("org_detail") || tableName.equalsIgnoreCase("simple_org_detail")) {


			try {
				System.out.println("getting from " + tableName);
				stat = con.createStatement();


				result = stat.executeQuery("select OrgName , tophead ,authorised_person from "+tableName+" where ID="+strId);

				if(result.next()) {

					values = result.getString(1) + ":" + result.getString(2)+ ":" + result.getString(3) ;


				}

				return values;

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}


		}
		else if (tableName.equalsIgnoreCase("party_detail") || tableName.equalsIgnoreCase("simple_party_detail")) {


			try {
				System.out.println("getting from " + tableName);
				stat = con.createStatement();


				result = stat.executeQuery("select BUYER_NAME , PHONE_NO, GST_NO, ADDRESS, REMARK, ENTRY_DATE from "+tableName+" where ID="+strId);

				if(result.next()) {

					values = result.getString(1) + ":" + result.getString(2)+ ":" + result.getString(3)
							+ ":" + result.getString(4)+ ":" + result.getString(5);


				}

				return values;

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}


		}
		else if (tableName.equalsIgnoreCase("quotation_detail") || tableName.equalsIgnoreCase("simple_quotation_detail")) {


			try {
				System.out.println("getting from " + tableName);
				stat = con.createStatement();


				String strQuery="select QUOTATION_NAME , GST_NO , BNK_NAME, BNKACC_NO, TERMS_COND1 , TERMS_COND2 , TERMS_COND3 " +
						"from "+tableName+" where ID="+strId;
				result = stat.executeQuery(strQuery);

				if(result.next()) {

					values = result.getString(1) + ":" + result.getString(2)
							+ ":" +result.getString(3) + ":" + result.getString(4)
							+ ":" +result.getString(5) + ":" + result.getString(6)
							+ ":" + result.getString(7);


				}

				return values;

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}


		}
		else if(tableName.equalsIgnoreCase("transport_detail") || tableName.equalsIgnoreCase("simple_transport_detail"))
		{


			try {
				System.out.println("getting from " + tableName);
				stat = con.createStatement();


				String strQuery="select TRANSPORT_NAME,LR_NO,TOTAL_DAGINA,AGENT,BANK_NAME,BANK_ACC_NO,IFSC_CODE " +
						"from "+tableName+" where ID="+strId;
				result = stat.executeQuery(strQuery);

				if(result.next()) {

					values = result.getString(1) + ":" + result.getString(2)
							+ ":" +result.getString(3) + ":" + result.getString(4)
							+ ":" +result.getString(5) + ":" + result.getString(6)
							+ ":" + result.getString(7);


				}

				return values;

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}


		}
         */
		return values;
	}

	public String getMultiColList(String strId, Connection con, String tableName, String colName) {
		String values = "";

		if (tableName.equalsIgnoreCase("patho_lab_detail") || tableName.equalsIgnoreCase("simple_patho_lab_detail"))
		{


			try {
				System.out.println("getting from " + tableName);
				Statement stat = con.createStatement();

				String qry="";
				if(colName.length()>0)
				{

					qry="select patho_lab_name,address,address2,address3,phone_no,phone_no2,phone_no3,email_id,remark from "+tableName+" where "+colName+"='"+strId+"'";
				}
				else
				{
					qry="select patho_lab_name,address,address2,address3,phone_no,phone_no2,phone_no3,email_id,remark from "+tableName+" where ID="+strId;
				}
				ResultSet result = stat.executeQuery(qry);

				if(result.next()) {

					values = result.getString(1) + ":" + result.getString(2)+ ":" + result.getString(3)
							+ ":" + result.getString(4)+ ":" + result.getString(5)
							+ ":" + result.getString(6)+ ":" + result.getString(7)+ ":"
							+ result.getString(8)+ ":" + result.getString(9);


				}

				return values;

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}


		}
		else if (tableName.equalsIgnoreCase("buyer_detail") || tableName.equalsIgnoreCase("simple_buyer_detail")) {


			try {
				System.out.println("getting from " + tableName);
			Statement stat = con.createStatement();

				String qry="";
				if(colName.length()>0)
				{

					qry="select buyer_name , address ,phone_no from "+tableName+" where "+colName+"='"+strId+"'";
				}
				else
				{
					qry="select buyer_name , address ,phone_no from "+tableName+" where ID="+strId;
				}
			ResultSet result = stat.executeQuery(qry);

				if(result.next()) {

					values = result.getString(1) + ":" + result.getString(2)+ ":" + result.getString(3);


				}

				return values;

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}


		}
		else if (tableName.equalsIgnoreCase("goods_detail") || tableName.equalsIgnoreCase("simple_goods_detail")) {


			try {
				//System.out.println("getting from " + tableName);
				Statement stat = con.createStatement();

				String strQuery="select DESCRIPTION_OF_GOODS , QTY , UNIT, PRICE , DISCOUNT " +
						"from "+tableName+" where ID="+strId;
				ResultSet result = stat.executeQuery(strQuery);

				if(result.next()) {

					values = result.getString(1) + ":" + result.getString(2)
							+ ":" +result.getString(3) + ":" + result.getString(4)
							+ ":" +result.getString(5) ;


				}

				return values;

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}


		}

		else if (tableName.equalsIgnoreCase("org_detail") || tableName.equalsIgnoreCase("simple_org_detail")) {


			try {
				//System.out.println("getting from " + tableName);
				Statement stat = con.createStatement();


				ResultSet result = stat.executeQuery("select OrgName , tophead ,authorised_person ,IMG_PATH from "+tableName+" where ID="+strId);

				if(result.next()) {

					values = result.getString(1) + ":" + result.getString(2)+ ":" + result.getString(3)
							+ ":" + result.getString(4);


				}

				return values;

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}


		}
		else if (tableName.equalsIgnoreCase("party_detail") || tableName.equalsIgnoreCase("simple_party_detail")) {


			try {
				System.out.println("getting from " + tableName);
				Statement stat = con.createStatement();

				String qry="";
				if(colName.length()>0)
				{
					qry="select buyer_name , address ,phone_no ,gst_no from "+tableName+" where "+colName+"='"+strId+"'";
				}
				else
				{
					qry="select buyer_name , address ,phone_no ,gst_no from "+tableName+" where ID="+strId;
				}

				ResultSet result = stat.executeQuery(qry);

				if(result.next()) {

					values = result.getString(1) + ":" + result.getString(2)+ ":" + result.getString(3)+ ":" + result.getString(4);


				}

				return values;

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}


		}
		else if (tableName.equalsIgnoreCase("quotation_detail") || tableName.equalsIgnoreCase("simple_quotation_detail")) {


			try {
				System.out.println("getting from " + tableName);
				Statement stat = con.createStatement();
				String strQuery="";
                if(colName.length()>0)
				{
					strQuery="select QUOTATION_NAME , GST_NO , BNK_NAME, BNKACC_NO, TERMS_COND1 , TERMS_COND2 , TERMS_COND3 " +
							"from "+tableName+" where "+colName+"='"+strId+"'";

				}
				else {
					strQuery = "select QUOTATION_NAME , GST_NO , BNK_NAME, BNKACC_NO, TERMS_COND1 , TERMS_COND2 , TERMS_COND3 " +
							"from " + tableName + " where ID=" + strId;
				}

				ResultSet result = stat.executeQuery(strQuery);

				if(result.next()) {

					values = result.getString(1) + ":" + result.getString(2)
							+ ":" +result.getString(3) + ":" + result.getString(4)
							+ ":" +result.getString(5) + ":" + result.getString(6)
							+ ":" + result.getString(7);


				}

				return values;

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}


		}
		else if(tableName.equalsIgnoreCase("transport_detail") || tableName.equalsIgnoreCase("simple_transport_detail"))
		{


			try {
				System.out.println("getting from " + tableName);
				Statement stat = con.createStatement();

				String qry="";
				if(colName.length()>0)
				{
					qry="select TRANSPORT_NAME,LR_NO,TOTAL_DAGINA,AGENT,BANK_NAME,BANK_ACC_NO,IFSC_CODE  from "+tableName+" where "+colName+"='"+strId+"'";
				}
				else
				{
					qry="select TRANSPORT_NAME,LR_NO,TOTAL_DAGINA,AGENT,BANK_NAME,BANK_ACC_NO,IFSC_CODE  from "+tableName+" where ID="+strId;
				}


				ResultSet result = stat.executeQuery(qry);

				if(result.next()) {

					values = result.getString(1) + ":" + result.getString(2)
							+ ":" +result.getString(3) + ":" + result.getString(4)
							+ ":" +result.getString(5) + ":" + result.getString(6)
							+ ":" + result.getString(7);


				}

				return values;

			} catch (Exception ex) {
				System.out.println("Error From getList-->" + ex);
			}


		}

		return values;
	}

	public void addQuotationDetails(Connection con, String tableName, String quotationName, String gstNo, String  bnkName,String bankAccNo, String termsCondition1, String termsCondition2, String termsCondition3, int vOoZ, int quoId) {



		try {
		Statement	stat = con.createStatement();
		ResultSet	result = stat.executeQuery("select * from " + tableName);

		ResultSetMetaData	rsmd = result.getMetaData();

		int	columnCount = rsmd.getColumnCount();


			System.out.println("From DB addVahicalValues column Count is " + (columnCount));




			if (vOoZ == 0) {

			PreparedStatement	pstat = con.prepareStatement("insert into " + tableName + " values(?,?,?,?,?,?,?,?)");



//				System.out.println("If succeed Table Name====> " + tableName + "and ColCount is -->" + ColCount);

					for (int i = 1; i <= columnCount; i++) {

//					System.out.println("colnames====> " + rsmd.getColumnName(i));

						if (rsmd.getColumnName(i).equals("ID")) {
							int uniQID = genUniId(con, tableName);
							pstat.setInt(i, uniQID);
							System.out.println("From addVahicalValues  ID setting values " + uniQID + "  -->Col No" + i);


						}


						if (rsmd.getColumnName(i).equals("QUOTATION_NAME")) {

							pstat.setString(i, quotationName);
							System.out.println("From addVahicalValues VehicalName setting values " + quotationName + "  -->Col No" + i);


						}
						if (rsmd.getColumnName(i).equals("GST_NO")) {
							pstat.setString(i, gstNo);
							System.out.println("From addVahicalValues  VehicalFuelType setting values " + gstNo + "  -->Col No" + i);


						}

						if (rsmd.getColumnName(i).equals("BNK_NAME"))
						{
							pstat.setString(i, bnkName);
							System.out.println("From addVahicalValues  VehicalModel setting values " + bnkName + "  -->Col No" + i);


						}

						if (rsmd.getColumnName(i).equals("BNKACC_NO")) {
							pstat.setString(i, bankAccNo);
							System.out.println("From addVahicalValues  VehicalModel setting values " + bankAccNo + "  -->Col No" + i);


						}
						if (rsmd.getColumnName(i).equals("TERMS_COND1")) {
							pstat.setString(i, termsCondition1);
							System.out.println("From addVahicalValues  VehicalYear setting values " + termsCondition1+ "  -->Col No" + i);


						}
						if (rsmd.getColumnName(i).equals("TERMS_COND2")) {
							pstat.setString(i, termsCondition2);
							System.out.println("From addVahicalValues  VehicalYear setting values " + termsCondition2+ "  -->Col No" + i);


						}
						if (rsmd.getColumnName(i).equals("TERMS_COND3")) {
							pstat.setString(i, termsCondition3);
							System.out.println("From addVahicalValues  VehicalYear setting values " + termsCondition3+ "  -->Col No" + i);


						}

/*
					if (rsmd.getColumnName(i).equals("REMARK")) {
						col_bd_remark = i;
						col_name_chasiID = rsmd.getColumnName(i);
						System.out.println("values From getLGABankColNames    -->Col No " + col_bd_remark + " Col Name :" + col_name_chasiID);


					}
*/



					}


				int insertVal = pstat.executeUpdate();
				if (insertVal > 0) {
					System.out.println("Value from exUpdate--->" + insertVal);
					JOptionPane.showMessageDialog(null, "Inserted!!");

				}




			} else {




					PreparedStatement pstat = con.prepareStatement("update " + tableName + " set QUOTATION_NAME = ? , GST_NO = ?,BNK_NAME = ?, BNKACC_NO = ?, TERMS_COND1 = ?,TERMS_COND2 = ?,TERMS_COND3 = ? where ID = ?");


					pstat.setString(1, quotationName);
					pstat.setString(2, gstNo);
   					pstat.setString(3, bnkName);
   					pstat.setString(4, bankAccNo);
					pstat.setString(5, termsCondition1);
					pstat.setString(6, termsCondition2);
					pstat.setString(7, termsCondition3);

					pstat.setInt(8, quoId);

					int insertVal = pstat.executeUpdate();
					if (insertVal > 0) {
						System.out.println("Value from exUpdate--->" + insertVal);
						JOptionPane.showMessageDialog(null, "Updated!!");

					}


				}


			}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error : " + e);

		}

	}

	public String getSearchCategoryRecords(Connection conobj, String cylCatVal, String tabName, String[] colName, String[] gstFlagsVal) {
		//System.out.println("inside getCylCategoryRecords");

		String values = "";

		try {

			int len =colName.length;
			if (len>0 && !(cylCatVal.equals(""))) {

				String qry ="";

				System.out.println("getCylCategoryRecords tabName " + tabName + " colName : " + colName + " CatVal : " + cylCatVal);






				if(tabName.equalsIgnoreCase("goods_detail") || tabName.equalsIgnoreCase("simple_goods_detail"))
				{

					if (gstFlagsVal[0].equals("stategst")) {
					String	colnames="ID,DESCRIPTION_OF_GOODS, HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  IGST_RATE  ,IGST_AMOUNT  ,AMOUNT  ,SEARCH_KEY";
				    String searchKeyOrdby=" AND SEARCH_KEY Like '%igst all%' order by ID";
						getSearchCat(conobj,len,cylCatVal,tabName,colName,gstFlagsVal,colnames,searchKeyOrdby);
					} else if (gstFlagsVal[0].equals("localgst")) {
						String	colnames="ID,DESCRIPTION_OF_GOODS, HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  CGST_RATE ,CGST_AMOUNT , SGST_RATE , SGST_AMOUNT ,AMOUNT  ,SEARCH_KEY";
						String searchKeyOrdby=" AND SEARCH_KEY Like '%cgst all%' order by ID";
						getSearchCat(conobj, len,cylCatVal,tabName,colName,gstFlagsVal,colnames, searchKeyOrdby);
					} else if (gstFlagsVal[0].equals("normalgst")) {
						String	colnames="ID,DESCRIPTION_OF_GOODS, HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  NORM_GST_RATE  ,NORM_GST_AMOUNT  ,AMOUNT  ,SEARCH_KEY";
						String searchKeyOrdby=" AND SEARCH_KEY Like '%normal gst all%' order by ID";
						getSearchCat(conobj, len,cylCatVal,tabName,colName,gstFlagsVal,colnames, searchKeyOrdby);
					}


				}
				else if(tabName.equalsIgnoreCase("order_detail") || tabName.equalsIgnoreCase("simple_order_detail"))
				{

					if (gstFlagsVal[0].equals("stategst")) {
						String	colnames="ID,DESCRIPTION_OF_GOODS, HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  IGST_RATE  ,IGST_AMOUNT  ,AMOUNT  ,ORDER_ID , PARTY_NAME , QUOTATION_NAME, SEARCH_KEY,TRANSPORT_NAME ,SUPPLIER_NAME";
						String searchKeyOrdby=" AND SEARCH_KEY Like '%igst all%' order by ID";
						getSearchCat(conobj, len,cylCatVal,tabName,colName,gstFlagsVal,colnames,searchKeyOrdby);
					} else if (gstFlagsVal[0].equals("localgst")) {
						String	colnames="ID,DESCRIPTION_OF_GOODS, HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  CGST_RATE ,CGST_AMOUNT , SGST_RATE , SGST_AMOUNT ,AMOUNT  ,ORDER_ID , PARTY_NAME , QUOTATION_NAME,SEARCH_KEY,TRANSPORT_NAME ,SUPPLIER_NAME";
						String searchKeyOrdby=" AND SEARCH_KEY Like '%cgst all%' order by ID";
						getSearchCat(conobj, len,cylCatVal,tabName,colName,gstFlagsVal,colnames, searchKeyOrdby);
					} else if (gstFlagsVal[0].equals("normalgst")) {
						String	colnames="ID,DESCRIPTION_OF_GOODS, HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  NORM_GST_RATE  ,NORM_GST_AMOUNT  ,AMOUNT,ORDER_ID , PARTY_NAME , QUOTATION_NAME  ,SEARCH_KEY,SUPPLIER_NAME";
						String searchKeyOrdby=" AND SEARCH_KEY Like '%normal gst all%' order by ID";
						getSearchCat(conobj, len,cylCatVal,tabName,colName,gstFlagsVal,colnames, searchKeyOrdby);
					}

				}
				else if(tabName.equalsIgnoreCase("receipt_detail") || tabName.equalsIgnoreCase("simple_receipt_detail"))
				{


					if (gstFlagsVal[0].equals("stategst")) {
						String	colnames="ID,DESCRIPTION_OF_GOODS, HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  IGST_RATE  ,IGST_AMOUNT  ,AMOUNT  ,ORDER_ID , PARTY_NAME , QUOTATION_NAME, CHEQUE_OR_CASH ,RECEIVED_AMOUNT ,TOTAL_QTY ,TOTAL_AMOUNT ,BALANCE_QTY ,BALANCE_AMOUNT,SEARCH_KEY,SUPPLIER_NAME";
						String searchKeyOrdby=" AND SEARCH_KEY Like '%igst all%' order by ID";
						getSearchCat(conobj, len,cylCatVal,tabName,colName,gstFlagsVal,colnames,searchKeyOrdby);
					} else if (gstFlagsVal[0].equals("localgst")) {
						String	colnames="ID,DESCRIPTION_OF_GOODS, HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  CGST_RATE ,CGST_AMOUNT , SGST_RATE , SGST_AMOUNT ,AMOUNT  ,ORDER_ID , PARTY_NAME , QUOTATION_NAME,CHEQUE_OR_CASH ,RECEIVED_AMOUNT ,TOTAL_QTY ,TOTAL_AMOUNT ,BALANCE_QTY ,BALANCE_AMOUNT,SEARCH_KEY,SUPPLIER_NAME";
						String searchKeyOrdby=" AND SEARCH_KEY Like '%cgst all%' order by ID";
						getSearchCat(conobj, len,cylCatVal,tabName,colName,gstFlagsVal,colnames, searchKeyOrdby);
					} else if (gstFlagsVal[0].equals("normalgst")) {
						String	colnames="ID,DESCRIPTION_OF_GOODS, HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  NORM_GST_RATE  ,NORM_GST_AMOUNT  ,AMOUNT,ORDER_ID , PARTY_NAME , QUOTATION_NAME,CHEQUE_OR_CASH ,RECEIVED_AMOUNT ,TOTAL_QTY ,TOTAL_AMOUNT ,BALANCE_QTY ,BALANCE_AMOUNT  ,SEARCH_KEY,SUPPLIER_NAME";
						String searchKeyOrdby=" AND SEARCH_KEY Like '%normal gst all%' order by ID";
						getSearchCat(conobj, len,cylCatVal,tabName,colName,gstFlagsVal,colnames, searchKeyOrdby);
					}

				}
				else
				{
					getSearchCat(conobj, len,cylCatVal,tabName,colName,gstFlagsVal,"*", "");

				}



			} else {


			Statement	stat = conobj.createStatement();


			ResultSet	result = stat.executeQuery("select * from " + tabName);

			ResultSetMetaData	rsmd = result.getMetaData();


				int columnCount = rsmd.getColumnCount();


				while (result.next()) {


					//System.out.println("Fetching Records : "+result.getString());

					for (int i = 1; i <= columnCount; i++) {


						values += "--" + result.getString(i);

//						System.out.println("Fetching Records : " + values);


					}


				}


			}


		} catch (Exception ex) {
			System.out.println("Error from  getCylCategoryRecords : " + ex);
		}


		return values;


	}

	private String getSearchCat(Connection conobj, int len, String cylCatVal, String tabName, String[] colName, String[] gstFlagsVal, String colnames, String searchKeyOrdby) {
		String values="";
		String qry="";

		try {
			for (int i = 0; i < len; i++) {

				//JOptionPane.showMessageDialog(null,"Getting Data from "+colName[i]);

				if (i == 0) {

					boolean numFlag = isValid(cylCatVal);

					if (numFlag == true) {


						qry = "select "+colnames+"  from " + tabName + " where " + colName[i] + " =" + cylCatVal + searchKeyOrdby;


					} else {
						continue;
					}

				} else {
					//qry = "select * from " + tabName + " where " + colName[i] + " Like '%" + cylCatVal + "%'";
					qry = "select "+colnames+"  from " + tabName + " where " + colName[i] + " Like '%" + cylCatVal + "%'"+ searchKeyOrdby;


				}


				System.out.println("getCylCategoryRecords query===>" + qry);

				Statement	stat = conobj.createStatement();
				ResultSet resCheck = stat.executeQuery(qry);

				if (resCheck.next()) {
					ResultSet result = stat.executeQuery(qry);


					System.out.println("!!!getCylCategoryRecords executing query===>" + qry + " and getting result " + (result != null));

					ResultSetMetaData rsmd = result.getMetaData();

					System.out.println("!!!getCylCategoryRecords getting RSMD===>" + (rsmd != null));

					int columnCount = rsmd.getColumnCount();

					System.out.println("!!!getCylCategoryRecords getting Colcount===>" + columnCount);

//System.out.println("!!!getCylCategoryRecords checking if result.next() is true or false it is ===>"+(result.next()));


					while (result.next()) {


						System.out.println("Inside while Fetching Records");

						for (int idx = 1; idx <= columnCount; idx++) {


							values += "--" + result.getString(idx);

//								System.out.println("Fetching Records : " + values);


						}


					}

					return values;
				} else {

					continue;
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return values;
	}

	public String getSearchCatRowColCount(Connection conobj, String cylCatVal, String tabName) {
		int rowCount = 0, columnCount = 0;


		String values = "";
		try {

			/*if (!(colName.equals("")) && !(cylCatVal.equals(""))) {

				stat = conobj.createStatement();

				System.out.println("getRowColCount tabName " + tabName + " colName : " + colName + " CatVal : " + cylCatVal);

				String qry = "select * from " + tabName + " where " + colName + " Like '*" + cylCatVal + "*'";

				System.out.println("getRowColCount query===>" + qry);
				result = stat.executeQuery(qry);
				System.out.println("!!!getRowColCount executing query===>" + qry + " and getting result " + (result != null));

				rsmd = result.getMetaData();

				System.out.println("!!!getRowColCount getting RSMD===>" + (rsmd != null));

				columnCount = rsmd.getColumnCount();

				System.out.println("!!!getRowColCount getting Colcount===>" + columnCount);


//System.out.println("!!!getRowColCount checking if result.next() is true or false it is ===>"+(result.next()));


				while (result.next()) {
					System.out.println("inside while getRowColCount");
					++rowCount;


				}

				if (rowCount > 0 && columnCount > 0) {
					return rowCount + ":" + columnCount;


				} else {

					System.out.println(" from RowColCount : Rows & Columns not found ");


				}


			}*/  {


				stat = conobj.createStatement();


				result = stat.executeQuery("select * from " + tabName);

				rsmd = result.getMetaData();


				columnCount = rsmd.getColumnCount();


				while (result.next()) {
					System.out.println("From getRowColCount");
					++rowCount;


				}

				if (rowCount > 0 && columnCount > 0) {
					return rowCount + ":" + columnCount;


				} else {

					System.out.println(" from RowColCount : Rows & Columns not found ");


				}


			}

		} catch (Exception ex) {
			System.out.println("Error from  getRowColCount : " + ex);
		}


		return rowCount + ":" + columnCount;
	}

	public String getDBLicennsedOrDemo(Connection con, String tabName) {
		String values="";

		try{


			stat = con.createStatement();


			result = stat.executeQuery("select * from " + tabName);

			rsmd = result.getMetaData();


			int columnCount = rsmd.getColumnCount();


			while (result.next()) {



				for (int i = 1; i <= columnCount; i++) {


					values += result.getString(i) + ":";

				//	System.out.println("Fetching Records  " + values);


				}


			}





	} catch (Exception ex) {
		System.out.println("Error from  getDBLicennsedOrDemo : " + ex);
	}


		return values;


    }

    public void addTransportDetails(Connection con, String tableName, String transportName, String lrNo, String bankName, String bankAccNo, String ifscCode, String agent, String totalDagina, int vOoZ, int transportId) {



		try {
		Statement	stat = con.createStatement();
		ResultSet	result = stat.executeQuery("select * from " + tableName);

		ResultSetMetaData	rsmd = result.getMetaData();

		int	columnCount = rsmd.getColumnCount();




			if (vOoZ == 0) {

			PreparedStatement	pstat = con.prepareStatement("insert into " + tableName + " values(?,?,?,?,?,?,?,?)");



//				System.out.println("If succeed Table Name====> " + tableName + "and ColCount is -->" + ColCount);

					for (int i = 1; i <= columnCount; i++) {


						System.out.println("colnames====> " + rsmd.getColumnName(i));

						if (rsmd.getColumnName(i).equals("ID")) {
							int uniQID = genUniId(con, tableName);
							pstat.setInt(i, uniQID);
							System.out.println("From addTransportDetails  ID setting values " + uniQID + "  -->Col No" + i);


						}
//transportName, lrNo, bankName, bankAccNo, ifscCode, agent, totalDagina

						if (rsmd.getColumnName(i).equals("TRANSPORT_NAME")) {

							pstat.setString(i, transportName);
							System.out.println("From addTransportDetails VehicalName setting values " + transportName + "  -->Col No" + i);


						}
						if (rsmd.getColumnName(i).equals("LR_NO")) {
							pstat.setString(i, lrNo);
							System.out.println("From addVahicalValues  VehicalFuelType setting values " + lrNo + "  -->Col No" + i);


						}
						if (rsmd.getColumnName(i).equals("BANK_NAME")) {
							pstat.setString(i, bankName);
							System.out.println("From addVahicalValues  VehicalModel setting values " + bankAccNo + "  -->Col No" + i);


						}
						if (rsmd.getColumnName(i).equals("BANK_ACC_NO")) {
							pstat.setString(i, bankAccNo);
							System.out.println("From addVahicalValues  VehicalYear setting values " + bankAccNo+ "  -->Col No" + i);


						}
						if (rsmd.getColumnName(i).equals("IFSC_CODE")) {
							pstat.setString(i, ifscCode);
							System.out.println("From addVahicalValues  VehicalYear setting values " + ifscCode+ "  -->Col No" + i);


						}
						if (rsmd.getColumnName(i).equals("AGENT")) {
							pstat.setString(i, agent);
							System.out.println("From addVahicalValues  VehicalYear setting values " + agent+ "  -->Col No" + i);


						}
						if (rsmd.getColumnName(i).equals("TOTAL_DAGINA")) {
							pstat.setString(i, totalDagina);
							System.out.println("From addVahicalValues  VehicalYear setting values " + totalDagina+ "  -->Col No" + i);


						}


/*
					if (rsmd.getColumnName(i).equals("REMARK")) {
						col_bd_remark = i;
						col_name_chasiID = rsmd.getColumnName(i);
						System.out.println("values From getLGABankColNames    -->Col No " + col_bd_remark + " Col Name :" + col_name_chasiID);


					}
*/



					}



					int updateVal = pstat.executeUpdate();
					if (updateVal > 0) {
						System.out.println("Value from exUpdate--->" + updateVal);
						JOptionPane.showMessageDialog(null, "Inserted!!");

					}




			} else {

				try {
					PreparedStatement	pstat = con.prepareStatement("update " + tableName + " set TRANSPORT_NAME = ?,LR_NO = ?, BANK_NAME= ? ,BANK_ACC_NO= ?, IFSC_CODE =?,AGENT= ?, TOTAL_DAGINA= ? where ID = ?");



					pstat.setString(1, transportName);

					pstat.setString(2, lrNo);

					pstat.setString(3, bankName);
					pstat.setString(4, bankAccNo);

					pstat.setString(5, ifscCode);

					pstat.setString(6, agent);

					pstat.setString(7,totalDagina);







					pstat.setInt(9, transportId);

					int updateVal = pstat.executeUpdate();
					if (updateVal > 0) {
						System.out.println("Value from exUpdate--->" + updateVal);
						JOptionPane.showMessageDialog(null, "Updated!!");

					}


				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error : " + e);

				}




			}


		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "From addQuotaion Error My Dear : " + ex);
		}


	}

	public void addOrgDetail(Connection con, String tableName, String strCompanyName, String strTopHead, String strAuthorisedBy, String strImageOrLogoPath) {

        {



            try {
               Statement stat = con.createStatement();
               ResultSet result = stat.executeQuery("select * from " + tableName);

               ResultSetMetaData rsmd = result.getMetaData();

               int columnCount = rsmd.getColumnCount();





             PreparedStatement   pstat = con.prepareStatement("insert into " + tableName + " values(?,?,?,?,?)");

                for (int i = 1; i <= columnCount; i++) {

                    System.out.println("colnames====> " + rsmd.getColumnName(i));

                    if (rsmd.getColumnName(i).equals("ID")) {
                        //int uniQID = genUniId(con, tableName);
                        pstat.setInt(i, 1);
                        System.out.println("From addOrg  setting values 1"  + "  -->Col No" + i);


                    }


                    if (rsmd.getColumnName(i).equals("ORGNAME")) {

                        pstat.setString(i, strCompanyName);
                        System.out.println("From addOrg  setting values "  +strCompanyName+ "  -->Col No" + i);


                    }
                    if (rsmd.getColumnName(i).equals("TOPHEAD")) {

                        pstat.setString(i, strTopHead);
                        System.out.println("From addOrg  setting values "  +strTopHead+ "  -->Col No" + i);


                    }
                    if (rsmd.getColumnName(i).equals("AUTHORISED_PERSON")) {

                        pstat.setString(i, strAuthorisedBy);
                        System.out.println("From addOrg  setting values "  +strAuthorisedBy+ "  -->Col No" + i);


                    }
					if (rsmd.getColumnName(i).equals("IMG_PATH")) {

						pstat.setString(i, strImageOrLogoPath);
						System.out.println("From addOrg  setting values "  +strImageOrLogoPath+ "  -->Col No" + i);


					}


                }




                int insertVal = pstat.executeUpdate();
                //boolean insertVal=pstat.execute();

                if (insertVal > 0) {
                    System.out.println("inserted row Value from exUpdate--->" + insertVal);

                    JOptionPane.showMessageDialog(null," Success !!!");


                }
            } catch (Exception ex) {

				ex.printStackTrace();
                try {
                    PreparedStatement	pstat = con.prepareStatement("update " + tableName + " set OrgName = ?, tophead = ? ,authorised_person = ?, IMG_PATH = ? where ID = ?");


                    pstat.setString(1, strCompanyName);
                    pstat.setString(2, strTopHead);
                    pstat.setString(3,strAuthorisedBy);
					pstat.setString(4,strImageOrLogoPath);
                    pstat.setInt(5,1);

                    int insertVal = pstat.executeUpdate();
                    if (insertVal > 0) {
                        System.out.println("Value from exUpdate--->" + insertVal);
                        JOptionPane.showMessageDialog(null, "Updated!!");

                    }


                }catch (Exception e)
                {
                    JOptionPane.showMessageDialog(null, "Error : "+e);

                }

            }


        }



    }

	public void setDemoLicDate(Connection con, String tableName, String dbValueStartDate, String stringDemoOrLic) {

try {
PreparedStatement	pstat = con.prepareStatement("update " + tableName + " set date_value = ?, license_or_demo = ?  where ID = 1");


	pstat.setString(1, dbValueStartDate);
	pstat.setString(2, stringDemoOrLic);
	//pstat.setInt(3,1);

	int insertVal = pstat.executeUpdate();
	if (insertVal > 0) {
		System.out.println("Value from exUpdate--->" + insertVal);
		JOptionPane.showMessageDialog(null, "Date Updated!!");

	}


}catch (Exception e)
{
	JOptionPane.showMessageDialog(null, "Error : "+e);

}

	}

	public void setLicKeyToEncrypt(Connection con, String tableName, String key, String hkeys) {

		{



			try {
			Statement	stat = con.createStatement();
			ResultSet	result = stat.executeQuery("select * from " + tableName);

			ResultSetMetaData	rsmd = result.getMetaData();

			int	columnCount = rsmd.getColumnCount();

				tableName = rsmd.getTableName(columnCount);

				int[] pos = new int[columnCount];

				int posValue = 0;

				System.out.println("From DB  column Count is " + (columnCount));

				for (int idxVar = 0; idxVar < pos.length; idxVar++) {
					posValue = idxVar;
					pos[idxVar] = ++posValue;

					System.out.println("From DB  putting values" + pos[idxVar]);

				}
				getTabColNames(tableName, rsmd, columnCount);




			PreparedStatement	pstat = con.prepareStatement("insert into " + tableName + " values(?,?,?,?,?)");

				for (int idx = 0; idx < pos.length; idx++)
				{


					if (pos[idx] == col_chklic_ID) {
						//int uniQID = genUniId(con, tableName);
						pstat.setInt(pos[idx], 1);
						//System.out.println("From addTransportDetails  ID setting values "  + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_chklic_lic_or_demo) {

						pstat.setString(pos[idx], " ");
						//System.out.println("From addTransportDetails VehicalName setting values " + hkeys + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_chklic_date) {

						pstat.setString(pos[idx], " ");
						//System.out.println("From addTransportDetails VehicalName setting values " + hkeys + "  -->Col No" + pos[idx]);


					}


					if (pos[idx] == col_chklic_pkey) {

						pstat.setString(pos[idx], key);
						//System.out.println("From addTransportDetails VehicalName setting values " + key + "  -->Col No" + pos[idx]);


					}

					if (pos[idx] == col_chklic_f_key) {

						pstat.setString(pos[idx], hkeys);
						//System.out.println("From addTransportDetails VehicalName setting values " + hkeys + "  -->Col No" + pos[idx]);


					}




				}


				int insertVal = pstat.executeUpdate();
				//boolean insertVal=pstat.execute();

				if (insertVal > 0) {
					System.out.println("inserted row Value from exUpdate--->" + insertVal);

					JOptionPane.showMessageDialog(null," Success !!!");


				}
			} catch (Exception ex) {
				ex.printStackTrace();
	//			JOptionPane.showMessageDialog(null, "From DBLicense Error My Dear : " + ex);
				try {
				PreparedStatement pstat = con.prepareStatement("update " + tableName + " set p_key = ?, f_key = ?  where ID = ?");


					pstat.setString(1, key);
					pstat.setString(2, hkeys);
					pstat.setInt(3,1);

					int insertVal = pstat.executeUpdate();
					if (insertVal > 0) {
						System.out.println("Value from exUpdate--->" + insertVal);
						JOptionPane.showMessageDialog(null, "Date Updated!!");

					}


				}catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, "Error : "+e);

				}
			}


		}



	}

	public int addDocTestGroupName(Connection con, String reportTitle, String groupName, String tableName, int vOoZ, String shortName, float rate, float commission, float actAmt, String srchKey, String colName, int groupId, int docId) {

		int uniQID =0;

		try {

			if(vOoZ==0) {
				Statement stat = con.createStatement();
				ResultSet result = stat.executeQuery("select * from " + tableName + "");

				ResultSetMetaData rsmd = result.getMetaData();

				int columnCount = rsmd.getColumnCount();

				tableName = rsmd.getTableName(columnCount);


				System.out.println("From DB  column Count is " + (columnCount));


					PreparedStatement pstat = con.prepareStatement("insert into " + tableName + " values(?,?,?,?,?,?,?,?,?)");


					for (int i = 1; i <= columnCount; i++) {

						//System.out.println("colnames====> " + rsmd.getColumnName(i));

						if (rsmd.getColumnName(i).equals("ID")) {
							uniQID = genUniId(con, tableName);
							pstat.setInt(i, uniQID);
							System.out.println("From addOrg  setting values 1" + "  -->Col No" + i);


						}

						if (rsmd.getColumnName(i).equals("DOC_ID")) {
							pstat.setInt(i, docId);
							System.out.println("From addOrg  setting values 1" + "  -->Col No" + i);


						}

						if (rsmd.getColumnName(i).equals("REPORT_TITLE")) {

							pstat.setString(i, reportTitle);
							System.out.println("From addOrg  setting values " + reportTitle + "  -->Col No" + i);


						}

						/*if (rsmd.getColumnName(i).equals("TEST_GROUP_ID")) {

							pstat.setInt(i, groupId);
							System.out.println("From addOrg  setting values " + groupId + "  -->Col No" + i);


						}*/
						if (rsmd.getColumnName(i).equals("TEST_GROUP")) {

							pstat.setString(i, groupName);
							System.out.println("From addOrg  setting values " + groupName + "  -->Col No" + i);


						}


						if (rsmd.getColumnName(i).equals("SHORT_NAME")) {

							pstat.setString(i, shortName);
							System.out.println("From addOrg  setting values " + shortName + "  -->Col No" + i);


						}


						if (rsmd.getColumnName(i).equals("RATE")) {

							pstat.setFloat(i, rate);
							System.out.println("From addOrg  setting values " + rate + "  -->Col No" + i);


						}

						if (rsmd.getColumnName(i).equals("COMMISN")) {

							pstat.setFloat(i, commission);
							System.out.println("From addOrg  setting values " + rate + "  -->Col No" + i);


						}	if (rsmd.getColumnName(i).equals("ACT_AMT")) {

							pstat.setFloat(i, actAmt);
							System.out.println("From addOrg  setting values " + rate + "  -->Col No" + i);


						}
						if (rsmd.getColumnName(i).equals("SEARCH_KEY")) {

							pstat.setString(i, srchKey);
							System.out.println("From addOrg  setting values " + srchKey + "  -->Col No" + i);


						}


					}


					int insertVal = pstat.executeUpdate();
					//boolean insertVal=pstat.execute();

					if (insertVal > 0 && uniQID>0) {
						System.out.println("inserted row Value from exUpdate--->" + insertVal);

						//JOptionPane.showMessageDialog(null, "Done!!");

						return uniQID;
					}

			}
			else
			{

				try{
					//SEARCH_KEY

					PreparedStatement pstat = con.prepareStatement("update " + tableName + " set TEST_GROUP = ? , REPORT_TITLE = ? ,SHORT_NAME = ?, RATE = ?, COMMISN = ?, ACT_AMT = ?  where ID = ? AND DOC_ID = ?");


					pstat.setString(1, groupName);
					pstat.setString(2, reportTitle);
					pstat.setString(3, shortName);
					pstat.setFloat(4, rate);
					pstat.setFloat(5, commission);
					pstat.setFloat(6, actAmt);
					pstat.setInt(7, groupId);
					pstat.setInt(8, docId);

					int insertVal = pstat.executeUpdate();
					if (insertVal > 0) {
						System.out.println("Value from exUpdate--->" + insertVal);

						return groupId;


					}


				} catch (Exception ex) {

					ex.printStackTrace();

				}
			}



		} catch (Exception ex) {
			ex.printStackTrace();
			//			JOptionPane.showMessageDialog(null, "From DBLicense Error My Dear : " + ex);

		}

		return uniQID ;
	}

	public int addGroupName(Connection con, String reportTitle, String groupName, String tableName, int vOoZ, String shortName, float rate, String srchKey, String colName, int groupId) {

        int uniQID =0;

		try {

          if(vOoZ==0) {
			  Statement stat = con.createStatement();
			  ResultSet result = stat.executeQuery("select * from " + tableName + " where " + colName + " ='"
					  + groupName + "'");

			  ResultSetMetaData rsmd = result.getMetaData();

			  int columnCount = rsmd.getColumnCount();

			  tableName = rsmd.getTableName(columnCount);

			  int[] pos = new int[columnCount];

			  int posValue = 0;

			  System.out.println("From DB  column Count is " + (columnCount));


			  if (result.next()) {

				  return result.getInt(1);
			  } else {



				  PreparedStatement pstat = con.prepareStatement("insert into " + tableName + " values(?,?,?,?,?,?)");


				  for (int i = 1; i <= columnCount; i++) {

					  //System.out.println("colnames====> " + rsmd.getColumnName(i));

					  if (rsmd.getColumnName(i).equals("ID")) {
						  uniQID = genUniId(con, tableName);
						  pstat.setInt(i, uniQID);
						  System.out.println("From addOrg  setting values 1" + "  -->Col No" + i);


					  }


					  if (rsmd.getColumnName(i).equals("REPORT_TITLE")) {

						  pstat.setString(i, reportTitle);
						  System.out.println("From addOrg  setting values " + reportTitle + "  -->Col No" + i);


					  }

					  if (rsmd.getColumnName(i).equals("TEST_GROUP")) {

						  pstat.setString(i, groupName);
						  System.out.println("From addOrg  setting values " + groupName + "  -->Col No" + i);


					  }


					  if (rsmd.getColumnName(i).equals("SHORT_NAME")) {

						  pstat.setString(i, shortName);
						  System.out.println("From addOrg  setting values " + shortName + "  -->Col No" + i);


					  }


					  if (rsmd.getColumnName(i).equals("RATE")) {

						  pstat.setFloat(i, rate);
						  System.out.println("From addOrg  setting values " + rate + "  -->Col No" + i);


					  }

					  if (rsmd.getColumnName(i).equals("SEARCH_KEY")) {

						  pstat.setString(i, srchKey);
						  System.out.println("From addOrg  setting values " + srchKey + "  -->Col No" + i);


					  }


				  }


				  int insertVal = pstat.executeUpdate();
				  //boolean insertVal=pstat.execute();

				  if (insertVal > 0 && uniQID>0) {
					  System.out.println("inserted row Value from exUpdate--->" + insertVal);

					  //JOptionPane.showMessageDialog(null, "Done!!");

					  return uniQID;
				  }
			  }
		  }
		  else
		  {

			  try{
				   //SEARCH_KEY
				  PreparedStatement pstat = con.prepareStatement("update " + tableName + " set TEST_GROUP = ? , REPORT_TITLE = ? ,SHORT_NAME = ? ,RATE = ? where ID = ?");


				  pstat.setString(1, groupName);
				  pstat.setString(2, reportTitle);
				  pstat.setString(3, shortName);
				  pstat.setFloat(4, rate);
				  pstat.setInt(5, groupId);

				  int insertVal = pstat.executeUpdate();
				  if (insertVal > 0) {
					  System.out.println("Value from exUpdate--->" + insertVal);

					  return groupId;


				  }


			  } catch (Exception ex) {

				  ex.printStackTrace();

			  }
		  }



		} catch (Exception ex) {
			ex.printStackTrace();
			//			JOptionPane.showMessageDialog(null, "From DBLicense Error My Dear : " + ex);

		}

        return uniQID ;
	}


	public void insertInOrderId(Connection con, String tableName, String strOrdId, String searchKey, int vflag) {




		if(vflag==0)
		{
			try {

				Statement stat = con.createStatement();
				ResultSet result = stat.executeQuery("select * from " + tableName);

				ResultSetMetaData rsmd = result.getMetaData();

				int columnCount = rsmd.getColumnCount();


				PreparedStatement pstat = con.prepareStatement("insert into " + tableName + " values(?,?,?,?)");

				for (int i = 1; i <= columnCount; i++) {

					//System.out.println("colnames====> " + rsmd.getColumnName(i));

					if (rsmd.getColumnName(i).equals("ID")) {
						int uniQID = genUniId(con, tableName);
						pstat.setInt(i, uniQID);
						System.out.println("From addOrg  setting values 1" + "  -->Col No" + i);


					}


					if (rsmd.getColumnName(i).equals("ORDER_ID")) {

						pstat.setString(i, strOrdId);
						System.out.println("From addOrg  setting values " + strOrdId + "  -->Col No" + i);


					}

					if (rsmd.getColumnName(i).equals("SEARCH_KEY")) {

						pstat.setString(i, searchKey);
						System.out.println("From addOrg  setting values " + searchKey + "  -->Col No" + i);


					}

					if (rsmd.getColumnName(i).equals("RECEIPT_ID")) {


						/*String recId;
						if(strOrdId.contains("/"))
						{
							String[] strRecId=strOrdId.split("/");

							recId=strRecId[1];
						}
						else
						{
							recId=strOrdId;
						}
						*/
						pstat.setString(i, "");
						System.out.println("From addOrg  setting values "  +""+ "  -->Col No" + i);


					}


				}


				int insertVal = pstat.executeUpdate();
				//boolean insertVal=pstat.execute();

				if (insertVal > 0) {
					System.out.println("inserted row Value from exUpdate--->" + insertVal);

					//JOptionPane.showMessageDialog(null," Success !!!");


				}
			} catch (Exception ex) {

				ex.printStackTrace();

			}

			}
			else
				{

					try{

					PreparedStatement pstat = con.prepareStatement("update " + tableName + " set RECEIPT_ID = ? where ORDER_ID = ?");


					pstat.setString(1, strOrdId);
					pstat.setString(2, strOrdId);

					int insertVal = pstat.executeUpdate();
					if (insertVal > 0) {
						System.out.println("Value from exUpdate--->" + insertVal);
						JOptionPane.showMessageDialog(null, "Updated!!");

					}


				} catch (Exception ex) {

			ex.printStackTrace();

		}
				}










	}

	public String insertInToReceiptTable(Connection con, JTable table, String quotationId, String quotationName, String supplierName, String partyName, String tableName, String inTableName, String receiptNo, String chequeId, String receivedAmount, String totalQty, String totalPrice, String remainQty, String remainPrice, String[] gstFlagsVal) {

		String ordIdEntryDateSearchKey="";

		int rowCount = table.getRowCount();

		//tableName = "order_detail";
		String ordId=receiptNo;
		try {
			Statement	stat = con.createStatement();
			ResultSet	outresult = stat.executeQuery("select * from " + tableName);

			ResultSetMetaData rsmd = outresult.getMetaData();

			int	columnCount = rsmd.getColumnCount();

			tableName = rsmd.getTableName(columnCount);


			//boolean numFlag= isValid(strOrderId);

			if(ordId!=null && ordId.length()>0)
			{


				//if(numFlag==true) {
					ordId = genReceiptUniId(con, tableName, ordId);

					if(ordId.equals("NoOrd"))
					{
						return "NoReceipt" ;

					}

				/*}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Number, Order Not Generated!!!", "Simple Order", 1);


					return "NoOrd" ;
				}*/


			}

			/*String strOrderId = JOptionPane.showInputDialog(null, "Enter Number", "Order Detail", 1);


			boolean numFlag= isValid(strOrderId);

			if(strOrderId!=null && strOrderId.length()>0)
			{


				if(numFlag==true) {
					ordId = genLGAStaffUniId(con, tableName, strOrderId);

					if(ordId.equals("NoOrd"))
					{
						return "NoOrd" ;

					}

				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Number, Order Not Generated!!!", "Simple Order", 1);


					return "NoOrd" ;
				}


			}
			else {

				int yesNoVal = JOptionPane.showConfirmDialog(null,
						"Do you want to generate Auto Order?",null, JOptionPane.YEID_OPTION);
				if(yesNoVal == JOptionPane.YES_OPTION) {
					ordId = genLGAStaffUniId(con, tableName,"");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Process end by user Order Not Generated!!!", "Simple Order", 1);


					return "NoOrd" ;

				}

			}
*/

			for (int x = 0; x < rowCount; x++) {
				if (gstFlagsVal[0].equals("stategst")) {

					float igstRate= Float.valueOf(table.getValueAt(x, 7).toString());
					float igstAmt= Float.valueOf(table.getValueAt(x, 8).toString());
					float amount= Float.valueOf(table.getValueAt(x, 9).toString());
					String searchKeyVal= table.getValueAt(x, 13).toString();

					ordIdEntryDateSearchKey = setReceiptDetail(con, table, rowCount, rsmd, columnCount, tableName, ordId, partyName, quotationName, supplierName,inTableName,0,0,0,0,igstRate,igstAmt,0,0,amount,searchKeyVal,x,chequeId, receivedAmount, totalQty, totalPrice, remainQty, remainPrice);




				} else if (gstFlagsVal[0].equals("localgst")) {

					float cgstRate= Float.valueOf(table.getValueAt(x, 7).toString());
					float cgstAmt= Float.valueOf(table.getValueAt(x, 8).toString());
					float sgstRate= Float.valueOf(table.getValueAt(x, 9).toString());
					float sgstAmt= Float.valueOf(table.getValueAt(x, 10).toString());

					float amount= Float.valueOf(table.getValueAt(x, 11).toString());
					String searchKeyVal= table.getValueAt(x, 15).toString();

					ordIdEntryDateSearchKey = setReceiptDetail(con, table, rowCount, rsmd, columnCount, tableName, ordId, partyName, quotationName, supplierName, inTableName,cgstRate,cgstAmt,sgstRate,sgstAmt,0,0,0,0,amount,searchKeyVal, x, chequeId, receivedAmount, totalQty, totalPrice, remainQty, remainPrice);


				} else if (gstFlagsVal[0].equals("normalgst")) {
					float normGstRate= Float.valueOf(table.getValueAt(x, 7).toString());
					float normGstAmt= Float.valueOf(table.getValueAt(x, 8).toString());
					float amount= Float.valueOf(table.getValueAt(x, 9).toString());
					String searchKeyVal= table.getValueAt(x, 13).toString();

					ordIdEntryDateSearchKey = setReceiptDetail(con, table, rowCount, rsmd, columnCount, tableName, ordId, partyName, quotationName, supplierName,inTableName,0,0,0,0,0,0,normGstRate,normGstAmt,amount,searchKeyVal, x, chequeId, receivedAmount, totalQty, totalPrice, remainQty, remainPrice);

				}

			}


			if(ordIdEntryDateSearchKey.contains(","))
			{

				return ordIdEntryDateSearchKey;
			}
		}
		catch (Exception e)
		{

			e.printStackTrace();
		}
		return "";
	}

	//String[] gstFlagsVal
	public String getDetail(Connection conobj, String colVal, String tabName, String[] colNames, String ordByCol,  String strKey, String finalGender, String finalIsChildVal) {
        System.out.println("inside getCylCategoryRecords");
		String values = "";


        try {
            int len =colNames.length;



                if (len > 0 && !(colVal.equals(""))) {
                    for (int i = 0; i < len; i++) {

                    System.out.println("getCylCategoryRecords tabName " + tabName + " colName : " + colNames[i] + " CatVal : " + colVal);


                    Statement stat = conobj.createStatement();
                    String qry = "";



						if (strKey.equals("combotestgroup")){

                            //JOptionPane.showMessageDialog(null, "combotestgroup");

                            if(finalGender.length()>0)
							{
                              //  JOptionPane.showMessageDialog(null, "Gender "+finalGender);


								if(finalIsChildVal.length()>0) {
									if(finalGender.equalsIgnoreCase("Male")) {
										String colnames = "id, test_name , default_value , units , options , norm_val_male_child , status , test_note , test_group_id ,test_group, search_key";


										if (colNames[i].equalsIgnoreCase("id") || colNames[i].equalsIgnoreCase("test_group_id")) {
											boolean numFlag = isValid(colVal);

											if (numFlag == true) {

												String searchKeyOrdby = " AND status ='Active' order by id";// + ordByCol;
												qry = "select " + colnames + "  from " + tabName + " where " + colNames[i] + " =" + colVal + searchKeyOrdby;
										//		break;
												}
											else {
												continue;
											}
										} else {
											String searchKeyOrdby = "%' AND status ='Active' order by id"; //;
											qry = "select " + colnames + "  from " + tabName + " where " + colNames[i] + " Like '%" + colVal + searchKeyOrdby;


										//	break;
										}
									}
									else {

										String colnames  = "id, test_name , default_value , units , options ,norm_val_female_child , status , test_note , test_group_id , test_group , search_key";

										if (colNames[i].equalsIgnoreCase("id") || colNames[i].equalsIgnoreCase("test_group_id")) {
											boolean numFlag = isValid(colVal);

											if (numFlag == true) {

												String searchKeyOrdby = " AND status ='Active' order by id";// + ordByCol;
												qry = "select " + colnames + "  from " + tabName + " where " + colNames[i] + " =" + colVal + searchKeyOrdby;
										//		break;
											}
											else {
												continue;
											}
										} else {
											String searchKeyOrdby = "%' AND status ='Active' order by id";// + ordByCol;
											qry = "select " + colnames + "  from " + tabName + " where " + colNames[i] + " Like '%" + colVal + searchKeyOrdby;


										//	break;
										}
									}
								}
								else {

									if(finalGender.equalsIgnoreCase("Male")) {

										//JOptionPane.showMessageDialog(null, "finalGender "+finalGender);

										String colnames = "id, test_name , default_value , units , options ,norm_val_male , status , test_note , test_group_id ,test_group , search_key";

										//JOptionPane.showMessageDialog(null, "Gender Male is "+finalGender);

										if (colNames[i].equalsIgnoreCase("id") || colNames[i].equalsIgnoreCase("test_group_id")) {
											boolean numFlag = isValid(colVal);

											if (numFlag == true) {

												//JOptionPane.showMessageDialog(null, " numFlag == true colNames[i] "+colNames[i]);

												String searchKeyOrdby = " AND status ='Active' order by id";// + ordByCol;
												qry = "select " + colnames + "  from " + tabName + " where " + colNames[i] + " =" + colVal + searchKeyOrdby;

												//JOptionPane.showMessageDialog(null, " qry "+qry);

												//break;
											}
											else {
												continue;
											}
										} else {


											String searchKeyOrdby = "%' AND status ='Active' order by id";// + ordByCol;
											qry = "select " + colnames + "  from " + tabName + " where " + colNames[i] + " Like '%" + colVal + searchKeyOrdby;

											//JOptionPane.showMessageDialog(null, " qry "+qry);

											//break;
										}

									}
									else
									{
										String colnames = "id, test_name , default_value , units , options ,norm_val_female , status , test_note , test_group_id , test_group ,search_key";

										if (colNames[i].equalsIgnoreCase("id") || colNames[i].equalsIgnoreCase("test_group_id")) {
											boolean numFlag = isValid(colVal);

											if (numFlag == true) {

												String searchKeyOrdby = " AND status ='Active' order by id";// + ordByCol;
												qry = "select " + colnames + "  from " + tabName + " where " + colNames[i] + " =" + colVal + searchKeyOrdby;
											//	break;
											}
											else {
												continue;
											}
										} else {
											String searchKeyOrdby = "%' AND status ='Active' order by id";// + ordByCol;
											qry = "select " + colnames + "  from " + tabName + " where " + colNames[i] + " Like '%" + colVal + searchKeyOrdby;


										//	break;
										}



									}

								}
							}
							else {
                                //JOptionPane.showMessageDialog(null, "Gender length is 0 "+finalGender);

                                String colnames = "id, test_name , default_value , units , options ,norm_val_male " +
										", norm_val_female , norm_val_male_child ,norm_val_female_child , status , test_note , test_group_id , test_group ,search_key";


								if (colNames[i].equalsIgnoreCase("id") || colNames[i].equalsIgnoreCase("test_group_id")) {
									boolean numFlag = isValid(colVal);

									if (numFlag == true) {

										String searchKeyOrdby = " order by " + ordByCol;
										qry = "select " + colnames + "  from " + tabName + " where " + colNames[i] + " =" + colVal + searchKeyOrdby;
									//	break;
									}
									else {
										continue;
									}
								} else {
									String searchKeyOrdby = "%' order by " + ordByCol;
									qry = "select " + colnames + "  from " + tabName + " where " + colNames[i] + " Like '%" + colVal + searchKeyOrdby;


									//break;
								}

							}
						}//combodoctor combopatient combosamplecollectionbranch

						else if (strKey.equals("comboPatientTestReport") || strKey.equals("comboLabIdTestReport") || strKey.equals("searchReport")){

							String colnames = "ID, LAB_ID ,TEST_GROUP,TEST ,RESULT , CONDITION ,UNITS ,NORM_VALUE ,COLLECT_DATE , COLLECT_TIME ,REPORT_DATE ,REPORT_TIME" +
									",TEST_GROUP_ID, PATIENT_ID,PATIENT_NAME ,GENDER ,AGE , PHONE_NO ,ADDRESS ,REMARK ,CHILD_ADULT ,REF_DOCTOR , METHOD , TEST_REMARKS , SEARCH_KEY";

							if (colNames[i].equalsIgnoreCase("id") || colNames[i].equalsIgnoreCase("patient_id")
                                    || colNames[i].equalsIgnoreCase("lab_id")) {
								boolean numFlag = isValid(colVal);

								if (numFlag == true) {

									String searchKeyOrdby = " AND RESFLAG = 0 order by test_group_id";// + ordByCol;
									qry = "select " + colnames + "  from " + tabName + " where " + colNames[i] + " =" + colVal + searchKeyOrdby;
									//break;
								}
								else {
									continue;
								}
							} else {
								String searchKeyOrdby = "%' AND RESFLAG = 0 order by test_group_id";// + ordByCol;
								qry = "select " + colnames + "  from " + tabName + " where " + colNames[i] + " Like '%" + colVal + searchKeyOrdby;


								//break;
							}



						}
						else if (strKey.equals("comboPatientTestReportUpdated") || strKey.equals("comboLabIdTestReportUpdated") || strKey.equals("searchReportUpdated")){
							String colnames = "ID, LAB_ID ,TEST_GROUP, TEST ,RESULT ,CONDITION ,UNITS ,NORM_VALUE ,COLLECT_DATE , COLLECT_TIME ,REPORT_DATE ,REPORT_TIME" +
									",TEST_GROUP_ID, PATIENT_ID,PATIENT_NAME ,GENDER ,AGE,PHONE_NO ,ADDRESS ,REMARK ,CHILD_ADULT ,REF_DOCTOR , METHOD , TEST_REMARKS, SEARCH_KEY";

							if (colNames[i].equalsIgnoreCase("id") || colNames[i].equalsIgnoreCase("lab_id")
									|| colNames[i].equalsIgnoreCase("patient_id")) {
								boolean numFlag = isValid(colVal);

								if (numFlag == true) {

									String searchKeyOrdby = " AND RESFLAG != 0 order by test_group_id";// + ordByCol;
									qry = "select " + colnames + "  from " + tabName + " where " + colNames[i] + " =" + colVal + searchKeyOrdby;
								//	break;
								}
								else {
									continue;
								}
							} else {
								String searchKeyOrdby = "%' AND RESFLAG != 0 order by test_group_id";// + ordByCol;
								qry = "select " + colnames + "  from " + tabName + " where " + colNames[i] + " Like '%" + colVal + searchKeyOrdby;


								//break;
							}


						}
						else if (strKey.equals("comboPatientTestReceipt") || strKey.equals("searchReceipt") || strKey.equals("comboLabIdTestReceipt")){

							String colnames = "LAB_ID , PATIENT_ID , PATIENT_NAME ,DOCTOR_NAME ,TYPE ,AGE, GENDER ,CHILD_ADULT,TEST_GROUP ,MOBILE_NO ,ADDRESS,EMAIL_ID,FEES,TOTAL_FEES ,DISCOUNT ,PAYABLE ,PAID ,BALANCE ,COLLECT_DATE ,COLLECT_TIME " +
									",REPORT_DATE ,REPORT_TIME ,SEARCH_KEY,TEST_GROUP_ID";


							if (colNames[i].equalsIgnoreCase("id") || colNames[i].equalsIgnoreCase("patient_id")
									|| colNames[i].equalsIgnoreCase("lab_id")) {
								boolean numFlag = isValid(colVal);

								if (numFlag == true) {

									String searchKeyOrdby = " order by " + ordByCol;
									qry = "select " + colnames + "  from " + tabName + " where " + colNames[i] + " =" + colVal + searchKeyOrdby;
								//	break;
								}
								else {
									continue;
								}
							} else {
								String searchKeyOrdby = "%' order by " + ordByCol;
								qry = "select " + colnames + "  from " + tabName + " where " + colNames[i] + " Like '%" + colVal + searchKeyOrdby;


								//break;
							}



						}
/*
						else if (strKey.equals("comboLabIdTestReceipt")){

							String colnames = "LAB_ID , PATIENT_ID , PATIENT_NAME ,DOCTOR_NAME ,TYPE ,AGE, GENDER ,CHILD_ADULT,TEST_GROUP ,MOBILE_NO ,ADDRESS,EMAIL_ID,FEES,TOTAL_FEES ,DISCOUNT ,PAYABLE ,PAID ,BALANCE ,COLLECT_DATE ,COLLECT_TIME " +
									",REPORT_DATE ,REPORT_TIME ,SEARCH_KEY";


							if (colNames[i].equalsIgnoreCase("id") || colNames[i].equalsIgnoreCase("lab_id")) {
								boolean numFlag = isValid(colVal);

								if (numFlag == true) {

									String searchKeyOrdby = " order by " + ordByCol;
									qry = "select " + colnames + "  from " + tabName + " where " + colNames[i] + " =" + colVal + searchKeyOrdby;
								//	break;
								}
								else {
									continue;
								}
							} else {
								String searchKeyOrdby = "%' order by " + ordByCol;
								qry = "select " + colnames + "  from " + tabName + " where " + colNames[i] + " Like '%" + colVal + searchKeyOrdby;


								//break;
							}




						}
*/

                        else if (strKey.equals("searchIncomeReportTotal") || strKey.equals("searchIncomeReportYearWise")
                                || strKey.equals("searchIncomeReportDateWise")){
                            if (colVal.contains(",")) {
                                //AND SEARCH_KEY Like '%cgst all%' order by
                                String frmNToDate[] = colVal.split(",");

                                String value = frmNToDate[0];
                                String fromDate = frmNToDate[1];
                                String toDate = frmNToDate[2];
                                if (strKey.equals("searchIncomeReportYearWise")) {

                                    String[] frmDateArr= fromDate.split("/");
                                    int frmDateVal= Integer.parseInt(frmDateArr[2]);

                                    qry = "select LAB_ID , PATIENT_ID , PATIENT_NAME ,DOCTOR_NAME ,TYPE ,AGE,GENDER ,CHILD_ADULT,TEST_GROUP ,MOBILE_NO ,FEES ,TOTAL_FEES ,DISCOUNT ,PAYABLE ,PAID ,BALANCE ,COLLECT_DATE ,COLLECT_TIME " +
                                            ",REPORT_DATE ,REPORT_TIME ,SEARCH_KEY ,TEST_GROUP_ID from " + tabName + " WHERE "+ colNames[i] + " Like '%"+value+ "%' AND YEAR(COLLECT_DATE) " +
                                            "= " + frmDateVal + "" + " order by " + ordByCol;
                                }else {

                                    String frmDat = getDate(fromDate).toString();
                                    String toDat = getDate(toDate).toString();

                                    qry = "select LAB_ID , PATIENT_ID , PATIENT_NAME ,DOCTOR_NAME ,TYPE ,AGE,GENDER ,CHILD_ADULT,TEST_GROUP ,MOBILE_NO ,FEES ,TOTAL_FEES ,DISCOUNT ,PAYABLE ,PAID ,BALANCE ,COLLECT_DATE ,COLLECT_TIME " +
                                            ",REPORT_DATE ,REPORT_TIME ,SEARCH_KEY ,TEST_GROUP_ID from " + tabName + " WHERE "+ colNames[i] + " Like '%"+value+ "%' AND COLLECT_DATE BETWEEN '" + frmDat + "' AND '" + toDat + "' " + " order by " + ordByCol;

                                }

                            } else {
                                //qry = "select ID, DESCRIPTION_OF_GOODS , HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  CGST_RATE ,CGST_AMOUNT , SGST_RATE , SGST_AMOUNT ,AMOUNT  ,SEARCH_KEY  from " + tabName + " where " + colName + " Like '%" + cylCatVal + "%' AND SEARCH_KEY Like '%cgst all%' order by " + ordByCol;
                                qry = "select LAB_ID , PATIENT_ID , PATIENT_NAME ,DOCTOR_NAME ,TYPE ,AGE,GENDER ,CHILD_ADULT,TEST_GROUP ,MOBILE_NO ,FEES ,TOTAL_FEES ,DISCOUNT ,PAYABLE ,PAID ,BALANCE ,COLLECT_DATE ,COLLECT_TIME " +
                                        ",REPORT_DATE ,REPORT_TIME ,SEARCH_KEY,TEST_GROUP_ID from " + tabName + " WHERE "+ colNames[i] + " Like '%"+colVal+ "%'";// + "' order by " + ordByCol;

                            }
                        }


						//else if (strKey.equals("radioButtonYearWise") || strKey.equals("radioButtonTotal") || strKey.equals("radioButtonDateWise")){
							/*if (colVal.contains(",")) {
								//AND SEARCH_KEY Like '%cgst all%' order by
								String frmNToDate[] = colVal.split(",");

								String fromDate = frmNToDate[0];
								String toDate = frmNToDate[1];
								if (strKey.equals("radioButtonYearWise")) {

									String[] frmDateArr= fromDate.split("/");
									int frmDateVal= Integer.parseInt(frmDateArr[2]);

									qry = "select DISTINCT LAB_ID , PATIENT_ID , PATIENT_NAME ,DOCTOR_NAME ,TYPE ,AGE,GENDER ,TEST_GROUP ,MOBILE_NO ,FEES ,TOTAL_FEES ,DISCOUNT ,PAYABLE ,PAID ,BALANCE ,COLLECT_DATE ,COLLECT_TIME " +
											",REPORT_DATE ,REPORT_TIME ,SEARCH_KEY from " + tabName + " WHERE YEAR(COLLECT_DATE) " +
											"= " + frmDateVal + "" + " order by " + ordByCol;
								}else {

									String frmDat = getDate(fromDate).toString();
									String toDat = getDate(toDate).toString();

									qry = "select DISTINCT LAB_ID , PATIENT_ID , PATIENT_NAME ,DOCTOR_NAME ,TYPE ,AGE,GENDER ,TEST_GROUP ,MOBILE_NO ,FEES ,TOTAL_FEES ,DISCOUNT ,PAYABLE ,PAID ,BALANCE ,COLLECT_DATE ,COLLECT_TIME " +
											",REPORT_DATE ,REPORT_TIME ,SEARCH_KEY from " + tabName + " WHERE COLLECT_DATE BETWEEN '" + frmDat + "' AND '" + toDat + "' " + " order by " + ordByCol;

								}

							} else {
								//qry = "select ID, DESCRIPTION_OF_GOODS , HSN_SAC_CODE , QTY , UNIT ,PRICE , DISCOUNT ,  CGST_RATE ,CGST_AMOUNT , SGST_RATE , SGST_AMOUNT ,AMOUNT  ,SEARCH_KEY  from " + tabName + " where " + colName + " Like '%" + cylCatVal + "%' AND SEARCH_KEY Like '%cgst all%' order by " + ordByCol;
								qry = "select DISTINCT LAB_ID , PATIENT_ID , PATIENT_NAME ,DOCTOR_NAME ,TYPE ,AGE,GENDER ,TEST_GROUP ,MOBILE_NO ,FEES ,TOTAL_FEES ,DISCOUNT ,PAYABLE ,PAID ,BALANCE ,COLLECT_DATE ,COLLECT_TIME " +
										",REPORT_DATE ,REPORT_TIME ,SEARCH_KEY from " + tabName ;// + "' order by " + ordByCol;

							}
*/
							/*if (colNames[i].equals("lab_id")) {
								boolean numFlag = isValid(colVal);

								if (numFlag == true) {

									String searchKeyOrdby = " AND SEARCH_KEY Like '%all%' order by " + ordByCol;
									qry = "select " + colnames + "  from " + tabName + " where " + colNames[i] + " =" + colVal + searchKeyOrdby;
									break;
								}
								else {
									continue;
								}
							} else {
								String searchKeyOrdby = "%' AND SEARCH_KEY Like '%all%' order by " + ordByCol;
								qry = "select " + colnames + "  from " + tabName + " where " + colNames[i] + " Like '%" + colVal + searchKeyOrdby;


								break;
							}*/





						//}
                      else if (strKey.length() > 0) {
                        if (colNames[i].equalsIgnoreCase("ID")) {
                            boolean numFlag = isValid(colVal);

                            if (numFlag == true) {

                                qry = "select * from " + tabName + " where " + colNames[i] + " = " + colVal + "";
                            }
                            else
                            {
                            	continue;
                            }
                        } else {
                            qry = "select * from " + tabName + " where " + colNames[i] + " Like '%" + colVal + "%'";
                        }


                    }
                    System.out.println("getCylCategoryRecords query===>" + qry);


                    ResultSet resCheck = stat.executeQuery(qry);

                    if (resCheck.next()) {


						System.out.println("getCylCategoryRecords query===>" + qry);




						ResultSet result = stat.executeQuery(qry);


						System.out.println("!!!getCylCategoryRecords executing query===>" + qry + " and getting result " + (result != null));

						ResultSetMetaData rsmd = result.getMetaData();

						System.out.println("!!!getCylCategoryRecords getting RSMD===>" + (rsmd != null));

						int columnCount = rsmd.getColumnCount();


						values= getGstTypeValues(result,columnCount);



						return values+"--"+columnCount;

                    }
                    else
                    {
                        continue;
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Error from  getCylCategoryRecords : " + ex);
        }


        return values;


    }

	public int addMethod(Connection con, String tableName, String methodName, String description, String srchKey, int vooz, int methodId)
	{


		int uniQID =0;
		try {

			if(vooz==0){
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery("select * from " + tableName);

			ResultSetMetaData rsmd = result.getMetaData();

			int columnCount = rsmd.getColumnCount();


			PreparedStatement pstat = con.prepareStatement("insert into " + tableName + " values(?,?,?,?)");

			for (int i = 1; i <= columnCount; i++) {

//					System.out.println("colnames====> " + rsmd.getColumnName(i));

				if (rsmd.getColumnName(i).equals("ID")) {
					uniQID = genUniId(con, tableName);
					pstat.setInt(i, uniQID);
					System.out.println("From addVahicalValues  ID setting values " + uniQID + "  -->Col No" + i);


				}


				if (rsmd.getColumnName(i).equals("METHOD_NAME")) {

					pstat.setString(i, methodName);
					System.out.println("From addVahicalValues VehicalName setting values " + methodName + "  -->Col No" + i);


				}
				if (rsmd.getColumnName(i).equals("DESCRIPTION")) {
					pstat.setString(i, description);
					System.out.println("From addVahicalValues  VehicalFuelType setting values " + description + "  -->Col No" + i);


				}

				if (rsmd.getColumnName(i).equals("SEARCH_KEY")) {
					pstat.setString(i, srchKey);
					System.out.println("From addVahicalValues  VehicalFuelType setting values " + srchKey + "  -->Col No" + i);


				}
			}
			int insertVal = pstat.executeUpdate();
			//boolean insertVal=pstat.execute();

			if (insertVal > 0) {
				System.out.println("inserted row Value from exUpdate--->" + insertVal);

				return uniQID;

			}

		}
		else
			{

				PreparedStatement pstat = con.prepareStatement("update " + tableName + " set METHOD_NAME = ?,DESCRIPTION = ?,SEARCH_KEY" +
						"= ? where ID = ?");
				pstat.setString(1, methodName);
				pstat.setString(2, description);
				pstat.setString(3, srchKey);
				pstat.setInt(4, methodId);


				int updateVal = pstat.executeUpdate();
				if (updateVal > 0) {
					System.out.println("Value from exUpdate--->" + updateVal);

					return methodId;
				}


			}


		} catch (Exception ex) {
			ex.printStackTrace();
			//			JOptionPane.showMessageDialog(null, "From DBLicense Error My Dear : " + ex);

		}


		return 0;
	}


	public String getIncomeDetail(Connection con, String tableName, Object colName, String strKey, String fromDate, String toDate, String colVal) {


		if (strKey.equals("radioButtonTotal") || strKey.equals("comboIncomeTestGroupTotal") || strKey.equals("searchIncomeReportTotal")) {


			String values = "";
			try {
				System.out.println("getting from " + strKey);
				Statement   stat = con.createStatement();


				ResultSet result=null;
				if (strKey.equals("radioButtonTotal"))
					result = stat.executeQuery("select sum("+colName+") from " + tableName);
				else if (strKey.equals("comboIncomeTestGroupTotal"))
					result = stat.executeQuery("select sum("+colName+") from " + tableName +" WHERE TEST_GROUP = '"+colVal+"'");
				else if (strKey.equals("searchIncomeReportTotal"))
					result = stat.executeQuery("select sum("+colName+") from " + tableName +" WHERE TEST_GROUP Like '%"+colVal+"%'");


				while (result.next()) {

					values = result.getString(1);


				}

			} catch (Exception ex) {
				System.out.println("Error From Total getList-->" + ex);
			}
			return values;


		}
		else  if (strKey.equals("radioButtonYearWise") || strKey.equals("comboIncomeTestGroupYearWise") || strKey.equals("searchIncomeReportYearWise")) {


			String values = "";
			try {
				System.out.println("getting from " + strKey);
				Statement   stat = con.createStatement();


				String[] frmDateArr= fromDate.split("/");
				int frmDateVal= Integer.parseInt(frmDateArr[2]);


				ResultSet result=null;
				if(strKey.equals("radioButtonYearWise"))
					result = stat.executeQuery("select sum("+colName+") from " + tableName+ " WHERE YEAR(COLLECT_DATE) " +
							"= "+frmDateVal+"");
				else if(strKey.equals("comboIncomeTestGroupYearWise"))
					result = stat.executeQuery("select sum("+colName+") from " + tableName+ " WHERE TEST_GROUP = '"+colVal+"' AND YEAR(COLLECT_DATE) " +
							"= "+frmDateVal+"");
				else if(strKey.equals("searchIncomeReportYearWise"))
					result = stat.executeQuery("select sum("+colName+") from " + tableName+ " WHERE TEST_GROUP Like '%"+colVal+"%' AND YEAR(COLLECT_DATE) " +
							"= "+frmDateVal+"");



				while (result.next()) {

					values = result.getString(1);


				}

			} catch (Exception ex) {
				System.out.println("Error From YearWise getList-->" + ex);
			}
			return values;


		}
		else  if (strKey.equals("radioButtonDateWise") || strKey.equals("comboIncomeTestGroupDateWise") || strKey.equals("searchIncomeReportDateWise")) {


			String values = "";
			try {
				System.out.println("getting from " + strKey);
				Statement   stat = con.createStatement();


				String frmDat = getDate(fromDate).toString();
				String toDat = getDate(toDate).toString();

				ResultSet result=null;
				if (strKey.equals("radioButtonDateWise"))
					result = stat.executeQuery("select sum("+colName+") from " + tableName+" WHERE COLLECT_DATE BETWEEN '" +frmDat+ "' AND '" +toDat+ "' ");
				else if (strKey.equals("comboIncomeTestGroupDateWise"))
					result = stat.executeQuery("select sum("+colName+") from " + tableName+" WHERE TEST_GROUP = '"+colVal+"' AND COLLECT_DATE BETWEEN '" +frmDat+ "' AND '" +toDat+ "' ");
				else if (strKey.equals("searchIncomeReportDateWise"))
					result = stat.executeQuery("select sum("+colName+") from " + tableName+" WHERE TEST_GROUP Like '%"+colVal+"%' AND COLLECT_DATE BETWEEN '" +frmDat+ "' AND '" +toDat+ "' ");


				while (result.next()) {

					values = result.getString(1);


				}

			} catch (Exception ex) {
				System.out.println("Error From DateWise getList-->" + ex);
			}
			return values;


		}



		return "";
	}


	public String getAmountDetail(Connection con, String tableName, String colName, String strKey, String[] colNames, String colVal) {


		if (strKey.equals("comboPatientTestReceipt") || strKey.equals("comboLabIdTestReceipt") || strKey.equals("searchReceipt")) {

			String values = "";
			try {
				System.out.println("getting from " + strKey);
				Statement   stat = con.createStatement();


				ResultSet result=null;
               if (strKey.equals("comboPatientTestReceipt") || strKey.equals("comboLabIdTestReceipt"))
                           result = stat.executeQuery("select sum("+colName+") from " + tableName +" WHERE "+colNames[0]+" = "+colVal+"");
                     else if (strKey.equals("searchReceipt")) {

                   for(int i=0;i<colNames.length;i++)

					if (colNames[i].equalsIgnoreCase("id") || colNames[i].equalsIgnoreCase("patient_id")
							|| colNames[i].equalsIgnoreCase("lab_id")) {
						boolean numFlag = isValid(colVal);

						if (numFlag == true) {

							result = stat.executeQuery("select sum(" + colName + ") from " + tableName + " WHERE " + colNames[i] + " =" + colVal);
							//	break;
						}
						else {
							continue;
						}
					} else {
						result = stat.executeQuery("select sum(" + colName + ") from " + tableName + " WHERE " + colNames[i]  + " Like '%" + colVal + "'");


						//break;
					}


				}
                while (result.next()) {

					values = result.getString(1);


				}

			} catch (Exception ex) {
				System.out.println("Error From Total getList-->" + ex);
			}
			return values;


		}



		return "";
	}





	}
