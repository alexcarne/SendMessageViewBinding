package com.example.sendmessageviewbinding.model.data;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Objects;
/**
*Clase encarga instanciar un mensaje y de parcelarlo para enviarlo a traves de un intent a otras  views
 */
public class Message implements Serializable, Parcelable {
    public static  final String KEY = "message";
    private  int id;
    private  String context;
    private  Person sender;
    private  Person recipient;

    public Message(String context, Person sender, Person recipient, int id) {
        this.context = context;
        this.sender = sender;
        this.recipient = recipient;
        this.id=id;
    }

    protected Message(Parcel in) {
        id = in.readInt();
        context = in.readString();
        sender = in.readParcelable(Person.class.getClassLoader());
        recipient = in.readParcelable(Person.class.getClassLoader());
    }

    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    //region Metodos set y get
    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getSender() {
        return sender;
    }

    public void setSender(Person sender) {
        this.sender = sender;
    }

    public Person getRecipient() {
        return recipient;
    }

    public void setRecipient(Person recipient) {
        this.recipient = recipient;
    }
    //endregion


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", context='" + context + '\'' +
                ", sender=" + sender +
                ", recipient=" + recipient +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(context);
        dest.writeParcelable(sender, flags);
        dest.writeParcelable(recipient, flags);
    }
}
