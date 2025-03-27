import http from "k6/http";
import { check } from "k6";

const BASE_URL = __ENV.BASE_URL || "http://localhost:3333";

export const options = {
  stages: [
    {duration: '30s', target: 125},
    {duration: '30s', target: 125},
    {duration: '30s', target: 0},
  ],
  thresholds: {
    http_req_duration: ['p(95)<1100'],
    http_req_failed: ['rate<0.01'],
    "checks": ["rate>0.98"]
  }
};

export default function () {
  let restrictions = {
    maxCaloriesPerSlice: 500,
    mustBeVegetarian: false,
    excludedIngredients: ["pepperoni"],
    excludedTools: ["knife"],
    maxNumberOfToppings: 6,
    minNumberOfToppings: 2,
  };
  let res = http.post(`${BASE_URL}/api/pizza`, JSON.stringify(restrictions), {
    headers: {
      "Content-Type": "application/json",
      "X-User-ID": 23423,
      "Authorization": "token abcdef0123456789"
    },
  });
  //console.log(`${res.json().pizza.name} (${res.json().pizza.ingredients.length} ingredients)`);

  check(res, {
    'is status 200': (r) => r.status === 200,
    'body size is less than 1,000 bytes': (r) => r.body.length <= 1000
  });
}