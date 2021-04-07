package com.epam.first.model.entity;

public class User {
    private long userId;
    private String username;
    private String password;
//    private Role role;
    private String email;
    private String phone;
    private double averageRating;

    public User() {
    }

    public User(long userId, String username, String password,
//                Role role,
                String email, String phone, double averageRating) {
        this.userId = userId;
        this.username = username;
        this.password = password;
//        this.role = role;
        this.email = email;
        this.phone = phone;
        this.averageRating = averageRating;
    }
    public User(long userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

     public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (Double.compare(user.averageRating, averageRating) != 0) return false;
        if (!username.equals(user.username)) return false;
        if (!password.equals(user.password)) return false;
//        if (role != user.role) return false;
        if (!email.equals(user.email)) return false;
        return phone.equals(user.phone);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + username.hashCode();
        result = 31 * result + password.hashCode();
//        result = 31 * result + role.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + phone.hashCode();
        temp = Double.doubleToLongBits(averageRating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(userId);
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
//        sb.append(", role=").append(role);
        sb.append(", email='").append(email).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", averageRating=").append(averageRating);
        sb.append('}');
        return sb.toString();
    }
}
