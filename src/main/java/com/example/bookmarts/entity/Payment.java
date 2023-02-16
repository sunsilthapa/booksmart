package  com.example.bookmarts.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Builder
@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payments")
public class Payment {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "FullName")
    @NotEmpty
    @NotNull
    private String fullName;

    @Column(name = "CardNo", unique = true)
    @NotEmpty
    @NotNull
    private Long cardNo;

    @Column(name = "CVVcode", unique = true)
    @NotEmpty
    @NotNull
    private Long cvvNo;

    @Column(name = "BillingAddress")
    @NotEmpty
    @NotNull
    private String billingAddress;

    @Column(name = "EmailAddress")
    @Email
    private String email;


    @Column(name = "PaymentAmount")
    @NotEmpty
    @NotNull
    private String payAmount;



}
