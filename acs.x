struct response{
		int  code;
		string body <>;
};

program FTP{	
	version V1{	
		response read_file(string file_name) =1;
		response write(string file_name,string content_file) =2;
		response delete(string file_name) =3;
		response list(string dire_name) =4; 
		
	}=1;
}=0x24345678;
