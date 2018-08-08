package ca.hjtaki.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jin-tak.han on 2018-03-18.
 */






public class SimpleData implements Parcelable {

    int number;
    String message;

    public SimpleData(int number, String message) {
        this.number = number;
        this.message = message;
    }

    public SimpleData(Parcel src){
        number = src.readInt();
        message=src.readString();           //다른 생성자
        //리드로 복원

    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){
        public SimpleData createFromParcel(Parcel in){
            return new SimpleData(in);
        }
        public SimpleData[] newArray(int size){
            return new SimpleData[size]; // 배열 객체를 만듬
        }


        // 두 메소드는]'[]]'[\
        //  ㅣㅣ.==필수



    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) { // 파슬 객체를 쓰겠다 만들겠다
        dest.writeInt(number);
        dest.writeString(message);
//심플데이터가 파슬로 바꾸어준다
    }
}

// 즉 파슬은 다른 객체로 전달할때 사용된다 .
//
