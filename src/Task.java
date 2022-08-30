import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Task {


    interface Structure {
        // zwraca dowolny element o podanym kolorze
        Optional findBlockByColor(String color);

        // zwraca wszystkie elementy z danego materiału
        List findBlocksByMaterial(String material);

        //zwraca liczbę wszystkich elementów tworzących strukturę
        int count();
    }

    public class Wall implements Structure {
        private List<CompositeBlock> blocks;

        @Override
        public Optional findBlockByColor(String color) {

            CompositeBlock result = null;

            for (CompositeBlock b : this.blocks){
                if(b.getColor().equals(color)){
                     result = b;
                }
            }
            return Optional.of(result);
        }

        @Override
        public List findBlocksByMaterial(String material) {
            List<CompositeBlock> resultList = new ArrayList<>();


            for (CompositeBlock b : this.blocks){
                if(b.getMaterial().equals(material)){
                    resultList.add(b);
                }
            }

            return resultList;

        }

        @Override
        public int count() {
            int counter = 0;

            for (CompositeBlock c : this.blocks){
                for (Block b : c.getBlocks()){
                    counter++;
                }
            }
            return counter;
        }
    }

    interface Block {
        String getColor();
        String getMaterial();
    }

    interface CompositeBlock extends Block {
        List<Block> getBlocks();
    }

}
