import { AngularUiPage } from './app.po';

describe('angular-ui App', () => {
  let page: AngularUiPage;

  beforeEach(() => {
    page = new AngularUiPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
