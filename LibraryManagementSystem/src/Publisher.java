public class Publisher {
    private final String publisherId;
    private final String name;
    private final String address;
    private final String phone;

    public Publisher(String publisherId, String name, String address, String phone) {
        this.publisherId = publisherId;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherId='" + publisherId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
