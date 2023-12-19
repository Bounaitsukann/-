package training_Project1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

//定义一个图书类，包含编号、书名、单价、库存等属性
class Book {
    //定义私有属性
    private int id;
    private String name;
    private double price;
    private int stock;

    //定义构造方法，用于创建图书对象
    public Book(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    //定义公共方法，用于获取和设置属性的值
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    //重写toString方法，用于输出图书的信息
    public String toString() {
        return "编号：" + id + "，书名：" + name + "，单价：" + price + "，库存：" + stock;
    }
}

//定义一个订单项类，包含图书对象和购买数量等属性
class OrderItem {
    //定义私有属性
    private Book book;
    private int quantity;

    //定义构造方法，用于创建订单项对象
    public OrderItem(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    //定义公共方法，用于获取和设置属性的值
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //定义一个方法，用于计算订单项的小计金额
    public double getSubtotal() {
        return book.getPrice() * quantity;
    }

    //重写toString方法，用于输出订单项的信息
    public String toString() {
        return "图书：" + book.getName() + "，数量：" + quantity + "，小计：" + getSubtotal();
    }
}

//定义一个订单类，包含订单号、订单项列表和订单总额等属性
class Order {
    //定义私有属性
    private String orderId;
    private ArrayList<OrderItem> orderItems;
    private double total;

    //定义构造方法，用于创建订单对象
    public Order(String orderId) {
        this.orderId = orderId;
        orderItems = new ArrayList<OrderItem>();
        total = 0;
    }

    //定义公共方法，用于获取和设置属性的值
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    //定义一个方法，用于向订单中添加订单项
    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        total += orderItem.getSubtotal();
    }

    //重写toString方法，用于输出订单的信息
    public String toString() {
        String result = "订单号：" + orderId + "\n";
        result += "订单明细：\n";
        for (OrderItem orderItem : orderItems) {
            result += orderItem + "\n";
        }
        result += "订单总额：" + total;
        return result;
    }
}

//定义一个测试类，用于模拟购书系统的功能
public class BookSystem {
    //定义一个静态方法，用于初始化图书信息，并返回一个图书数组
    public static Book[] initBooks() {
        //创建四个图书对象
        Book book1 = new Book(1, "Java从入门到精通", 79.8, 100);
        Book book2 = new Book(2, "数据结构与算法分析", 69.8, 50);
        Book book3 = new Book(3, "设计模式之禅", 59.8, 30);
        Book book4 = new Book(4, "深入理解Java虚拟机", 89.8, 20);
        //创建一个图书数组，用于存储图书对象
        Book[] books = new Book[4];
        //将图书对象添加到图书数组中
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        //返回图书数组
        return books;
    }

    //定义一个静态方法，用于输出所有图书的信息
    public static void showBooks(Book[] books) {
        //输出标题
        System.out.println("欢迎来到购书系统，以下是所有图书的信息：");
        //遍历图书数组，输出每本图书的信息
        for (Book book : books) {
            System.out.println(book);
        }
    }

    //定义一个静态方法，用于根据图书编号查找图书对象，并返回该对象
    public static Book findBookById(Book[] books, int id) {
        //遍历图书数组，比较每本图书的编号和输入的编号是否相等
        for (Book book : books) {
            //如果相等，返回该图书对象
            if (book.getId() == id) {
                return book;
            }
        }
        //如果没有找到，返回null
        return null;
    }

    //定义一个静态方法，用于创建一个订单对象，并返回该对象
    public static Order createOrder() {
        //创建一个订单对象，使用随机生成的字符串作为订单号
        Order order = new Order(UUID.randomUUID().toString());
        //返回订单对象
        return order;
    }

    //定义一个静态方法，用于向订单中添加订单项
    public static void addOrderItem(Order order, Book book, int quantity) {
        //创建一个订单项对象，使用图书对象和数量作为参数
        OrderItem orderItem = new OrderItem(book, quantity);
        //向订单中添加订单项
        order.addOrderItem(orderItem);
    }

    //定义一个静态方法，用于输出订单的信息
    public static void showOrder(Order order) {
        //输出订单的信息
        System.out.println("以下是您的订单信息：");
        System.out.println(order);
    }

    //定义一个主方法，用于模拟购书系统的功能
    public static void main(String[] args) {
        //初始化图书信息，得到一个图书数组
        Book[] books = initBooks();
        //输出所有图书的信息
        showBooks(books);
        //创建一个订单对象
        Order order = createOrder();
        //创建一个控制台输入对象，用于接收用户的输入
        Scanner input = new Scanner(System.in);
        //创建一个布尔变量，用于控制循环的结束
        boolean flag = true;
        //使用循环语句，实现重复购买的功能
        //使用循环语句，实现重复购买的功能
        while (flag) {
            //提示用户输入图书编号
            System.out.println("请输入您要购买的图书编号（输入0或q结束购买，输入1查看订单）：");
            //接收用户输入的图书编号
            String inputId = input.nextLine();
            //判断用户输入的图书编号是否为0或q
            if (inputId.equals("0") || inputId.equals("q")) {
                //如果为0或q，表示结束购买，退出循环
                flag = false;
        //调用showOrder方法，显示订单信息**
        showOrder(order);
            } else if (inputId.equals("5")) {
                //如果为1，表示查看订单，调用showOrder方法，显示订单信息
                showOrder(order);
                //提示用户是否要修改订单
                System.out.println("是否要修改订单？（输入y表示是，输入n表示否）");
                //接收用户输入的选择
                String inputChoice = input.nextLine();
                //判断用户输入的选择是否为y
                if (inputChoice.equals("y")) {
                    //如果为y，表示要修改订单，提示用户输入要删除的图书编号
                    System.out.println("请输入要删除的图书编号：");
                    //接收用户输入的图书编号
                    int deleteId = input.nextInt();
                    //调用deleteOrderItem方法，删除订单项
                    deleteOrderItem(order, deleteId);
                    //提示用户删除成功
                    System.out.println("已成功删除订单项！");
                    //清除缓冲区中的换行符
                    input.nextLine();
                } else {
                    //如果不为y，表示不要修改订单，继续循环
                    continue;
                }
            } else {
                //如果不为0或q或1，表示继续购买，将用户输入的图书编号转换为整数
                int id = Integer.parseInt(inputId);
                //根据图书编号查找图书对象
                Book book = findBookById(books, id);
                //判断图书对象是否为null
                if (book == null) {
                    //如果为null，表示没有找到该图书，提示用户重新输入
                    System.out.println("没有找到该图书，请重新输入！");
                } else {
                    //如果不为null，表示找到了该图书，提示用户输入购买数量
                    System.out.println("请输入您要购买的数量：");
                    //接收用户输入的购买数量
                    int quantity = input.nextInt();
                    //判断购买数量是否大于0
                    if (quantity > 0) {
                        //如果大于0，表示有效的购买数量，向订单中添加订单项
                        addOrderItem(order, book, quantity);
                        //提示用户添加成功
                        System.out.println("已成功添加到订单！");
                    } else {
                        //如果小于等于0，表示无效的购买数量，提示用户重新输入
                        System.out.println("请输入大于0的数量！");
                    }
                    //清除缓冲区中的换行符
                    input.nextLine();
                }
            }
        }
    }

    private static void deleteOrderItem(Order order, int deleteId) {
    }
}