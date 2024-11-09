public class W7_5Employee {
    
    static class Employee {
        // Protected fields
        protected int id;
        protected String name;
        protected double salary;
        protected Address address; // เพิ่ม field address

        // Constructor (ถ้าจำเป็น)
        public Employee(int id, String name, double salary, Address address) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.address = address;
        }

        // Getter และ Setter
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        // ฟังก์ชันแสดงรายละเอียดพนักงาน
        public String getDetail() {
            return "ID: " + id + ", Name: " + name + ", Salary: " + salary + ", Address: " + address.getAddressInfo();
        }
    }

    static class Address {
        // Protected fields
        protected String street;
        protected String city;

        // Constructor
        public Address(String street, String city) {
            this.street = street;
            this.city = city;
        }

        // Getter และ Setter
        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        // ฟังก์ชันแสดงรายละเอียดที่อยู่
        public String getAddressInfo() {
            return street + ", " + city;
        }
    }

    static class Manager extends Employee {
        // Field สำหรับ Manager
        protected String parkingNo;

        // Constructor
        public Manager(int id, String name, double salary, Address address, String parkingNo) {
            super(id, name, salary, address);
            this.parkingNo = parkingNo;
        }

        // Getter และ Setter สำหรับ parkingNo
        public String getParkingNo() {
            return parkingNo;
        }

        public void setParkingNo(String parkingNo) {
            this.parkingNo = parkingNo;
        }

        // Override ฟังก์ชันแสดงรายละเอียด
        @Override
        public String getDetail() {
            return super.getDetail() + ", Parking No: " + parkingNo;
        }
    }

    public static void main(String[] args) {
        // สร้างที่อยู่
        Address address = new Address("123 Main St", "Bangkok");

        // สร้างพนักงาน
        Employee emp = new Employee(1, "John Doe", 50000, address);
        System.out.println(emp.getDetail());

        // สร้างผู้จัดการ
        Manager mgr = new Manager(2, "Jane Smith", 75000, address, "P123");
        System.out.println(mgr.getDetail());
    }
}
