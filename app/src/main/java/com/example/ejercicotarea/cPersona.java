package com.example.ejercicotarea;

import android.os.Parcelable;
import android.os.Parcel;
import java.util.ArrayList;

public class cPersona implements Parcelable {

    private String mail;
    private String nombre;
    private int edad;
    private String ciudad;
    private String estado;

    private ArrayList<cPersona> amigos;


    public cPersona(String mail, String nombre, int edad, String ciudad,String estado) {
        this.mail = mail;
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad=ciudad;
        this.estado=estado;
    }
    public cPersona(){
        this.mail="";
        this.nombre="";
        this.edad=0;
        this.ciudad="";
        this.estado="";
    }

    public String getDatos(){
        return (this.mail+" "+this.nombre+" "+String.valueOf(this.edad)+" "+this.ciudad+" "+this.estado);

    }
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public  String getCiudad() {
        return  ciudad;
    }

    public  void  setCiudad(String ciudad) {
        this.ciudad= ciudad;
    }

    public  String  getEstado() {
        return estado;
    }

    public  void  setEstado(String  estado) {
        this.estado =estado;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }



    protected cPersona(Parcel in) {
        mail = in.readString();
        nombre = in.readString();
        edad = in.readInt();
        ciudad= in.readString();
        estado = in.readString();

        if (in.readByte() == 0x01) {
            amigos = new ArrayList<cPersona>();
            in.readList(amigos, cPersona.class.getClassLoader());
        } else {
            amigos = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mail);
        dest.writeString(nombre);
        dest.writeInt(edad);
        dest.writeString(ciudad);
        dest.writeString(estado);

        if (amigos == null) {
            dest.writeByte((byte) (0x00));
        }
        else {
            dest.writeByte((byte) (0x01));
            dest.writeList(amigos);
        }
    }
    @SuppressWarnings("unused")

    public static final Parcelable.Creator<cPersona> CREATOR = new
            Parcelable.Creator<cPersona>() {
                @Override
                public cPersona createFromParcel(Parcel in) {
                    return new cPersona(in);
                }
                @Override
                public cPersona[] newArray(int size) {
                    return new cPersona[size];
                }
            };
}





