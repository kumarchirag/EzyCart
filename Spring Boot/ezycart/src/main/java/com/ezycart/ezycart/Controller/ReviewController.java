package com.ezycart.ezycart.Controller;

import com.ezycart.ezycart.Entities.Review;
import com.ezycart.ezycart.Entities.User;
import com.ezycart.ezycart.Exception.ProductException;
import com.ezycart.ezycart.Exception.UserException;
import com.ezycart.ezycart.Request.ReviewRequest;
import com.ezycart.ezycart.Service.ReviewService;
import com.ezycart.ezycart.Service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

  @Autowired
  private ReviewService reviewService;

  @Autowired
  private UserService userService;

  @PostMapping("/create")
  public ResponseEntity<Review> createReviewHandler(
    @RequestBody ReviewRequest req,
    @RequestHeader("Authorization") String jwt
  ) throws UserException, ProductException {
    User user = userService.findUserProfileByJwt(jwt);
    Review review = reviewService.createReview(req, user);

    return new ResponseEntity<Review>(review, HttpStatus.ACCEPTED);
  }

  @GetMapping("/product/{productId}")
  public ResponseEntity<List<Review>> getProductsReviewHandler(
    @PathVariable Long productId
  ) {
    List<Review> reviews = reviewService.getAllProductReviews(productId);
    return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
  }
}
