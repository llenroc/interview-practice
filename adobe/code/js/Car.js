class Vehicle {
  constructor(name, type) {
    this.name = name;
    this, (type = type);
  }

  getName() {
    return this.name;
  }

  getType() {
    return this.type;
  }
}

class Car extends Vehicle {
  constructor(name) {
    super(name, 'Car');
  }

  getName() {
    return "It's a car:" + super.getName();
  }
}
