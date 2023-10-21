package org.curso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GuestService {
    private final List<Guest> checkinList = new ArrayList<>(100);

    public static List<Guest> filterByFavoriteRoom(@NotNull List<Guest> guests, Room room){
        return guests.stream()
                .filter(guest -> guest.getPreferredRooms().indexOf(room) == 0)
                .collect(Collectors.toList());
    }

    public void checkIn(Guest guest){
        if(guest.isLoyalityProgramMember() && !this.checkinList.isEmpty()){
            int i=0;
            for(;i<checkinList.size();i++){
                if(checkinList.get(i).isLoyalityProgramMember())
                    continue;
                break;
            }
            this.checkinList.add(i, guest);
        }else{
            this.checkinList.add(guest);
        }
    }

    public void swapPosition(Guest guest1, Guest guest2){
        int pos1 = this.checkinList.indexOf(guest1);
        int pos2 = this.checkinList.indexOf(guest2);
        if(pos1 !=-1 && pos2 != -1){
            this.checkinList.set(pos1, guest2);
            this.checkinList.set(pos2, guest1);
        }
    }
}
