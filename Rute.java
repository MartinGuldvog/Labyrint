import java.util.ArrayList;

public abstract class Rute{

    private int rad, kolonne;
    private Labyrint lab;
    private Rute nord, syd, ost, vest;
    private boolean ubrukt = true;
    private static Lenkeliste<String> utveier = new Lenkeliste<String>();
    private static String utvei;


    public Rute(int rad, int kolonne, Labyrint l){
        this.rad = rad;
        this.kolonne = kolonne;
        this.lab = l;
    }

    public void gaa1(String s){
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";
        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            // utvei = "";
        }
        if (this.tilTegn() == '#'){
            return;
        }
        if (nord != null && nord.tilTegn() == '.' && nord.ubrukt()){
            nord.gaa1(utvei);
        }
        if (syd != null && syd.tilTegn() == '.' && syd.ubrukt()){
            syd.gaa1(utvei);
        }
        if (vest != null && vest.tilTegn() == '.' && vest.ubrukt()){
            vest.gaa1(utvei);
        }
        if (ost != null && ost.tilTegn() == '.' && ost.ubrukt()){
            ost.gaa1(utvei);
        }
        ubrukt = true;
    }
    public void gaa2(String s){
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";
        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            // utvei = "";
        }
        if (this.tilTegn() == '#'){
            return;
        }
        if (nord != null && nord.tilTegn() == '.' && nord.ubrukt()){
            nord.gaa2(utvei);
        }
        if (syd != null && syd.tilTegn() == '.' && syd.ubrukt()){
            syd.gaa2(utvei);
        }
        if (ost != null && ost.tilTegn() == '.' && ost.ubrukt()){
            ost.gaa2(utvei);
        }
        if (vest != null && vest.tilTegn() == '.' && vest.ubrukt()){
            vest.gaa2(utvei);
        }
        ubrukt = true;
    }
    public void gaa3(String s){
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";
        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            // utvei = "";
        }
        if (this.tilTegn() == '#'){
            return;
        }
        if (nord != null && nord.tilTegn() == '.' && nord.ubrukt()){
            nord.gaa3(utvei);
        }
        if (vest != null && vest.tilTegn() == '.' && vest.ubrukt()){
            vest.gaa3(utvei);
        }
        if (syd != null && syd.tilTegn() == '.' && syd.ubrukt()){
            syd.gaa3(utvei);
        }
        if (ost != null && ost.tilTegn() == '.' && ost.ubrukt()){
            ost.gaa3(utvei);
        }
        ubrukt = true;
    }
    public void gaa4(String s){
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";
        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            // utvei = "";
        }
        if (this.tilTegn() == '#'){
            return;
        }
        if (nord != null && nord.tilTegn() == '.' && nord.ubrukt()){
            nord.gaa4(utvei);
        }
        if (vest != null && vest.tilTegn() == '.' && vest.ubrukt()){
            vest.gaa4(utvei);
        }
        if (ost != null && ost.tilTegn() == '.' && ost.ubrukt()){
            ost.gaa4(utvei);
        }
        if (syd != null && syd.tilTegn() == '.' && syd.ubrukt()){
            syd.gaa4(utvei);
        }
        ubrukt = true;
    }
    public void gaa5(String s){
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";
        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            // utvei = "";
        }
        if (this.tilTegn() == '#'){
            return;
        }
        if (nord != null && nord.tilTegn() == '.' && nord.ubrukt()){
            nord.gaa5(utvei);
        }
        if (ost != null && ost.tilTegn() == '.' && ost.ubrukt()){
            ost.gaa5(utvei);
        }
        if (syd != null && syd.tilTegn() == '.' && syd.ubrukt()){
            syd.gaa5(utvei);
        }
        if (vest != null && vest.tilTegn() == '.' && vest.ubrukt()){
            vest.gaa5(utvei);
        }
        ubrukt = true;
    }
    public void gaa6(String s){
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";
        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            // utvei = "";
        }
        if (this.tilTegn() == '#'){
            return;
        }
        if (nord != null && nord.tilTegn() == '.' && nord.ubrukt()){
            nord.gaa6(utvei);
        }
        if (ost != null && ost.tilTegn() == '.' && ost.ubrukt()){
            ost.gaa6(utvei);
        }
        if (vest != null && vest.tilTegn() == '.' && vest.ubrukt()){
            vest.gaa6(utvei);
        }
        if (syd != null && syd.tilTegn() == '.' && syd.ubrukt()){
            syd.gaa6(utvei);
        }
        ubrukt = true;
    }
    public void gaa7(String s){
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";
        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            // utvei = "";
        }
        if (this.tilTegn() == '#'){
            return;
        }
        if (syd != null && syd.tilTegn() == '.' && syd.ubrukt()){
            syd.gaa7(utvei);
        }
        if (nord != null && nord.tilTegn() == '.' && nord.ubrukt()){
            nord.gaa7(utvei);
        }
        if (vest != null && vest.tilTegn() == '.' && vest.ubrukt()){
            vest.gaa7(utvei);
        }
        if (ost != null && ost.tilTegn() == '.' && ost.ubrukt()){
            ost.gaa7(utvei);
        }
        ubrukt = true;
    }
    public void gaa8(String s){
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";
        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            // utvei = "";
        }
        if (this.tilTegn() == '#'){
            return;
        }
        if (syd != null && syd.tilTegn() == '.' && syd.ubrukt()){
            syd.gaa8(utvei);
        }
        if (nord != null && nord.tilTegn() == '.' && nord.ubrukt()){
            nord.gaa8(utvei);
        }
        if (ost != null && ost.tilTegn() == '.' && ost.ubrukt()){
            ost.gaa8(utvei);
        }
        if (vest != null && vest.tilTegn() == '.' && vest.ubrukt()){
            vest.gaa8(utvei);
        }
        ubrukt = true;
    }
    public void gaa9(String s){
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";
        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            // utvei = "";
        }
        if (this.tilTegn() == '#'){
            return;
        }
        if (syd != null && syd.tilTegn() == '.' && syd.ubrukt()){
            syd.gaa9(utvei);
        }
        if (vest != null && vest.tilTegn() == '.' && vest.ubrukt()){
            vest.gaa9(utvei);
        }
        if (nord != null && nord.tilTegn() == '.' && nord.ubrukt()){
            nord.gaa9(utvei);
        }
        if (ost != null && ost.tilTegn() == '.' && ost.ubrukt()){
            ost.gaa9(utvei);
        }
        ubrukt = true;
    }
    public void gaa10(String s){
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";
        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            // utvei = "";
        }
        if (this.tilTegn() == '#'){
            return;
        }
        if (syd != null && syd.tilTegn() == '.' && syd.ubrukt()){
            syd.gaa10(utvei);
        }
        if (vest != null && vest.tilTegn() == '.' && vest.ubrukt()){
            vest.gaa10(utvei);
        }
        if (ost != null && ost.tilTegn() == '.' && ost.ubrukt()){
            ost.gaa10(utvei);
        }
        if (nord != null && nord.tilTegn() == '.' && nord.ubrukt()){
            nord.gaa10(utvei);
        }
        ubrukt = true;
    }
    public void gaa11(String s){
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";
        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            // utvei = "";
        }
        if (this.tilTegn() == '#'){
            return;
        }
        if (syd != null && syd.tilTegn() == '.' && syd.ubrukt()){
            syd.gaa11(utvei);
        }
        if (ost != null && ost.tilTegn() == '.' && ost.ubrukt()){
            ost.gaa11(utvei);
        }
        if (nord != null && nord.tilTegn() == '.' && nord.ubrukt()){
            nord.gaa11(utvei);
        }
        if (vest != null && vest.tilTegn() == '.' && vest.ubrukt()){
            vest.gaa11(utvei);
        }
        ubrukt = true;
    }
    public void gaa12(String s){
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";
        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            // utvei = "";
        }
        if (this.tilTegn() == '#'){
            return;
        }
        if (syd != null && syd.tilTegn() == '.' && syd.ubrukt()){
            syd.gaa12(utvei);
        }
        if (ost != null && ost.tilTegn() == '.' && ost.ubrukt()){
            ost.gaa12(utvei);
        }
        if (vest != null && vest.tilTegn() == '.' && vest.ubrukt()){
            vest.gaa12(utvei);
        }
        if (nord != null && nord.tilTegn() == '.' && nord.ubrukt()){
            nord.gaa12(utvei);
        }
        ubrukt = true;
    }
    public void gaa13(String s){
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";
        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            // utvei = "";
        }
        if (this.tilTegn() == '#'){
            return;
        }
        if (vest != null && vest.tilTegn() == '.' && vest.ubrukt()){
            vest.gaa13(utvei);
        }
        if (nord != null && nord.tilTegn() == '.' && nord.ubrukt()){
            nord.gaa13(utvei);
        }
        if (syd != null && syd.tilTegn() == '.' && syd.ubrukt()){
            syd.gaa13(utvei);
        }
        if (ost != null && ost.tilTegn() == '.' && ost.ubrukt()){
            ost.gaa13(utvei);
        }
        ubrukt = true;
    }
    public void gaa14(String s){
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";
        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            // utvei = "";
        }
        if (this.tilTegn() == '#'){
            return;
        }
        if (vest != null && vest.tilTegn() == '.' && vest.ubrukt()){
            vest.gaa14(utvei);
        }
        if (nord != null && nord.tilTegn() == '.' && nord.ubrukt()){
            nord.gaa14(utvei);
        }
        if (ost != null && ost.tilTegn() == '.' && ost.ubrukt()){
            ost.gaa14(utvei);
        }
        if (syd != null && syd.tilTegn() == '.' && syd.ubrukt()){
            syd.gaa14(utvei);
        }
        ubrukt = true;
    }
    public void gaa15(String s){
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";
        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            // utvei = "";
        }
        if (this.tilTegn() == '#'){
            return;
        }
        if (vest != null && vest.tilTegn() == '.' && vest.ubrukt()){
            vest.gaa15(utvei);
        }
        if (syd != null && syd.tilTegn() == '.' && syd.ubrukt()){
            syd.gaa15(utvei);
        }
        if (nord != null && nord.tilTegn() == '.' && nord.ubrukt()){
            nord.gaa15(utvei);
        }
        if (ost != null && ost.tilTegn() == '.' && ost.ubrukt()){
            ost.gaa15(utvei);
        }
        ubrukt = true;
    }
    public void gaa16(String s){
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";
        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            // utvei = "";
        }
        if (this.tilTegn() == '#'){
            return;
        }
        if (vest != null && vest.tilTegn() == '.' && vest.ubrukt()){
            vest.gaa16(utvei);
        }
        if (syd != null && syd.tilTegn() == '.' && syd.ubrukt()){
            syd.gaa16(utvei);
        }
        if (ost != null && ost.tilTegn() == '.' && ost.ubrukt()){
            ost.gaa16(utvei);
        }
        if (nord != null && nord.tilTegn() == '.' && nord.ubrukt()){
            nord.gaa16(utvei);
        }
        ubrukt = true;
    }
    public void gaa17(String s){
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";
        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            // utvei = "";
        }
        if (this.tilTegn() == '#'){
            return;
        }
        if (vest != null && vest.tilTegn() == '.' && vest.ubrukt()){
            vest.gaa17(utvei);
        }
        if (ost != null && ost.tilTegn() == '.' && ost.ubrukt()){
            ost.gaa17(utvei);
        }
        if (nord != null && nord.tilTegn() == '.' && nord.ubrukt()){
            nord.gaa17(utvei);
        }
        if (syd != null && syd.tilTegn() == '.' && syd.ubrukt()){
            syd.gaa17(utvei);
        }
        ubrukt = true;
    }
    public void gaa18(String s){
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";
        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            // utvei = "";
        }
        if (this.tilTegn() == '#'){
            return;
        }
        if (vest != null && vest.tilTegn() == '.' && vest.ubrukt()){
            vest.gaa18(utvei);
        }
        if (ost != null && ost.tilTegn() == '.' && ost.ubrukt()){
            ost.gaa18(utvei);
        }
        if (syd != null && syd.tilTegn() == '.' && syd.ubrukt()){
            syd.gaa18(utvei);
        }
        if (nord != null && nord.tilTegn() == '.' && nord.ubrukt()){
            nord.gaa18(utvei);
        }
        ubrukt = true;
    }
    public void gaa19(String s){
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";
        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            // utvei = "";
        }
        if (this.tilTegn() == '#'){
            return;
        }
        if (ost != null && ost.tilTegn() == '.' && ost.ubrukt()){
            ost.gaa19(utvei);
        }
        if (nord != null && nord.tilTegn() == '.' && nord.ubrukt()){
            nord.gaa19(utvei);
        }
        if (syd != null && syd.tilTegn() == '.' && syd.ubrukt()){
            syd.gaa19(utvei);
        }
        if (vest != null && vest.tilTegn() == '.' && vest.ubrukt()){
            vest.gaa19(utvei);
        }
        ubrukt = true;
    }
    public void gaa20(String s){
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";
        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            // utvei = "";
        }
        if (this.tilTegn() == '#'){
            return;
        }
        if (ost != null && ost.tilTegn() == '.' && ost.ubrukt()){
            ost.gaa20(utvei);
        }
        if (syd != null && syd.tilTegn() == '.' && syd.ubrukt()){
            syd.gaa20(utvei);
        }
        if (nord != null && nord.tilTegn() == '.' && nord.ubrukt()){
            nord.gaa20(utvei);
        }
        if (vest != null && vest.tilTegn() == '.' && vest.ubrukt()){
            vest.gaa20(utvei);
        }
        ubrukt = true;
    }
    public void gaa21(String s){
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";
        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            // utvei = "";
        }
        if (this.tilTegn() == '#'){
            return;
        }
        if (ost != null && ost.tilTegn() == '.' && ost.ubrukt()){
            ost.gaa21(utvei);
        }
        if (syd != null && syd.tilTegn() == '.' && syd.ubrukt()){
            syd.gaa21(utvei);
        }
        if (vest != null && vest.tilTegn() == '.' && vest.ubrukt()){
            vest.gaa21(utvei);
        }
        if (nord != null && nord.tilTegn() == '.' && nord.ubrukt()){
            nord.gaa21(utvei);
        }
        ubrukt = true;
    }
    public void gaa22(String s){
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";
        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            // utvei = "";
        }
        if (this.tilTegn() == '#'){
            return;
        }
        if (ost != null && ost.tilTegn() == '.' && ost.ubrukt()){
            ost.gaa22(utvei);
        }
        if (vest != null && vest.tilTegn() == '.' && vest.ubrukt()){
            vest.gaa22(utvei);
        }
        if (nord != null && nord.tilTegn() == '.' && nord.ubrukt()){
            nord.gaa22(utvei);
        }
        if (syd != null && syd.tilTegn() == '.' && syd.ubrukt()){
            syd.gaa22(utvei);
        }
        ubrukt = true;
    }
    public void gaa23(String s){
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";
        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            // utvei = "";
        }
        if (this.tilTegn() == '#'){
            return;
        }
        if (ost != null && ost.tilTegn() == '.' && ost.ubrukt()){
            ost.gaa23(utvei);
        }
        if (vest != null && vest.tilTegn() == '.' && vest.ubrukt()){
            vest.gaa23(utvei);
        }
        if (syd != null && syd.tilTegn() == '.' && syd.ubrukt()){
            syd.gaa23(utvei);
        }
        if (nord != null && nord.tilTegn() == '.' && nord.ubrukt()){
            nord.gaa23(utvei);
        }
        ubrukt = true;
    }
    public void gaa24(String s){
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";
        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            // utvei = "";
        }
        if (this.tilTegn() == '#'){
            return;
        }
        if (ost != null && ost.tilTegn() == '.' && ost.ubrukt()){
            ost.gaa24(utvei);
        }
        if (nord != null && nord.tilTegn() == '.' && nord.ubrukt()){
            nord.gaa24(utvei);
        }
        if (vest != null && vest.tilTegn() == '.' && vest.ubrukt()){
            vest.gaa24(utvei);
        }
        if (syd != null && syd.tilTegn() == '.' && syd.ubrukt()){
            syd.gaa24(utvei);
        }
        ubrukt = true;
    }

    public void finnUtvei1(){
        this.gaa1(utvei);
    }
    public void finnUtvei2(){
        this.gaa2(utvei);
    }
    public void finnUtvei3(){
        this.gaa3(utvei);
    }
    public void finnUtvei4(){
        this.gaa4(utvei);
    }
    public void finnUtvei5(){
        this.gaa5(utvei);
    }
    public void finnUtvei6(){
        this.gaa6(utvei);
    }
    public void finnUtvei7(){
        this.gaa7(utvei);
    }
    public void finnUtvei8(){
        this.gaa8(utvei);
    }
    public void finnUtvei9(){
        this.gaa9(utvei);
    }
    public void finnUtvei10(){
        this.gaa10(utvei);
    }
    public void finnUtvei11(){
        this.gaa11(utvei);
    }
    public void finnUtvei12(){
        this.gaa12(utvei);
    }
    public void finnUtvei13(){
        this.gaa13(utvei);
    }
    public void finnUtvei14(){
        this.gaa14(utvei);
    }
    public void finnUtvei15(){
        this.gaa15(utvei);
    }
    public void finnUtvei16(){
        this.gaa16(utvei);
    }
    public void finnUtvei17(){
        this.gaa17(utvei);
    }
    public void finnUtvei18(){
        this.gaa18(utvei);
    }
    public void finnUtvei19(){
        this.gaa19(utvei);
    }
    public void finnUtvei20(){
        this.gaa20(utvei);
    }
    public void finnUtvei21(){
        this.gaa21(utvei);
    }
    public void finnUtvei22(){
        this.gaa22(utvei);
    }
    public void finnUtvei23(){
        this.gaa23(utvei);
    }
    public void finnUtvei24(){
        this.gaa24(utvei);
    }

    public Lenkeliste<String> hentUtveier(){
        return this.utveier;
    }

    public void nullStill(){
        this.ubrukt = true;
        this.utvei = new String();
        // this.utveier = new Lenkeliste<String>();
    }

    public void nullStillHelt(){
        this.ubrukt = true;
        this.utvei = new String();
        this.utveier = new Lenkeliste<String>();
    }

    public int hentRad(){
        return this.rad;
    }
    public int hentKolonne(){
        return this.kolonne;
    }


    public boolean ubrukt(){
        return this.ubrukt;
    }
    public void leggTilNord(Rute nabo){
        this.nord = nabo;
    }
    public void leggTilSyd(Rute nabo){
        this.syd = nabo;
    }
    public void leggTilOst(Rute nabo){
        this.ost = nabo;
    }
    public void leggTilVest(Rute nabo){
        this.vest = nabo;
    }

    public Rute hentNaboNord(){
        return this.nord;
    }
    public Rute hentNaboSyd(){
        return this.syd;
    }
    public Rute hentNaboOst(){
        return this.ost;
    }
    public Rute hentNaboVest(){
        return this.vest;
    }

    public abstract char tilTegn();

    public boolean erAapning(){
        return false;
    }
}
