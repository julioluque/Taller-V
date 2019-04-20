package mvc.tp.model;

	public class Person {

		private int userid;
		private String firstName;
		private String lastName;	
		private String email;
		private int tipoDoc;
		private String nroDoc;
		private String telefono;
		
		
		//userId
		public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		
		//firstName
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		
		//lastName
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		//email
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		//tipoDoc
		public int getTipDoc(){
			return tipoDoc;
		}
		
		public void setTipoDoc(int tipoDoc){
			this.tipoDoc = tipoDoc;
		}
		
		//nroDoc
		public String getNroDoc(){
			return nroDoc;
		}
		
		public void setNroDoc(String nroDoc){
			this.nroDoc= nroDoc;
		}
		
		//telefono
		public String getTelefono(){
			return telefono;
		}
		
		public void setTelefono(String telefono){
			this.telefono = telefono;
		}
		
		@Override
		public String toString() {
			return "User [userid=" + userid + ", firstName=" + firstName
					+ ", lastName=" + lastName + ", email=" + email + ", tipoDoc=" + tipoDoc 
					+ ", nroDoc=" + nroDoc + "]";
		}
		
		
	}