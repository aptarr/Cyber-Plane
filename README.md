# FP-PBO-2022
Apta Rasendriya Wijaya - 5025211139

Game pesawat melawan alien, dimana pesawat harus dapat mengeliminasi pesawat musuh sehingga terhindar dari tabrakan karena jika tertabrak maka game akan selesai, ide ini hampir sama SPACE INVADER pada https://zetcode.com/javagames/ tetapi bisa digerakkan secara vertikal maupun horizontal. Untuk cara memain kan game semua menggunakan input keyboard seperti W untuk kearah atas, A untuk kearah kiri, S untuk kearah bawah, D untuk kearah kanan, SPACE untuk menembak, dan ESC untuk pause game. Selain itu, musuh keluar dari arah horizontal bagian kanan dan tidak menyerang sedangkan pesawat kita dapat menembak. Lalu terdapat point untung menghitung berapa banyak pesawat yang telah di hancurkan berserta highscore yang pernah dicapai.

![image](https://user-images.githubusercontent.com/116022017/206915405-9405dbf7-6121-4740-b2d0-6172c2be588e.png)

![image](https://user-images.githubusercontent.com/116022017/206915446-1b3740eb-f56d-4751-beef-e08205099cd9.png)

![image](https://user-images.githubusercontent.com/116022017/206915430-60911cef-29e6-4b88-90a6-34191c53daf2.png)

![image](https://user-images.githubusercontent.com/116022017/206915470-e6115c47-a020-4f02-b257-475e95febe12.png)

REFRENSI

https://www.youtube.com/watch?v=6_N8QZ47toY&list=PL4rzdwizLaxYmltJQRjq18a9gsSyEQQ-0

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
8. 
Folder : State

File : Playing.java

@Override
public void draw(Graphics g) {

    ...
    
    player.render(g);
    
    ...
}

//GameObject
public void render(Graphics g){

    g.fillRect((int) getX(), (int) getY(), 100, 100);
}

//Player
@Override
public void render(Graphics g){

    g.drawImage(Ani1[aniIndex], (int) getX(), (int) getY(), Sifat.PLAYER_WIDTH, Sifat.PLAYER_WIDTH, null);
}

8. ArrayList

Folder : State

File : Playing.java

public ArrayList<EntityA> EntityA;
  
public LinkedList<EntityB> EntityB;

9. Exception Handling

Folder : Object

File : Player.java
  


10. GUI

Folder : Object

File : Player.java

11. Interface

Folder : Object

File : Player.java

12. Abstract Class

Folder : Object

File : Player.java

13. Generics

Folder : Object

File : Player.java

14. Collection

Folder : Object

File : Player.java

15. Input Output

Folder : Object

File : Player.java

16. Enum

Folder : Object

File : Player.java






