class DoublyLinkedList<T> {
    private Element<T> head;

    void push(T value) {
        if(head == null){
            head = new Element<>(value, null, null);
        }else{
            var elt = head;
            while (elt.next != null){
                elt = elt.next;
            }
            elt.next = new Element<>(value, elt, null);
        }
    }

    T pop() {
        var elt = head;
        while(elt.next != null){
            elt = elt.next;
        }
        var value = elt.value;
        elt = elt.prev;
        if(elt != null){
            elt.next = null;
        }else{
            head = null;
        }

        return value;
    }

    void unshift(T value) {
        if(head == null){
            this.head = new Element<>(value, null, null);
        }else{
            var newElt = new Element<>(value, null, head);
            head.prev = newElt;
            head = newElt;
        }

    }

    T shift() {
        var value = head.value;
        head = head.next;
        if(head != null){
            head.prev = null;
        }
        return value;
    }

    private static final class Element<T> {
        private final T value;
        private Element<T> prev;
        private Element<T> next;

        Element(T value, Element<T> prev, Element<T> next) {
           this.value = value;
           this.prev = prev;
           this.next = next;
        }
    }
}
