import java.util.ArrayList;

public class TodoList2 {
    ArrayList<String> list = new ArrayList<>();

    public boolean numberIndex(int index) {
        if (index >= 0 && index < list.size()) {
            return true;
        }
        return false;
    }

    public void addNewDeal(Integer index, String newDeal) {
        if(index == null) {
            this.list.add(newDeal);
        } else {
            this.list.add(index, newDeal);
        }
    }

    public void editDeal(int index, String newDeal) {
        if (numberIndex(index)) {
            this.list.set(index, newDeal);
        }
    }

    public void deleteDeal(int index) {
        if (numberIndex(index)) {
            this.list.remove(index);
        }
    }

    public void listAllDeal() {
        for (int i = 0; i < this.list.size(); i++) {
            String allDeal = i + " - " + list.get(i).trim();
            System.out.println(allDeal);
        }
    }
   }
