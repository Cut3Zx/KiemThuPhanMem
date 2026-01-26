describe('Cart and Checkout Test', () => {
  beforeEach(() => {
    cy.visit('https://www.saucedemo.com');
    cy.get('#user-name').type('standard_user');
    cy.get('#password').type('secret_sauce');
    cy.get('#login-button').click();
  });

  it('Should add, remove product and checkout', () => {
    // 1. Thêm vào giỏ hàng
    cy.get('.inventory_item').first().find('.btn_inventory').click();
    cy.get('.shopping_cart_badge').should('have.text', '1');

    // 2. Xóa khỏi giỏ hàng (Yêu cầu thêm của bài tập)
    cy.get('.btn_secondary.btn_inventory').click();
    cy.get('.shopping_cart_badge').should('not.exist');

    // 3. Quy trình thanh toán (Yêu cầu thêm)
    cy.get('.inventory_item').first().find('.btn_inventory').click();
    cy.get('.shopping_cart_link').click();
    cy.get('#checkout').click();
    cy.get('#first-name').type('John');
    cy.get('#last-name').type('Doe');
    cy.get('#postal-code').type('12345');
    cy.get('#continue').click();
    cy.url().should('include', '/checkout-step-two.html');
  });
});