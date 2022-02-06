import {Entity, model, property} from '@loopback/repository';

@model()
export class Gym extends Entity {
  @property({
    type: 'number',
    id: true,
    generated: true,
  })
  ID?: number;

  @property({
    type: 'string',
    required: true,
  })
  NAME: string;

  @property({
    type: 'string',
    required: true,
  })
  STREET: string;

  @property({
    type: 'string',
    required: true,
  })
  SNUM: string;

  @property({
    type: 'string',
    required: true,
  })
  POSTAL_CODE: string;

  @property({
    type: 'string',
    required: true,
  })
  CITY: string;

  @property({
    type: 'string',
    required: true,
  })
  PROVINCE: string;

  @property({
    type: 'string',
    required: true,
  })
  COUNTRY: string;

  constructor(data?: Partial<Gym>) {
    super(data);
  }
}

export interface GymRelations {
  // describe navigational properties here
}

export type GymWithRelations = Gym & GymRelations;
