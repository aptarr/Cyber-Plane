# FP-PBO-2022
Apta Rasendriya Wijaya - 5025211139

Game pesawat melawan alien, dimana pesawat harus dapat mengeliminasi pesawat musuh sehingga terhindar dari tabrakan karena jika tertabrak maka game akan selesai, ide ini hampir sama SPACE INVADER pada https://zetcode.com/javagames/ tetapi bisa digerakkan secara vertikal maupun horizontal. Untuk cara memain kan game semua menggunakan input keyboard seperti W untuk kearah atas, A untuk kearah kiri, S untuk kearah bawah, D untuk kearah kanan, SPACE untuk menembak, dan ESC untuk pause game. Selain itu, musuh keluar dari arah horizontal bagian kanan dan tidak menyerang sedangkan pesawat kita dapat menembak. Lalu terdapat point untung menghitung berapa banyak pesawat yang telah di hancurkan berserta highscore yang pernah dicapai.

![image](https://user-images.githubusercontent.com/116022017/206915405-9405dbf7-6121-4740-b2d0-6172c2be588e.png)

![image](https://user-images.githubusercontent.com/116022017/206915446-1b3740eb-f56d-4751-beef-e08205099cd9.png)

![image](https://user-images.githubusercontent.com/116022017/206915430-60911cef-29e6-4b88-90a6-34191c53daf2.png)

![image](https://user-images.githubusercontent.com/116022017/206915470-e6115c47-a020-4f02-b257-475e95febe12.png)

REFRENSI

https://www.youtube.com/watch?v=6_N8QZ47toY&list=PL4rzdwizLaxYmltJQRjq18a9gsSyEQQ-0

PRESENTASI

https://youtu.be/HtH58N9XQ6g

PENERAPAN OOP

1. Casting/Conversion

Folder : Object

File : Player.java

@Override
public void render(Graphics g){

    g.drawImage(Ani1[aniIndex], (int) getX(), (int) getY(), Sifat.PLAYER_WIDTH, Sifat.PLAYER_WIDTH, null);
}

2. Constructor

Folder : Object

File : Player.java

public Player(double x, double y, Game game, Controller controller, Playing playing){

    super(x, y);
    this.game = game;
    this.controller = controller;
    this.playing = playing;
    loadAnimation();
}

3. Overloading

Folder : State

File : Playing.java

public void setSCORE(int aSCORE) {

    this.SCORE = aSCORE;
}

public int getBackPos1() {

    return backPos1;
}

4. Overriding

Folder : Object

File : Player.java

@Override
public void render(Graphics g){

    g.drawImage(Ani1[aniIndex], (int) getX(), (int) getY(), Sifat.PLAYER_WIDTH, Sifat.PLAYER_WIDTH, null);
}

5. Encapsulation

Folder : Object

File : Player.java

public boolean isLeft() {

    return left;
}

public void setLeft(boolean left) {

    this.left = left;
}

6. Inheritance

Folder : Object

File : Player.java

public class Player extends GameObject implements EntityA{

    ...
}

7. Polymorphism
Folder : State

File : Playing.java

@Override
public void draw(Graphics g) {

    ...
    
    GameObject[] Kplayer = {player};
    Kplayer[0].render(g);
    
    ...
}

8. ArrayList

Folder : State

File : Playing.java

public ArrayList<EntityA> EntityA;
  
public LinkedList<EntityB> EntityB;

9. Exception Handling

Folder : Object

File : Load.java
  
try {
    
    image = ImageIO.read(I1);
} catch (IOException ex) {
    
    ex.printStackTrace();
}finally{
    try{
        I1.close();
    }catch (IOException e) {
        e.printStackTrace();
    }
}

10. GUI

Folder : State

File : Playing.java
    
private BufferedImage BGS1;
private BufferedImage BGS2;
private BufferedImage BGS3;
private BufferedImage BGS4;

11. Interface

Folder : Main

File : Sifat.java
    
public interface Sifat {
    
    int BOARD_WIDTH = 1280;
    int BOARD_HEIGHT = 672;

    int BULLET_HEIGHT = 30;
    int BULLET_WIDTH = 50;

    int ALIEN_HEIGHT = 80;
    int ALIEN_WIDTH = 80;
    int ALIEN_RECTANGLE = 40;
    int ALIEN_INIT_X = 150;
    int ALIEN_INIT_Y = 5;
    
    int PLAYER_WIDTH = 110;
    int PLAYER_HEIGHT = 100;
    int PLAYER_SIZE = 58;
}

12. Abstract Class

Folder : Object

File : GameObject.java
    
public abstract class GameObject {
    
    protected double x, y;
//    public Game game;
    
    public GameObject(double x, double y){
    
        this.x = x;
        this.y = y;
//        this.game = game;
    
    }
    
    public void render(Graphics g){
        g.fillRect((int) getX(), (int) getY(), 100, 100);
    }

    public Rectangle getBounds(int width, int height){
        return new Rectangle((int) x, (int) y, width, height);
    }
    
    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

13. Generics

Folder : State

File : Playing.java

public void readFile() throws IOException{
    
    FileReader fileInput;
    BufferedReader bufferInput;
    Generic<String> stringGen = new Generic<String>();

    try{
        fileInput = new FileReader("Database.txt");
        bufferInput = new BufferedReader(fileInput);
    }catch(Exception e){
        System.err.print("Database Tidak ada");
        return;
    }

    stringGen.setValue(bufferInput.readLine());

    while (stringGen.getValue() != null){
//            System.out.println(Integer.parseInt(data));
        if(Integer.parseInt(stringGen.getValue()) > HIGHSCORE)
            setHIGHSCORE(Integer.parseInt(stringGen.getValue()));
//            System.out.println("ini hightscore " + HIGHSCORE);
            stringGen.setValue(bufferInput.readLine());
    }

    fileInput.close();
}
    
14. Collection

Folder : State

File : Playing.java
    
public ArrayList<EntityA> EntityA;
  
public LinkedList<EntityB> EntityB;    

15. Input Output

Folder : State

File : Playing.java dan GameOver.java

public void readFile() throws IOException{
    
    FileReader fileInput;
    BufferedReader bufferInput;
    Generic<String> stringGen = new Generic<String>();

    try{
        fileInput = new FileReader("Database.txt");
        bufferInput = new BufferedReader(fileInput);
    }catch(Exception e){
        System.err.print("Database Tidak ada");
        return;
    }

    stringGen.setValue(bufferInput.readLine());

    while (stringGen.getValue() != null){
//            System.out.println(Integer.parseInt(data));
        if(Integer.parseInt(stringGen.getValue()) > HIGHSCORE)
            setHIGHSCORE(Integer.parseInt(stringGen.getValue()));
//            System.out.println("ini hightscore " + HIGHSCORE);
            stringGen.setValue(bufferInput.readLine());
    }

    fileInput.close();
}
    
public void writeFile() throws IOException{
    
    FileWriter fileOutput = new FileWriter("Database.txt");
    BufferedWriter bufferOutput = new BufferedWriter(fileOutput);

    String data = Integer.toString(playing.getSCORE());
    bufferOutput.write(data);
    bufferOutput.newLine();
    bufferOutput.flush();
//        System.out.println(data);

    fileOutput.close();
}   
    
16. Enum
    
Folder : State

File : Gamestate.java

public enum Gamestate {
    
    MENU, PLAYING, DEAD, QUIT;
    
    public static Gamestate state = MENU;
}
