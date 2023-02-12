package Homework2023_02_08;

import java.io.Serializable;

public class Contact implements Serializable {
    private String fn;
    private String tel;
    private String address;
    private String email;
    private String web;

    public Contact(String fn, String tel, String address, String email, String web) {
        this.fn = fn;
        this.tel = tel;
        this.address = address;
        this.email = email;
        this.web = web;
    }

    public String getFn() {
        return fn;
    }

    public String getTel() {
        return tel;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getWeb() {
        return web;
    }

    @Override
    public String toString() {
        return String.format("Contact{\n FN: %s\n TEL: %s\n ADDRESS: %s\n EMAIL: %s\n WEB: %s\n}\n", fn,tel,address,email,web);
    }
}
