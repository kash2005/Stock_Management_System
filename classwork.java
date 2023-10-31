import java.util.*;
class Example{
	public static String[] idArray=new String[0];
	public static String[] nameArray=new String[0];
	public static int[] prfMarksArray=new int[0];
	public static int[] dbmsMarksArray=new int[0];
	public static int[] totalArrystem;
	public final static void clearConsole() {
		try {
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
			} catch (final Exception e) {
			e.printStackTrace();
			// Handle any exceptions.
		}
	}
	public static void homePage(){
		Scanner input=new Scanner(System.in);
		clearConsole();
		for (int i = 0; i < 110; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.print("|");
		System.out.printf("%70S%40s","welcome to gdse marks management system","|\n");
		for (int i = 0; i < 110; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.println();
		System.out.println("[1] Add New Student\t\t\t\t[2] Add New Student With Marks");
		System.out.println("[3] Add Marks\t\t\t\t\t[4] Update Student Details");
		System.out.println("[5] Update Marks\t\t\t\t[6] Delete Student");
		System.out.println("[7] Print Student Details\t\t\t[8] Print Student Ranks");
		System.out.println("[9] Best in Programming Fundamentals\t\t[10] Best in Database Managment System");
		System.out.print("\nEnter an option to continue > ");
		int option = input.nextInt();
		switch(option){
			case 1:	
				clearConsole();
				addNewStudent();	
				break;
			case 2:
				clearConsole();
				addNewStudentWithMarks();
				break;
			case 3:
				clearConsole();
				addMarks();
				break;
			case 4:
				clearConsole();
				updateStudentDetails();
				break;
			case 5:
				clearConsole();
				updateMarks();
				break;
			case 6:
				clearConsole();
				deleteStudent();
				break;
			case 7:
				clearConsole();
				printStudentDetails();
				break;
			case 8:
				clearConsole();
				printStudentRank();
				break;
			case 9:
				clearConsole();
				bestInProgrammingFundamental();
				break;
			case 10:
				clearConsole();
				bestInDatabaseManagementSystem();
				break;
			default:
				System.out.println("wrong input option ");
				break;
			}
	}	
	public static boolean isDuplicate(String id){
		boolean duplicate=false;
		for (int i = 0; i < idArray.length; i++){
			if(idArray[i].equals(id)){
				duplicate=true;
			}	
		}
		return duplicate;
	}	
	public static boolean isInvalid(String sId){
		if(sId.charAt(0)=='S' && sId.length()==4 ){
			String sIdNum=sId.substring(1);
			char [] chars=sIdNum.toCharArray();
				for (int i = 0; i < chars.length; i++){
					if(Character.isDigit(chars[i])){
						return true;
					}
				}
		}
		return false;	
	}
	public static int findIdIndex(String id){
		for (int i = 0; i < idArray.length; i++){
			if(idArray[i].equalsIgnoreCase(id)){
				return i;
			}	
		}
		return -1;
	}	
	public final static void rank(){
		totalArrystem=new int[idArray.length];
		for (int i = 0; i < idArray.length; i++){
			totalArrystem[i]=(dbmsMarksArray[i]+prfMarksArray[i]);
		}
		for (int i = 0; i < totalArrystem.length-1; i++){
				for (int j = 0; j <totalArrystem.length-(i+1) ; j++){
					if(totalArrystem[j]<totalArrystem[j+1]){
						int e=totalArrystem[j];
						totalArrystem[j]=totalArrystem[j+1];
						totalArrystem[j+1]=e;
						
						String e1=idArray[j];
						idArray[j]=idArray[j+1];
						idArray[j+1]=e1;
						
						String e2=nameArray[j];
						nameArray[j]=nameArray[j+1];
						nameArray[j+1]=e2;
						
						int e3=dbmsMarksArray[j];
						dbmsMarksArray[j]=dbmsMarksArray[j+1];
						dbmsMarksArray[j+1]=e3;
						
						int e4=prfMarksArray[j];
						prfMarksArray[j]=prfMarksArray[j+1];
						prfMarksArray[j+1]=e4;
						
						}
				}
		}
	}
	public static void addNewStudent(){
		Scanner input=new Scanner(System.in);
		String id;
		
			for (int i = 0; i <= 100; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.print("|");
		System.out.printf("%58S%42s","Add new student","|");
		System.out.println();
		for (int i = 0; i <= 100; i++){
			System.out.print("-");
		}
		L1:while(true){
				System.out.print("\nEnter Student Id : ");
				id=input.nextLine();
				if (!isInvalid(id)){
					System.out.println("Invalid ID.");
					continue L1;
				}
				if (isDuplicate(id)){
					System.out.println("The Student Id already exist");		
					continue L1;	
				}
			
			String[] tempIdArray=new String[idArray.length+1];
			for (int i = 0; i < idArray.length; i++){
				tempIdArray[i]=idArray[i];
			}
			tempIdArray[tempIdArray.length-1]=id;
			idArray=tempIdArray;
			System.out.print("Enter Student Name : ");
			String name=input.nextLine();
			
			String[] tempName=new String[nameArray.length+1];
			for (int i = 0; i < nameArray.length; i++){
				tempName[i]=nameArray[i];
			}
			tempName[tempName.length-1]=name;
			nameArray=tempName;
			
			int[] tempPrfMarksArray=new int[prfMarksArray.length+1];
			int[] tempDbmsMarksArray=new int[dbmsMarksArray.length+1];
			for (int i = 0; i < idArray.length-1; i++){
				tempPrfMarksArray[i]=prfMarksArray[i];
				tempDbmsMarksArray[i]=dbmsMarksArray[i];
			}
			tempPrfMarksArray[tempPrfMarksArray.length-1]=-1;
			tempDbmsMarksArray[tempDbmsMarksArray.length-1]=-1;
			prfMarksArray=tempPrfMarksArray;
			dbmsMarksArray=tempDbmsMarksArray;
			System.out.print("\nStudent has been added successfully.Do you want to add a new student(Y/N) : ");	
			String option=input.nextLine();
			boolean yesNo=false;
			if (option.equalsIgnoreCase("y")){
				yesNo=true;
				clearConsole();
				addNewStudent();
			}else{
				clearConsole();
				homePage();
				break;
			}
		}
	}
		public static void addNewStudentWithMarks(){
		Scanner input=new Scanner(System.in);
		for (int i = 0; i <= 100; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.print("|");
		System.out.printf("%58S%42s","add new student with marks","|");
		System.out.println();
		for (int i = 0; i <= 100; i++){
			System.out.print("-");
		}
		L1:while(true){
				System.out.print("\nEnter Student Id : ");
				String id=input.nextLine();
				if (!isInvalid(id)){
					System.out.println("Invalid ID.");
					continue L1;
					}
				if (isDuplicate(id)){
					System.out.println("The Student Id already exist");		
					continue L1;	
				}
			
			String[] tempIdArray=new String[idArray.length+1];
			for (int i = 0; i < idArray.length; i++){
				tempIdArray[i]=idArray[i];
			}
			tempIdArray[tempIdArray.length-1]=id;
			idArray=tempIdArray;
			System.out.print("Enter Student Name : ");
			String name=input.nextLine();
			
			String[] tempName=new String[nameArray.length+1];
			for (int i = 0; i < nameArray.length; i++){
				tempName[i]=nameArray[i];
			}
			tempName[tempName.length-1]=name;
			nameArray=tempName;
			while(true){
				System.out.print("\nProgramming Fundamentals Marks : ");
				int prfMarks=input.nextInt();
				if(prfMarks<0 || prfMarks>100){
					System.out.println("Invalid marks please enter correct marks.");
					continue;
				}else{
					int []tempPrf = new int[prfMarksArray.length+1];
					for (int i = 0; i < prfMarksArray.length; i++){
						tempPrf[i]=prfMarksArray[i];
					}
					tempPrf[tempPrf.length-1]=prfMarks;
					prfMarksArray=tempPrf;
				}
				break;
			}
			while(true){
				System.out.print("\nDatabase Management System Marks : ");
				int dbmsMarks=input.nextInt();
				if(dbmsMarks<0 || dbmsMarks>100){
					System.out.println("Invalid marks please enter correct marks.");
					continue;
				}else{
					int []tempDbms=new int[dbmsMarksArray.length+1];
					for (int i = 0; i < dbmsMarksArray.length; i++){
						tempDbms[i]=dbmsMarksArray[i];
					}
					tempDbms[tempDbms.length-1]=dbmsMarks;
					dbmsMarksArray=tempDbms;
				}
				break;	
			}			
			System.out.print("\nStudent has been added successfully.Do you want to add a new student(Y/N) : ");	
			String option=input.next();
			boolean yesNo=false;
			if (option.equalsIgnoreCase("y")){
				yesNo=true;
				clearConsole();
				addNewStudentWithMarks();
			}else{
				homePage();
				break;
			}
		}
	}
	public static void addMarks(){
		Scanner input=new Scanner(System.in);
		for (int i = 0; i <= 100; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.print("|");
		System.out.printf("%58S%42s","add marks","|");
		System.out.println();
		for (int i = 0; i <= 100; i++){
			System.out.print("-");
		}
		System.out.println();
		String sId="";
		L1:for (int i = 0; i < 1; ){
			System.out.print("Enter Student ID : ");
		    sId = input.nextLine();
		    if(findIdIndex(sId)==-1){
				System.out.println("invalid student id");
				continue L1;
			}
			i++;
			System.out.println("student Name : "+nameArray[findIdIndex(sId)]);
			if(prfMarksArray[findIdIndex(sId)] < 0){
			while(true){
				System.out.print("\nProgramming Fundametals Marks : ");
				int prfMarks=input.nextInt();
				if(prfMarks<0 || prfMarks>100){
					System.out.println("Invalid marks please enter correct marks.");
					continue;
				}
					prfMarksArray[findIdIndex(sId)] = prfMarks;
					break;
			}
			while(true){
				System.out.print("\nDatabase Management System Marks : ");
				int dbmsMarks=input.nextInt();
				if(dbmsMarks<0 || dbmsMarks>100){
					System.out.println("Invalid marks please enter correct marks.");
					continue;
				}
				dbmsMarksArray[findIdIndex(sId)] = dbmsMarks;
				break;
			}
			System.out.print("Marks have been added.Do you want to add marks another student (y/n) : ");
			
				String yesNo = input.next();
			
				if(yesNo.equalsIgnoreCase("y")){
					clearConsole();
					addMarks();
					}else{
						clearConsole();
						homePage();
						}
			}else{
				System.out.println("This student's marks have been already added.");
				System.out.println("If you want to update the marks.please use [4] Update Marks option.");			
				System.out.print("Do you want to marks for another student? (y/n) : ");
				String yesNo = input.nextLine();
				if(yesNo.equalsIgnoreCase("y")){
					clearConsole();
					addMarks();
					}else{
						clearConsole();
						homePage();
						}
				}
		}
	}		
	public static void updateStudentDetails(){
		Scanner input=new Scanner(System.in);
		for (int i = 0; i <= 100; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.print("|");
		System.out.printf("%58S%42s","update student details","|");
		System.out.println();
		for (int i = 0; i <= 100; i++){
			System.out.print("-");
		}
		L1:for (int i = 0; i < 1; ){
			System.out.print("\nEnter student Id : ");
			String id=input.nextLine();
			if(findIdIndex(id)==-1){
				System.out.println("invalid id");
				continue L1;
			}
			i++;
		System.out.println("Student Name : "+nameArray[findIdIndex(id)]);
		if(findIdIndex(id)<=0){
			while(true){
				System.out.print("\nEnter the new student name : ");
				String name=input.nextLine();
				nameArray[findIdIndex(id)]=name;
				break;
			}
			System.out.print("Student details has been added successfully.");	
		}
		System.out.print("Do you want to update another student details? (y/n) : ");
		String option=input.nextLine();			
		if(option.equalsIgnoreCase("y")){
			clearConsole();
			updateStudentDetails();
		}else{
			clearConsole();
			homePage();
		}		
		}	
	}	
	public static void updateMarks(){
		Scanner input=new Scanner(System.in);
		for (int i = 0; i <= 100; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.print("|");
		System.out.printf("%58S%42s","update marks","|");
		System.out.println();
		for (int i = 0; i <= 100; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.println();
		L1:for (int j = 0; j < 1;){
			System.out.print("Enter student id : ");
			String id=input.nextLine();
			if (findIdIndex(id)==-1){
				System.out.println("invalid id");
				continue L1;
			}
			j++;
			boolean isFound = true;
			int indexOfStd=0;
		
			for (int i = 0; i < idArray.length; i++){
				if(idArray[i].equalsIgnoreCase(id)){
					isFound = true;
					indexOfStd = i;
					break;
				}
			}
			System.out.println("Student Name : "+nameArray[findIdIndex(id)]);
			System.out.println("Student programming fundamentals marks : "+prfMarksArray[findIdIndex(id)]);
			System.out.println("Student database management system marks : "+dbmsMarksArray[findIdIndex(id)]);
			if(isFound){
				if(prfMarksArray[indexOfStd]<0){
					System.out.println("This student's marks yet to be added");
				}else{
					while(true){
						System.out.print("\nEnter new programming fundamentals marks : ");
						int prfMarks= input.nextInt();
						if(prfMarks<0 || prfMarks>100){
							System.out.println("Invalid marks please enter correct marks.");
							continue;
						}else{
							prfMarksArray[indexOfStd]= prfMarks;
							break;
						}
					}
					while(true){
						System.out.print("Enter new marks for database management system marks : ");
						int dbmsMarks = input.nextInt();
						if(dbmsMarks<0 || dbmsMarks>100){
							System.out.println("Invalid marks please enter correct marks.");
							continue;
						}else{
							dbmsMarksArray[indexOfStd]= dbmsMarks;
							break;
						}
					}
				}
			}
			input.nextLine();
			System.out.println("Marks have been updated successfully.");
			System.out.print("Do you want update marks for another student? (y/n) : ");
			String option=input.nextLine();
			if(option.equalsIgnoreCase("y")){
				clearConsole();
				updateMarks();
			}else{
				clearConsole();
				homePage();
			}		
		}
	}
	public static void deleteStudent(){
		Scanner input=new Scanner(System.in);
		for (int i = 0; i <= 100; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.print("|");
		System.out.printf("%58S%42s","delete student","|");
		System.out.println();
		for (int i = 0; i <= 100; i++){
			System.out.print("-");
		}
		System.out.println();
		L1:for (int i = 0; i < 1; ){
		System.out.print("Enter Student id : ");
		String id=input.nextLine();
		if (findIdIndex(id)==-1){
			System.out.println("invalid student id.");
			continue L1;
		}
		i++;
		int j=0;
		String[] tempId=new String[idArray.length-1]; 
		for (int a = 0; a < idArray.length; a++){
			if(a!=findIdIndex(id)){
			tempId[j]=idArray[a];
			j++;
		}
		}
		j=0;
		String[] tempName=new String[nameArray.length-1]; 
		for (int a = 0; a < nameArray.length; a++){
			if(a!=findIdIndex(id)){
			tempName[j]=nameArray[a];
			j++;
		}
		}
		j=0;
		int[] tempPrf=new int[prfMarksArray.length-1]; 
		for (int a = 0; a < prfMarksArray.length; a++){
			if(a!=findIdIndex(id)){
			tempPrf[j]=prfMarksArray[a];
			j++;
		}
		}
		j=0;
		int[] tempDbms=new int[dbmsMarksArray.length-1]; 
		for (int a = 0; a < dbmsMarksArray.length; a++){
			if(a!=findIdIndex(id)){
			tempDbms[j]=dbmsMarksArray[a];
			j++;
		}
		}

			idArray=tempId;
			nameArray=tempName;
			prfMarksArray=tempPrf;
			dbmsMarksArray=tempDbms;
			System.out.println("Student has been deleted successfully.");
			System.out.print("Do you want to delete another student? (y/n) : ");
			String option=input.nextLine();	
			if(option.equalsIgnoreCase("y")){
				clearConsole();
				deleteStudent();
			}else{
				clearConsole();
				homePage();
			}		
		}	
	}
	public static void printStudentDetails(){
		Scanner input=new Scanner(System.in);
		for (int i = 0; i <= 100; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.print("|");
		System.out.printf("%58S%42s","print student details","|");
		System.out.println();
		for (int i = 0; i <= 100; i++){
			System.out.print("-");
		}
		System.out.println();
		L1:for (int i = 0; i < 1; ){
			System.out.print("\nEnter student Id : ");
			String id=input.nextLine();
			if(findIdIndex(id)==-1){
				System.out.print("invalid id");
				continue L1;
			}
			i++;
			System.out.println("Student Name : "+nameArray[findIdIndex(id)]);
			if(prfMarksArray[findIdIndex(id)]==-1){
				System.out.println("Maks yet to be added");
				System.out.print("Do you want to another search student detalis? (y/n) : ");
				String option=input.nextLine();
				switch(option){
					case "y":
						clearConsole();
						printStudentDetails();
					default:
						clearConsole();
						homePage();
					}
				}else{
					rank();
					System.out.println("+------------------------------------+-------------------+");
					System.out.println("|Programing Fundamentals Marks       | "+prfMarksArray[findIdIndex(id)]+"   \t\t |");
					System.out.println("|Database Menagement System Marks    | "+dbmsMarksArray[findIdIndex(id)]+"   \t\t |");
					System.out.println("|Total Maks                          | "+(prfMarksArray[findIdIndex(id)]+dbmsMarksArray[findIdIndex(id)])+"   \t\t |");
					System.out.println("|Avg.marks                           | "+((prfMarksArray[findIdIndex(id)]+dbmsMarksArray[findIdIndex(id)])/2)+"   \t\t |");
					System.out.print("|Rank                                | ");
					switch(((findIdIndex(id)+1))){
					case 1: System.out.println("( 1 First)\t |");break;
					case 2: System.out.println("( 2 Second)\t\t |");break;
					case 3: System.out.println("( 3 Third)\t\t |");break;
					default :System.out.println(((findIdIndex(id)+1))+"\t\t |");break;
					
					}
				System.out.println("+------------------------------------+-------------------+");
				System.out.print("Do you want to Update marks for another student? (y/n)\t:");			
				String option=input.nextLine();
				switch(option){
					case "y":
					clearConsole();
					printStudentDetails();
					default:
					 clearConsole();
					 homePage();
					}
				}	
		}	
    }
    public static void printStudentRank(){
		Scanner input=new Scanner(System.in);
		for (int i = 0; i <= 100; i++){
			System.out.print("-");
		} 
		System.out.println();
		System.out.print("|");
		System.out.printf("%58S%42s","print student rank","|");
		System.out.println();
		for (int i = 0; i <= 100; i++){
			System.out.print("-");
		}
		System.out.println();
		rank();
		while(true){
			 System.out.printf("+-------+-------+---------+------------+---------------+\n|Rank   |ID     |Name     |%10s |  %12s|\n+-------+-------+---------+------------+---------------+\n","Total Marks","Average Marks");
                for (int i = 0; i <idArray.length ; i++){  
                               System.out.printf("|%-7d|%-7s|%-9s|%-12d|%-15.2f|\n",(findIdIndex(idArray[i])+1), idArray[i], nameArray[i], (dbmsMarksArray[i]+prfMarksArray[i]), (dbmsMarksArray[i]+prfMarksArray[i])/2.0);        
                        }
                System.out.println("+-------+-------+---------+------------+---------------+\n");	
			break;
		}
		System.out.print("Do you want to go back to main menu? (y/n) : ");
		String option=input.nextLine();
		switch(option){
					case "y":
					clearConsole();
					homePage();
					default:
					 clearConsole();
					 printStudentRank();
		}
	}	
	public static void bestInProgrammingFundamental(){
		Scanner input=new Scanner(System.in);
		for (int i = 0; i <= 100; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.print("|");
		System.out.printf("%58S%42s","best in programming fundamentals","|");
		System.out.println();
		for (int i = 0; i <= 100; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.println("+-----+---------------+----------+----------+");
		String str1="ID",str2="Name",str3="DBMS Marks",str4="DBMS Marks";
		System.out.printf("|%-5s|%-15s|%-10s|%-10s|\n",str1,str2,str3,str4);
				System.out.println("+-----+---------------+----------+----------+");
				L1:for (int i = 0; i < dbmsMarksArray.length; i++){
						if(dbmsMarksArray[i]==-1){
							continue L1;
						}
						System.out.printf("|%-5s|%-15s|%-10d|%-10d|\n",idArray[i],nameArray[i],prfMarksArray[i],dbmsMarksArray[i]);
					}
					System.out.println("+-----+---------------+----------+----------+");
					System.out.print("Do you want to go back to main menu? (y/n) : ");
					String option=input.nextLine();
				switch(option){
					case "y":
						clearConsole();
						homePage();
					default:
						clearConsole();
						bestInProgrammingFundamental();
					}
	}	
	public static void bestInDatabaseManagementSystem(){
		Scanner input=new Scanner(System.in);
		for (int i = 0; i <= 100; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.print("|");
		System.out.printf("%58S%42s","best in database management system","|");
		System.out.println();
		for (int i = 0; i <= 100; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.println("+-----+---------------+----------+----------+");
				String str1="ID",str2="Name",str3="DBM Marks",str4="PRF Marks";
				System.out.printf("|%-5s|%-15s|%-10s|%-10s|\n",str1,str2,str3,str4);
				System.out.println("+-----+---------------+----------+----------+");
				L1:for (int i = 0; i < dbmsMarksArray.length; i++){
						if(dbmsMarksArray[i]==-1){
							continue L1;
						}
						
						System.out.printf("|%-5s|%-15s|%-10d|%-10d|\n",idArray[i],nameArray[i],dbmsMarksArray[i],prfMarksArray[i]);
					}
				
					System.out.println("+-----+---------------+----------+----------+");
					System.out.print("Do you want to go back to main menu? (y/n) : ");
					String option=input.nextLine();
					switch(option){
						case "y":
						clearConsole();
						homePage();
					default:
						clearConsole();
						printStudentRank();
					}
	}	
	public static void main(String args[]){
		homePage();
	}
}		

