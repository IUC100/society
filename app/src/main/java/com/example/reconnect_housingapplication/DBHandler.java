package com.example.reconnect_housingapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "databasee";
    // below int is our database version
    private static final int DB_VERSION = 1;
    // below variable is for our table name.
    private static final String TABLE_REGISTERSOCIETY = "RegisterSociety";
    // below variable is for our id column.
    private static final String SOCIETYNAME_COL = "Societyname";
    private static final String ADRESS_COL = "Address";
    private static final String CITY_COL = "City";
    private static final String AREA_COL = "Area";
    private static final String PINCODE_COL = "PinCode";
    private static final String NOOFFLATS_COL = "No_of_flats";
    private static final String NOOFWINGS_COL = "No_of_wings";
    private static final String SOCIETYCODE_COL = "Societycode";
    private static final String SECRETORY_NAME_COL = "secretory_name";
    private static final String SECRETORY_ID_COL = "Secretory_id";
    private static final String PASSWORD_COL = "password";
    private static final String FLATNO_COL = "Flatno";
    private static final String WINGNO_COL = "wingNo";
    private static final String EMAIL_COL = "Email";
    private static final String PHONENO_COL = "phoneno";



    private static final String CREATE_TABLE_REGISTERSOCIETY = "CREATE TABLE " + TABLE_REGISTERSOCIETY + " ("

            + SOCIETYNAME_COL + " TEXT , "
            + ADRESS_COL + " TEXT,"
            + CITY_COL + " TEXT,"
            + AREA_COL + " TEXT,"
            + PINCODE_COL + " NUMBER,"
            + NOOFFLATS_COL + " NUMBER,"
            + NOOFWINGS_COL + " NUMBER,"
            + SOCIETYCODE_COL + " TEXT  PRIMARY KEY,"
            + SECRETORY_NAME_COL + " TEXT,"
            + SECRETORY_ID_COL + " TEXT,"
            + PASSWORD_COL + " TEXT,"
            + FLATNO_COL + " NUMBER,"
            + WINGNO_COL + " TEXT,"
            + EMAIL_COL + " TEXT,"
            + PHONENO_COL + " NUMBER)";





    private static final String TABLE_MEMBERREGISTRATION = "MemberRegistration";
    // below variable is for our id column.
    private static final String MEMBER_NAME_COL = "Name";
    private static final String MEMBER_ID_COL = "ID";
    private static final String MEMBER_PASSWORD_COL = "password";
    private static final String MEMBER_PHONENO_COL = "phoneNo";
    private static final String MEMBER_SOCIETYCODE_COL = "SocietyCode";
    private static final String MEMBER_EMAIL_COL = "Email";
    private static final String MEMBER_FLATNO_COL = "FlatNo";
    private static final String MEMBER_WINGNO_COL = "WingNo";
    //parking details//
    private static final String MEMBER_NOOFVEHICAL_COL = "noofvehical";
    private static final String MEMBER_TYPE_COL = "type";




    private static final String CREATE_TABLE_MEMBERREGISTRATION = "CREATE TABLE " + TABLE_MEMBERREGISTRATION + " ("

            + MEMBER_NAME_COL + " TEXT ,"
            + MEMBER_ID_COL + " TEXT PRIMARY KEY ,"
            + MEMBER_PASSWORD_COL + " TEXT,"
            + MEMBER_PHONENO_COL + " NUMBER,"
            + MEMBER_SOCIETYCODE_COL + " TEXT,"
            + MEMBER_EMAIL_COL + " TEXT,"
            + MEMBER_FLATNO_COL + " NUMBER,"
            + MEMBER_WINGNO_COL + " TEXT,"
            + MEMBER_NOOFVEHICAL_COL + " TEXT,"
            + MEMBER_TYPE_COL + " TEXT)";


    private static final String TABLE_RENTALSDETAILS = "Rentals";
    private static final String WING_NO = "WingNo";
    private static final String HOUSE_NO = "HouseNo";
    private static final String OWNER_NAME_COL = "Owner_name";
    private static final String MOBILE_N0_COL = "mobile_no";
    private static final String RENTIER_NAME = "Rentire_name";
    private static final String RENTIER_NUMBER = "Rentire_no";

    private static final String CREATE_TABLE_TABLE_NAME = "CREATE TABLE " + TABLE_RENTALSDETAILS + " ("
            //+ ID_COL + " TEXT PRIMARY KEY ,"
            + WING_NO + " TEXT,"
            + HOUSE_NO + " NUMBER,"
            + OWNER_NAME_COL + " TEXT,"
            + MOBILE_N0_COL + " NUMBER,"
            + RENTIER_NAME + " TEXT,"
            + RENTIER_NUMBER + " NUMBER)";

    // this method is use to add new course to our sqlite database.





    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // this method is use to add new course to our sqlite database.

    public boolean addsocietyDetails(String societyname, String address, String city, String area, String pincode, String noOfFlats, String noOfwings, String societycode, String secretoryName, String secretoryID, String password, String flatNo, String wingNo, String emial, String phoneno) {
        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();
        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();
        // on below line we are passing all values
        // along with its key and value pair.
        values.put(SOCIETYNAME_COL, societyname);
        values.put(ADRESS_COL, address);
        values.put(CITY_COL, city);
        values.put(AREA_COL, area);
        values.put(PINCODE_COL, pincode);
        values.put(NOOFFLATS_COL, noOfFlats);
        values.put(NOOFWINGS_COL, noOfwings);
        values.put(SOCIETYCODE_COL, societycode);
        values.put(SECRETORY_NAME_COL, secretoryName);
        values.put(SECRETORY_ID_COL, secretoryID);
        values.put(PASSWORD_COL, password);
        values.put(FLATNO_COL, flatNo);
        values.put(WINGNO_COL, wingNo);
        values.put(EMAIL_COL, emial);
        values.put(PHONENO_COL, phoneno);
        // after adding all values we are passing
        // content values to our table.
        long result = db.insert(TABLE_REGISTERSOCIETY, null, values);
        db.close();
        if(result==-1) return false;
        else
            return true;
        // at last we are closing our
        // database after adding database.

    }


    public boolean addMemberDetails(String username, String userId, String Password, String phoneNo, String societyCode, String Email, String Flatno, String Wingno,String noofvehical, String type ) {
        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();
        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();
        // on below line we are passing all values
        // along with its key and value pair.
        values.put(MEMBER_NAME_COL, username);
        values.put(MEMBER_ID_COL, userId);
        values.put(MEMBER_PASSWORD_COL, Password);
        values.put(MEMBER_PHONENO_COL, phoneNo);
        values.put(MEMBER_SOCIETYCODE_COL, societyCode);
        values.put(MEMBER_EMAIL_COL, Email);
        values.put(MEMBER_FLATNO_COL, Flatno);
        values.put(MEMBER_WINGNO_COL, Wingno);
        values.put(MEMBER_NOOFVEHICAL_COL, noofvehical);
        values.put(MEMBER_TYPE_COL, type);
        // after adding all values we are passing
        // content values to our table.
        long result= db.insert(TABLE_MEMBERREGISTRATION, null, values);
        db.close();
        if (result == -1)
            return false;
        else
            return true;

       /* if(result==-1)
            return false;
        else
            return true;*/
        // at last we are closing our
        // database after adding database.

    }




    public boolean addRentalsDetails(String wingno, String houseno, String Ownername, String mobileno, String rentirename, String rentireno) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        // on below line we are passing all values
        // along with its key and value pair.
        values.put(WING_NO, wingno);
        values.put(HOUSE_NO, houseno);
        values.put(OWNER_NAME_COL, Ownername);
        values.put(MOBILE_N0_COL, mobileno);
        values.put(RENTIER_NAME, rentirename);
        values.put(RENTIER_NUMBER, rentireno);
        // after adding all values we are passing
        // content values to our table.
        long result = db.insert(TABLE_RENTALSDETAILS, null, values);
        db.close();
        if(result==-1)
            return false;
        else
            return true;
        // at last we are closing our
        // database after adding database.

    }




    private static final String TABLE_COMPLAIN = "Complain";
    // below variable is for our id column.
    private static final String C_USER_ID = "ID";
    private static final String C_NAME_COL = "Name";
    private static final String C_WING_NO = "WingNo";
    private static final String C_HOUSE_NO = "HouseNo";
    private static final String C_SUBJECT_OF_COMPLAIN = "suject_of_complain";
    private static final String C_COMPLAIN = "complain";
    private static final String C_DATE = "date";


    private static final String CREATE_TABLE_TABLE_COMPLAIN = "CREATE TABLE " + TABLE_COMPLAIN + " ("
            + C_USER_ID + " TEXT PRIMARY KEY ,"
            + C_NAME_COL + " TEXT,"
            + C_WING_NO + " TEXT,"
            + C_HOUSE_NO + " NUMBER,"
            + C_SUBJECT_OF_COMPLAIN + " TEXT,"
            + C_COMPLAIN + " TEXT,"
            + C_DATE + " TEXT)";

    // this method is use to add new course to our sqlite database.

    public boolean addComplaindata( String ID,String name, String wingno, String houseno,String subjectOfComplain, String complain, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        // on below line we are passing all values
        // along with its key and value pair.
        values.put(C_USER_ID,ID);
        values.put(C_NAME_COL, name);
        values.put(C_WING_NO, wingno);
        values.put(C_HOUSE_NO, houseno);
        values.put(C_SUBJECT_OF_COMPLAIN, subjectOfComplain);
        values.put(C_COMPLAIN, complain);
        values.put(C_DATE, date);
        // after adding all values we are passing
        // content values to our table.
        long result = db.insert(TABLE_COMPLAIN, null, values);
        db.close();
        if(result==-1)
            return false;
        else
            return true;
        // at last we are closing our
        // database after adding database.

    }


    private static final String TABLE_SELLHOUSE = "sellhouse";
    // below variable is for our id column.
    private static final String S_USER_ID = "ID";
    private static final String S_WING_NO = "WingNo";
    private static final String S_HOUSE_NO = "HouseNo";
    private static final String S_NAME_COL = "Name";
    private static final String S_PHONE_NO_COL = "suject_of_complain";
    private static final String S_EMAIL_COL = "complain";


    private static final String CREATE_TABLE_SELLHOUSE = "CREATE TABLE " + TABLE_SELLHOUSE + " ("
            + S_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + S_WING_NO + " TEXT,"
            + S_HOUSE_NO + " NUMBER,"
            + S_NAME_COL + " TEXT,"
            + S_PHONE_NO_COL + " NUMBER,"
            + S_EMAIL_COL + " TEXT)";

    // this method is use to add new course to our sqlite database.

    public boolean addsellhousedetails(  String wingno, String houseno,String name,String phoneno, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        // on below line we are passing all values
        // along with its key and value pair.

        values.put(S_WING_NO, wingno);
        values.put(S_HOUSE_NO, houseno);
        values.put(S_NAME_COL, name);
        values.put(S_PHONE_NO_COL, phoneno);
        values.put(S_EMAIL_COL, email);

        // after adding all values we are passing
        // content values to our table.
        long result = db.insert(TABLE_SELLHOUSE, null, values);
        db.close();
        if(result==-1)
            return false;
        else
            return true;
        // at last we are closing our
        // database after adding database.

    }




    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_REGISTERSOCIETY);
        db.execSQL(CREATE_TABLE_MEMBERREGISTRATION);
        db.execSQL(CREATE_TABLE_TABLE_NAME);
        db.execSQL(CREATE_TABLE_TABLE_COMPLAIN);
        db.execSQL("create Table domesticHelpers(uniqueID NUMBER primary key, name TEXT,phonenumber NUMBER, serviceflats VARCHAR,services TEXT )");
        db.execSQL("create Table guest (ID INTEGER primary key autoincrement, name TEXT, phonenumber NUMBER, flatno VARCHAR, date TEXT, checkin VARCHAR)");
        db.execSQL(CREATE_TABLE_SELLHOUSE);
        db.execSQL("create Table NoticesLists(ID INTEGER primary key autoincrement, subject TEXT ,date DATE, notice TEXT)");
        db.execSQL("create Table maintenance(ID INTEGER primary key autoincrement, flattype TEXT ,maintenance NUMBER, extracharge NUMBER)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTERSOCIETY);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEMBERREGISTRATION);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RENTALSDETAILS);
        onCreate(db);
        db.execSQL("DROP TABLE IF  EXISTS " + TABLE_COMPLAIN);
        onCreate(db);
        db.execSQL("drop Table if exists domesticHelpers");
        db.execSQL("drop Table if exists Guest");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SELLHOUSE);
        onCreate(db);
        db.execSQL("drop Table if exists NoticesLists");
        db.execSQL("drop Table if exists maintenance");

    }

    //maintenance details//
    public boolean insertmaintenance(String flattype, String maintenance, String extracharge){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("flattype", flattype);
        contentValues.put("maintenance", maintenance);
        contentValues.put("extracharge", extracharge);

        long result = MyDB.insert("maintenance",null,contentValues);
        if(result==-1)
            return false;
        else
            return true;

    }


    public Cursor readalldatamaintenance()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String qry="select * from maintenance order by flattype desc";
        Cursor cursor=db.rawQuery(qry,null);
        return  cursor;
    }

    //visitors details
    public boolean insertDataDomestic(String iid, String name, String phonenumber, String services, String serviceflats){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("uniqueID", iid );
        contentValues.put("name", name);
        contentValues.put("phonenumber", phonenumber);
        contentValues.put("services", services);
        contentValues.put("serviceflats", serviceflats);
        long result = MyDB.insert("domesticHelpers",null,contentValues);
        if(result==-1)
            return false;
        else
            return true;

    }
    public boolean insertDataGuest(String name,  String phonenumber, String flatno, String date, String checkin){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name );
        contentValues.put("phonenumber", phonenumber);
        contentValues.put("flatno", flatno);
        contentValues.put("date", date);
        contentValues.put("checkin", checkin);


        long result = MyDB.insert("Guest",null,contentValues);
        if(result==-1)
            return false;
        else
            return true;

    }

    public Cursor readalldatapremise()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String qry="select * from Guest order by name desc";
        Cursor cursor=db.rawQuery(qry,null);
        return  cursor;
    }
    public Cursor readalldataDomestic()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String qry="select * from domesticHelpers order by name desc";
        Cursor cursor=db.rawQuery(qry,null);
        return  cursor;
    }




    public Boolean checkalreadyexist(String userID) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from "+TABLE_MEMBERREGISTRATION+" where "+MEMBER_ID_COL+" = ?", new String[] {userID});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkalreadyexistsociety(String societycode) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from "+TABLE_REGISTERSOCIETY+" where "+SOCIETYCODE_COL+" = ?", new String[] {societycode});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }




    public Boolean checkusernamepassword(String Name, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from "+TABLE_MEMBERREGISTRATION+" where "+MEMBER_ID_COL+" = ? and "+MEMBER_PASSWORD_COL+" = ? ", new String[]{Name,password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepasswordadmin(String Name, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from "+TABLE_REGISTERSOCIETY+" where "+SECRETORY_ID_COL+" = ? and "+PASSWORD_COL+" = ? ", new String[]{Name,password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }



    public Cursor readalldata()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String qry="select * from "+TABLE_MEMBERREGISTRATION+" order by "+MEMBER_NAME_COL+" desc";
        Cursor cursor=db.rawQuery(qry,null);
        return  cursor;
    }

    public Cursor readalldataadmin()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String qry="select * from "+TABLE_REGISTERSOCIETY+" order by "+SOCIETYNAME_COL+" desc";
        Cursor cursor=db.rawQuery(qry,null);
        return  cursor;
    }


    //rentals//

    public Boolean checkalreadyexistrentals(String userID) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from "+TABLE_RENTALSDETAILS+" where "+RENTIER_NAME+" = ?", new String[] {userID});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Cursor readalldatarentals()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String qry="select * from "+TABLE_RENTALSDETAILS+" order by "+WING_NO+" desc";
        Cursor cursor=db.rawQuery(qry,null);
        return  cursor;
    }


    //complain
    public Boolean checkalreadyexistcomplain(String userID) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from "+TABLE_COMPLAIN+" where "+C_USER_ID+" = ?", new String[] {userID});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Cursor readalldatacomplain()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String qry="select * from "+TABLE_COMPLAIN+" order by "+C_USER_ID+" desc";
        Cursor cursor=db.rawQuery(qry,null);
        return  cursor;
    }


    //sellhouse
    public Boolean checkalreadyexistsellhouse(String userID) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from "+TABLE_SELLHOUSE+" where "+C_USER_ID+" = ?", new String[] {userID});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Cursor readalldatasellhouse()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String qry="select * from "+TABLE_SELLHOUSE+" order by "+C_USER_ID+" desc";
        Cursor cursor=db.rawQuery(qry,null);
        return  cursor;
    }


    //Notic//
    public boolean insertDatanotic(String subject, String date, String notice){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("subject", subject);
        contentValues.put("date", date);
        contentValues.put("notice", notice);

        long result = MyDB.insert("NoticesLists",null,contentValues);
        if(result==-1)
            return false;
        else
            return true;

    }


    public Cursor readalldatanotic()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String qry="select * from NoticesLists order by date desc";
        Cursor cursor=db.rawQuery(qry,null);
        return  cursor;
    }

}






