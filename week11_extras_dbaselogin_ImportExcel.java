/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaselogin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;

/**
 *
 * @author abhi
 */


//import lga.db.Dbcon;


public class ImportExcel extends JPanel// implements ActionListener
   {

       // JComboBox comboListCylCategory;

  /*      JLabel lblStaffName;

	JTextField txtStaffName;

	JButton btnAddStaff;
    */

     //   JButton btnAddCylCategory;
        JButton btnEntry;



          DefaultTableModel dtm;

	   private JTable table;

//	  private JScrollPane scrollPane1, scrollPane2, scrollPane3;


        Dbob dbob;
        LGAObj LObj;


        int   winWidth;
        int   winHeight;

        int  whLocLine1;
        int  whLocLine2;
        int  whLocLine3;

	static int count;
    private JLabel lblSheetName;
       private JButton btnSelect;
       private JTextField txtSheetName;


       public ImportExcel(LGAObj LObj, Dbob dbob, String ordType)
			{
                storeDbObj(dbob);
                storeLGAObj(LObj);

                initComponents(ordType);
			  setComponentPos();



			}


		void initComponents(String ordType)
			{



    		//	btnAddVehicalCategory = new JButton("Add Detail");

                btnSelect = new JButton("Select Excel File");

                lblSheetName = new JLabel("Sheet Name");

                txtSheetName = new JTextField(10);

                btnEntry = new JButton("Store in DB");


                        //new String[]{"--","Black","White"}



                btnSelect.addActionListener(new java.awt.event.ActionListener() {
                                                public void actionPerformed(ActionEvent evt) {
                                                    btnSelectActionPerformed(evt,ordType);
                                                }
                                            }
                );




			}

       private void btnEntryActionPerformed(ActionEvent evt, String fileName, SearchExcelAndStroeInDB sedb,String ordType) {
           if(btnEntry==evt.getSource())
           {

               String sheetName = txtSheetName.getText();

               if(!(fileName.equals("")) && !(sheetName.equals("")))
               {
                  // sedb.searchPicCol(fileName,LObj,dbob,sheetName,ordType);
               }
               else
                   JOptionPane.showMessageDialog(null,"Fields are empty");


           }
       }

       void setComponentPos()
				{


                                    //----------------------------------GridBagLayout--------------------------------
                                           GridBagConstraints gbc = new GridBagConstraints();
            GridBagLayout gblayout = new GridBagLayout();


                                    //----------------------------------End of GridBagLayout---------------------------



				   this.setLayout(gblayout);

                       Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        			// Determine the new location of the window
           			int w = this.getSize().width;
           			int h = this.getSize().height;
           			int xLoc = (dim.width-w)/2;
           			int yLoc = (dim.height-h)/2;

        			// Move the window
           			this.setLocation(xLoc, yLoc);

           			int width= dim.width;//    /2;
	   			int height=dim.height;//  /2;

           			winWidth=width;    //+250;
           			winHeight=height;  //+170;


	   whLocLine1= (winHeight/2)-30;
           whLocLine2= whLocLine1;
          /* whLocLine3= whLocLine2+130;*/





     addItem(this, btnSelect, 1, 0, 1, 1, GridBagConstraints.CENTER);


                    addItem(this, lblSheetName, 0, 1, 1, 1, GridBagConstraints.CENTER);

                    addItem(this, txtSheetName, 1, 1, 1, 1, GridBagConstraints.CENTER);

     addItem(this, btnEntry, 1, 2, 1, 1, GridBagConstraints.CENTER);
















	}

		public void paintComponent(Graphics g)
				{
              			super.paintComponent(g);
             			// g.setColor(Color.orange);
              		/*	g.drawRect(20, 20, winWidth-50,  winHeight-100);


	     			g.drawLine(20,whLocLine1,winWidth-30,whLocLine1);

	     			  g.drawLine(30,whLocLine2-350000,winWidth-30,whLocLine2+350000);
          	*/
	     		        }

		void storeDbObj(Dbob dbob)
        {

                   /*                System.out.println("calling storeDbObj()");

            			Dbcon dbo=Dbcon.getDbcon();

				System.out.println("getting DB object");


                                java.sql.Connection con= Dbcon.getCon();

    			        System.out.println("getting DB Connection object");
*/
            this.dbob = dbob;
            System.out.println("Processing...");

  /*                              this.dbob.setDbob(dbo);
                                System.out.println("Dbob object set");

                                this.dbob.setCon(con);

     			        System.out.println("Connection object set");
*/				}


		 void storeLGAObj(LGAObj LObj)
         {

/*
			    System.out.println("calling storeLGAObj()");

			LGAImplDetails  LGAImplObj =LGAImplDetails.getLGAImplObj();

			    System.out.println("getting LGAImplObj object");
*/

             this.LObj = LObj;
             System.out.println("Processing...");

/*
			LObj.setLGAObj(LGAImplObj);
			 System.out.println("LGAImplObj object set");

*/

         }




		void btnSelectActionPerformed(ActionEvent evt,String ordType)
				{
				    String fileName="";

                    SearchExcelAndStroeInDB  sedb = new SearchExcelAndStroeInDB();

                    if(btnSelect==evt.getSource())
                    {

                        //fileName = sedb.getFileName();


                        String finalFileName = fileName;
                        btnEntry.addActionListener(new java.awt.event.ActionListener() {
                                                       public void actionPerformed(ActionEvent evt) {
                                                           btnEntryActionPerformed(evt, finalFileName,sedb,ordType);
                                                       }
                                                   }
                        );
                    }





				}

			void btnUpdateActionPerformed(ActionEvent evt)
				{

				  if(btnEntry==evt.getSource())
					{

  /*                                      String cylCatVal = comboListCylCategory.getSelectedItem().toString().trim();
					String CylRate = txtCylRate.getText();
					String CylQty = txtCylQty.getText();



				if(!(cylCatVal.equals("")) && !(CylRate.equals("")) && !(CylQty.equals("")))
					{

						int vOoZ=1;
                           LObj.getLGAObj().updateCylCatValues(dbob,cylCatVal,CylRate,CylQty,vOoZ);
			   JOptionPane.showMessageDialog(null," Done !!!");
			   		}
					else
					{

                                   JOptionPane.showMessageDialog(null,"Please Enter Cylinder Category");

					}
*/
					}






				}

		 void comboListCylCategoryfocusGained(FocusEvent fe)
				{
                                      System.out.println("inside combo   Getting Category List...");


	//			   comboListCylCategory.setModel(new javax.swing.DefaultComboBoxModel(LObj.getLGAObj().getCylCategory(dbob)));


				}


			void comboListCylCategoryActionPerformed(ActionEvent evt)
				{

/*
				 String cylCatVal = comboListCylCategory.getSelectedItem().toString().trim();

				 System.out.println("Cyl Category "+cylCatVal);

				if(!(cylCatVal.equals("--")) && !(cylCatVal.equals("")))
				{
					String tabName="LGAPurchase";
					 String colName="Cyl_Category";

				 System.out.println("inside IF...");
				 String dataValues[][]=  LObj.getLGAObj().getCylCatRecords(dbob,cylCatVal,tabName,colName);

			String columnNames[]=   LObj.getLGAObj().getColNames(dbob,tabName);

				               int tab1=1 ;

				   drawTable(dataValues,columnNames,tab1,0,0);


						String tabName1="LGAPurchaseTotal";
					 String colName1="";

				 System.out.println("inside IF for PurchaseTotal...");
				 String dataValues1[][]=  LObj.getLGAObj().getCylCatRecords(dbob,"",tabName1,colName1);

			String columnNames1[]=   LObj.getLGAObj().getColNames(dbob,tabName1);

				               int tab2=2;
				  drawTable(dataValues1,columnNames1,0,tab2,0);


				String tabName2="LGAPurchase";
					 String colName2="";

				 System.out.println("inside IF...for table 3");
				 String dataValues2[][]=  LObj.getLGAObj().getCylCatRecords(dbob,"",tabName2,colName2);

			String columnNames2[]=   LObj.getLGAObj().getColNames(dbob,tabName2);

				               int tab3=3 ;

				   drawTable(dataValues2,columnNames2,0,0,tab3);



				}
                                     */

				}


			void drawTable(String dataValues[][],String columnNames[],int tab1,int tab2,int tab3)
					      {

						     dtm = new DefaultTableModel(dataValues,columnNames);

			   			     table = new JTable(dtm);

                                                     	 //table.setValueAt("hi",0,6);
						  //table.setPreferredScrollableViewportSize(new Dimension(100, 15));
        					  table.setFillsViewportHeight(true);
                               table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                                         System.out.println("DrawTable Called");



				if(tab1==1)
					{ System.out.println("Table "+tab1+" Called");




                           			        /*         scrollPane1.setViewportView(table);

                         			                scrollPane1.validate();
                       				                scrollPane1.repaint();
							*/

                                         }

					if(tab2==2)
					{
        			             System.out.println("Table "+tab2+" Called");

							/*	 scrollPane2.setViewportView(table);


                         			                scrollPane2.validate();
                       				                scrollPane2.repaint();
                                                       */




                                                }
					if(tab3==3)
					{
        			             System.out.println("Table "+tab3+" Called");

								/* scrollPane3.setViewportView(table);


                         			                scrollPane3.validate();
                       				                scrollPane3.repaint();
                                                               */




                                                }


					count++;

                                       		System.out.println("Time Count "+count);

					     }




		void btnAddStaffActionPerformed(ActionEvent evt)
			{

			 /*if(btnAddStaff==evt.getSource())
				{
			String StaffName = txtStaffName.getText();
                                      if(!(StaffName.equals("")))
					{

                           LObj.getLGAObj().addStaffName(dbob,StaffName);
			   JOptionPane.showMessageDialog(null," Done !!!");
			   		}
					else
					{

                                   JOptionPane.showMessageDialog(null,"Please Enter Staff Name");

					}

				} */

			}

      /*    public static void main(String...ar)
		{

		EventQueue.invokeLater(new Runnable() {
            public void run() {
  

			new LGAPurchaseEntry(LObj, dbob).showLGAPurchaseEntryPanel();
			
					   
                     		}
			});




		}
*/
     private void addItem(JPanel p, JComponent c, int x, int y, int width, int height, int align) {
    GridBagConstraints gc = new GridBagConstraints();
    gc.gridx = x;
    gc.gridy = y;
    gc.gridwidth = width;
    gc.gridheight = height;
    gc.weightx = 5.0;
    gc.weighty = 5.0;
    gc.insets = new Insets(4, 4, 4, 4);
    gc.anchor = align;
    gc.fill = GridBagConstraints.NONE;
    p.add(c, gc);
  }


  }	