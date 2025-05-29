package org.example.models;
import org.example.models.Split;

public class ExactSplit extends Split{
    public ExactSplit(User user, double amount) {
        super(user);
        this.amount = amount;
    }
}
