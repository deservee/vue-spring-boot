var store = {
    state: {
      url: 'http://localhost:8080/hrm/'
    },
    setStateAction (newValue) {
      this.state.url = newValue
     },
    clearStateAction () {
       this.state.url = ''
     }
  }
